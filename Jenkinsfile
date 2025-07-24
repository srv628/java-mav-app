#!/bin/env groovy
@Library('jenkins-shared-lib') // Ensure the library is correctly configured in Jenkins
def gv

pipeline {
    agent any
    tools {
        maven 'maven_3.9' // Ensure the name matches exactly as configured in Jenkins
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
                    buildImage() // Ensure the method name is correct (buildImage instead of buildimage)
                }
            }
        }
        stage('deploying the image to the docker hub') {
            steps {
                script {
                    gv.deployApp()
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