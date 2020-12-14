pipeline {
    agent any

    stages {
        stage('Hello') {
            steps{
                script{
                    stage('build $ test') {
                       bat 'gradle build' 
                       bat 'gradle test'        
                    }
                    stage('sonar') {

                    }
                    stage('run') {

                    }
                     stage('rest') {

                    }
                    stage('nexus') {

                    }

                }
            }
        }
    }
}

