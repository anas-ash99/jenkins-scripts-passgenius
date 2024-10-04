package com.passgenius


class DockerBuildUtils{
    static void buildAndPushDockerImage(String imageTag, String imageVersion, String dockerCredentialsId) {
        // Build Docker Image
        echo 'Building Docker Image...'
        bat "docker build -t ${imageTag}:${imageVersion} ."

        // Push Docker Image
//        docker.withRegistry('', dockerCredentialsId) {
//            echo 'Pushing Docker Image...'
//            bat "docker push ${imageTag}:${imageVersion}"
//        }
    }

}

