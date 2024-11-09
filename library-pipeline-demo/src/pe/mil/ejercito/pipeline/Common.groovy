package pe.mil.ejercito.pipeline

class Common extends PipelineBase implements Serializable {

    Common(def scriptInstance) {
        super(scriptInstance)
    }

    def copyFiles(def changedFiles) {
        scriptInstance.echo "coping files, files list: $changedFiles"
        scriptInstance.sh "rsync -r ./api-microservices/* ${scriptInstance.env.BASE_PATH}/api-microservices/"
        scriptInstance.sh "rsync -r ./microservices-core/* ${scriptInstance.env.BASE_PATH}/microservices-core/"

    }
}