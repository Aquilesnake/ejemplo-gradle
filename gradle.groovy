/*
forma de invocacion de metodo call; 

def ejecucion = load 'script.groovy'
ejecucion.call()

*/
def call (){
    stage('sonar') {
         def scannerHome = tool 'sonar';
             withSonarQubeEnv('sonar') {
                bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=maven-gradle -Dsonar.host.url=http://localhost:9000 -Dsonar.login=7cb9a6e8d0c11a1f0a6fc274daa67930a19b8234"
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
return this;