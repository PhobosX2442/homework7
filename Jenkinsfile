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

        stage('Run Tests') {
    steps {
        script {
            sh """
            # Запускаем Selenium Server
            wget -O selenium-server.jar https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.20.0/selenium-server-4.20.0.jar
            nohup java -jar selenium-server.jar standalone --host 0.0.0.0 --port 4444 > selenium.log 2>&1 &
            sleep 10
            
            # Запускаем тесты
            ./gradlew clean test -Ptags='${params.TAGS}' \\
                -Dselenide.browser=chrome \\
                -Dselenide.headless=true \\
                -Dselenide.remote=http://localhost:4444/wd/hub \\
                -Dchromeoptions.args='--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--window-size=1920,1080,--remote-allow-origins=*'
            """
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
