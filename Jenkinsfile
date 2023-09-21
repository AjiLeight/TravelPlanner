pipeline {
    agent any
    options{
            buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '5'))
            timestamps()
        }
        environment{

            registry = "leight89/travelplanner"
            registryCredential = 'dockerhub'
        }
    stages {
        stage("build docker image") {
            steps {
                script {
                    dockerImage = docker.build registry
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
