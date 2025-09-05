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
                    // Пробуем разные варианты настроек Selenide
                    sh """
                    # Вариант 1: Пробуем с базовыми настройками
                    ./gradlew clean test -Ptags='${params.TAGS}' \\
                        -Dselenide.browser=chrome \\
                        -Dselenide.headless=true \\
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
