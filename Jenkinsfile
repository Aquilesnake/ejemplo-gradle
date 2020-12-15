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
                        withSonarQubeEnv('sonar') {
                            bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build -Dsonar.login=d4167fce436e669acff54aaa33d5b517ecf1f5eb"

                         }                     
                    }
                    stage('run') {
                        
                        bat 'start gradlew bootRun &'
                        sleep 20
                    }
                     stage('rest') {
                          bat "curl -X GET http://localhost:8082/rest/mscovid/test?msg=testing"

                    }
                    stage('nexus') {
                        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

                    }
                }
            }
        }
    }
}


  
  

