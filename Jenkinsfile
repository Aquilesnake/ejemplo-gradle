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
                    echo 'Build realizado con exito con los siguientes datos:' + [Cristian Tapia][JOB_NAME][compilador] Ejecución exitosa
                }
                failure {
                    echo 'Build realizado con fallas con los siguientes datos:' +[CHANGE_AUTHOR][JOB_NAME][compilador] Ejecución fallida en stage [env.STAGE_NAME]
                }
            }
}

}

slackSend channel: 'U01DK54QSF6', color: 'good', message: 'ejecución exitosa', teamDomain: 'dipdevopsysach2020', tokenCredentialId: 'U01DK54QSF6'
