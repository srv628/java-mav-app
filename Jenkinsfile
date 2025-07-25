#!/bin/env groovy
@Library('jenkins-shared-lib') _ // Ensure the library is correctly configured in Jenkins
def gv

pipeline {
    agent any
    tools {
        maven 'maven_3.9' // Ensure the name matches exactly as configured in Jenkins
    }
    environment {
    IMAGE_NAME = 'srvwin/dockerinitial:javamapp-3.0' // Define the image name as an environment variable}
    }


    stages {

        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('building the jar file') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('building the docker image') {
            steps {
                script {
                    buildImage(env.IMAGE_NAME) // Ensure the method name is correct (buildImage instead of buildimage)
                }
            }
        }
        stage('deploying the image to the docker hub') {
            steps {
                script {
//                     deployImage(env.IMAGE_NAME)
    def dockerComposeRunCommand = "docker-compose -f docker-compose.yaml up -d"
    echo "deploying the code"

    sshagent(['ec2-node-react']) {


        sh "scp docker-compose.yml ec2-user@13.201.186.86:/home/ec2-user/"
        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.201.186.86 ${dockerComposeRunCommand}"

                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs.'
        }
    }
}