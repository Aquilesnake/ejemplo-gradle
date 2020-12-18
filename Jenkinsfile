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
                    slackSend channel: 'U01DK54QSF6', color: 'good', message: 'Build Success: CristianTapia' + [env.JOB_NAME][params.compilador]+'Ejecución exitosa', teamDomain: 'dipdevopsusach2020', tokenCredentialId: 'U01DK54QSF6'
                   /* echo 'Build realizado con exito con los siguientes datos: Cristian Tapia' + [env.JOB_NAME][compilador]*/
                }
                failure {
                    slackSend channel: 'U01DK54QSF6', color: 'red', message: 'Build Failure: CristianTapia' + [env.JOB_NAME][params.compilador]+'Ejecución fallida en stage'+[env.STAGE_NAME], teamDomain: 'dipdevopsusach2020', tokenCredentialId: 'U01DK54QSF6'
                   /* echo 'Build realizado con fallas con los siguientes datos: Cristian Tapia' + [env.JOB_NAME][compilador][env.STAGE_NAME]*/
                }
        }
}
