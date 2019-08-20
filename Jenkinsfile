pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building'
                sh './gradlew clean build'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Run unit tests'
                sh './gradlew test'
            }
        }
    }
}