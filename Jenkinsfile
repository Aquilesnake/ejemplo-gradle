pipeline {
   agent any
   stages {
               stage('compiled') {
                   steps {
                       dir('C:\\Users\\AKLSNK\\Desktop\\clases DevOps\\Develoment\\Jenkinsfile\\ejemplo-maven'){
                                   bat './mvnw.cmd clean compile -e'
                       }
                   }
               }
               stage('test') {
                   steps {
                       sleep 10
                       dir('C:\\Users\\AKLSNK\\Desktop\\clases DevOps\\Develoment\\Jenkinsfile\\ejemplo-maven'){
                          bat './mvnw.cmd clean test -e'
                       }
                   }
               }
               stage('jar') {
                   steps {
                       sleep 10
                        dir('C:\\Users\\AKLSNK\\Desktop\\clases DevOps\\Develoment\\Jenkinsfile\\ejemplo-maven'){
                              bat './mvnw.cmd clean package -e'
                        }
                   }
               }
               stage('sonar') {
                   steps {
                       sleep 20
                       dir('C:\\Users\\AKLSNK\\Desktop\\clases DevOps\\Develoment\\Jenkinsfile\\ejemplo-maven'){
                             bat 'mvnw sonar:sonar -Dsonar.projectKey=feature-nexus -Dsonar.host.url=http://localhost:9000 -Dsonar.login=68d4f26a12047156448d12b991d2ed5aab830f4a'
                       }
                   }
               }
                stage ('Publishing'){
                    steps {
        nexusPublisher nexusInstanceId: 'nexus-remoto', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\AKLSNK\\Desktop\\clases DevOps\\Develoment\\Jenkinsfile\\ejemplo-maven\\build\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'org.springframework.boot', packaging: 'jar', version: '0.0.1']]], tagName: ''
                     }
                }
   }
}
