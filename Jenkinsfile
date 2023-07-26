pipeline {
    agent any

    tools {
        // This 'maven' must match the Maven tool configuration in your Jenkins.
        maven 'Maven 3.6.3'
    }

    stages {
        stage('Build') {
            steps {
                // Run Maven.
                sh 'mvn clean package'
                echo "packaging"
                echo 'ngrok testing...'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
                echo 'Testing...'
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    sh 'docker build -t mamatniroula1/apex-project .'
                }
            }
        }

        stage('Push docker image to hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerpwd')]) {
                        sh 'docker login -u mamatniroula1 -p MeroDockerKoPwd2021#'
                    }
                    sh 'docker push mamatniroula1/apex-project'
                }

            }
        }
    }
}
