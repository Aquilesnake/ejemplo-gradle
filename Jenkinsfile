pipeline {
    agent any

    stages {
        stage('Hello') {
            steps{
                script{
                    stage('build $ test') {
                      bat './gradlew clean build'
                    }
                    stage('sonar') {
                        def scannerHome = tool 'sonar';
                        withSonarQubeEnv('sonar-scanner') {
                            sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
                         }                     
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


  
  

