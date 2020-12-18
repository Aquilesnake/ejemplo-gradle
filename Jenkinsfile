pipeline {
    agent any
    parameters { choice(name: 'compilador', choices:['gradle','maven'], description:'compilador de construcion para aplicacion')}
    stages{
        stage('pipeline'){
            steps{
                script{
                    echo 'herramienta seleccionada: ' + params.compilador
                    def pipe = load "${params.compilador}.groovy"
                    pipe.call()
                }
            }
        }
    }
        post {
                success {
                   slackSend channel: 'U01DK54QSF6', color: '#0ca60e', message: "Build Success: [Cristian Tapia][${env.JOB_NAME}][${params.compilador}] Ejecución exitosa", teamDomain: 'dipdevopsusach2020', tokenCredentialId: 'U01DK54QSF6'
                }
                failure {
                    slackSend channel: 'U01DK54QSF6', color: '#ba150f', message: "Build Failure: [Cristian Tapia][${env.JOB_NAME}][${params.compilador}] Ejecución fallida en stage [${env.STAGE_NAME}]", teamDomain: 'dipdevopsusach2020', tokenCredentialId: 'U01DK54QSF6'
                  
                }
        }
}

