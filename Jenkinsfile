pipeline {
    agent any
    tools{
        maven 'maven'
    }
     environment {
        registry = "kirtiverma6/assignment3"
        registryCredential = 'docker_id'
        dockerImage = ''
    }
    stages {
        stage('Cloning our Git') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/kirtiverma6/demo.git']])
                sh 'mvn clean install'
            }
        }
         
        stage('Build  docker image'){
            steps{
                script{
                    
                    sh 'docker build -t kirti-demo .'
                }
            }
            
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build(registry + ":$BUILD_NUMBER")
                }
            }
        }
        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
         stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}
        
    
    
