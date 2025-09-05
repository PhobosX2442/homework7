properties([
    parameters([
        string(name: 'TAGS',
               defaultValue: 'smoke',
               description: 'Test tags to run: smoke, regress, api, etc.')
    ])
])

pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-17' // или образ с уже установленным браузером
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

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
                    # Просто запускаем тесты - Selenide сам скачает браузер если нужно
                    ./gradlew clean test -Ptags='${params.TAGS}' \
                        -Dselenide.browser=chrome \
                        -Dselenide.headless=true
                    """
                }
            }
        }
    }

    post {
        always {
            allure includeProperties: false,
                   results: [[path: 'build/allure-results']]
        }
    }
}
