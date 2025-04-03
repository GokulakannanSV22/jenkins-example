pipeline {

    agent any

    tools {

        jdk 'jdk-17'

        maven 'mvn'

    }

    stages {

        stage('Build Maven') {

            steps {

                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/GokulakannanSV22/jenkins-example.git']])

                bat 'mvn clean install'

            }

        }

    }
    stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t gokulakannansv/docker-example .'
                }
            }
        }

stage('Push Image to DockerHub') {
            steps {
                script {
                        bat "docker login"
                        bat 'docker push gokulakannansv/docker-example'
                }
            }
   
}
}