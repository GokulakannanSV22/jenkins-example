pipeline{
    agent any
        tools{
            jdk 'jdk-17'
            maven 'mvn'
        }
        stages{
            stage('Build Maven'){
                steps{
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/GokulakannanSV22/jenkins-example.git']])
                    bat 'mvn clean install'
                }
            }
           
        }
        post {
        always {
            mail to: '2k21csbs22@kiot.ac.in,2k21csbs20@kiot.ac.in,2k21csbs15@kiot.ac.in,2k21csbs27@kiot.ac.in',
                 subject: "Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build for ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed.\nCheck the logs for more details.\n\nBuild URL: ${env.BUILD_URL}",
                 from: 'gokulakannan2277@gmail.com'
        }
    }
}