properties([
    parameters([
        string(name: 'TAGS',
               defaultValue: 'smoke',
               description: 'Test tags to run: smoke, regress, api, etc.')
    ])
])

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                sh 'chmod +x gradlew'
            }
        }

        stage('Install Chrome and Dependencies') {
            steps {
                script {
                    sh '''
                    # Устанавливаем необходимые пакеты
                    apt-get update
                    apt-get install -y wget gnupg unzip libgconf-2-4 libnss3-dev libxss1 libappindicator3-1 fonts-liberation
                    
                    # Устанавливаем Chrome
                    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add -
                    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list
                    apt-get update
                    apt-get install -y google-chrome-stable
                    
                    # Получаем версию Chrome и устанавливаем совместимый ChromeDriver
                    CHROME_VERSION=$(google-chrome-stable --version | awk '{print $3}')
                    CHROME_MAJOR_VERSION=$(echo $CHROME_VERSION | cut -d'.' -f1)
                    
                    # Скачиваем и устанавливаем ChromeDriver
                    wget -O chromedriver_version.txt "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_${CHROME_MAJOR_VERSION}"
                    CHROME_DRIVER_VERSION=$(cat chromedriver_version.txt)
                    wget -O chromedriver.zip "https://chromedriver.storage.googleapis.com/${CHROME_DRIVER_VERSION}/chromedriver_linux64.zip"
                    unzip chromedriver.zip
                    mv chromedriver /usr/local/bin/
                    chmod +x /usr/local/bin/chromedriver
                    
                    # Проверяем установку
                    echo "Chrome version: $(google-chrome-stable --version)"
                    echo "ChromeDriver version: $(chromedriver --version)"
                    '''
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh """
                    # Указываем явный путь к ChromeDriver и настройки
                    ./gradlew clean test -Ptags='${params.TAGS}' \\
                        -Dselenide.browser=chrome \\
                        -Dselenide.headless=true \\
                        -Dwebdriver.chrome.driver=/usr/local/bin/chromedriver \\
                        -Dchromeoptions.args='--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--window-size=1920,1080,--remote-allow-origins=*'
                    """
                }
            }
        }
    }

    post {
        always {
            allure([
                includeProperties: false,
                results: [[path: 'build/allure-results']]
            ])
        }
    }
}
