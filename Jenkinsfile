pipeline {
    agent any
    stages {
        stage("build docker image") {
            steps {
              echo 'building image.....'
                script {
                    // Build the Docker image
                    docker.build('my-image:latest', '.')
                }
            }
        }
        stage("test") {
            steps {
                echo 'testing application.....'
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying application.....'
            }
        }
    }
}
