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
                            bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build -Dsonar.login=d4167fce436e669acff54aaa33d5b517ecf1f5eb"

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


  
  

