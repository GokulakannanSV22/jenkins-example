pipeline {
      agent {
        docker {
            image 'openjdk:17-jdk-slim'  // Run pipeline inside a container with JDK
            args '-u root'  // Run as root to avoid permission issues
        }
    }
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
            withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                bat 'docker login -u %DOCKER_USER% -p %DOCKER_PASS%'
                bat 'docker push gokulakannansv/docker-example'
            }
        }
    }
}

    }  // <-- Missing closing bracket added here
}
