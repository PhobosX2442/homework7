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

        stage('Install Chrome') {
            steps {
                script {
                    sh '''
                    # Устанавливаем зависимости
                    apt-get update
                    apt-get install -y wget gnupg2
                    
                    # Добавляем репозиторий Chrome
                    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add -
                    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list
                    
                    # Устанавливаем Chrome
                    apt-get update
                    apt-get install -y google-chrome-stable
                    
                    # Проверяем установку
                    echo "Chrome version:"
                    google-chrome-stable --version
                    '''
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh """
                    # Запускаем тесты с настройками для Selenide
                    ./gradlew clean test -Ptags='${params.TAGS}' \\
                        -Dselenide.browser=chrome \\
                        -Dselenide.headless=true \\
                        -Dchromeoptions.args='--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--window-size=1920,1080'
                    """
                }
            }
        }
    }

    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'build/allure-results']],
                report: 'build/allure-report'
            ])
        }
    }
}
