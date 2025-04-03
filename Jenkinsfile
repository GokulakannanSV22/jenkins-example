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
					withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USER')]) {
    // some block
                    bat "docker login -u %DOCKER_USER% -p %DOCKER_PASSWORD%"
                    }
                    bat 'docker push gokulakannansv/docker-example'
                }
            }
        }
    }  // <-- Missing closing bracket added here
}
