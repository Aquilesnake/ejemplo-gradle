pipeline {
    agent any

    stages {
        stage('Hello') {
            steps{
                script{
                    stage('build $ test') {
                      bat 'gradlew clean build'
                    }
                    stage('sonar') {
                        def scannerHome = tool 'sonar';
                        withSonarQubeEnv('sonar-scanner') {
                            bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build -Dsonar.login=75a0e9b0613f563c0e69a23174cf79eb5d4d74c7"

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


  
  

