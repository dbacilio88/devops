package pe.mil.ejercito.pipeline

class PipelineBase implements Serializable, Constants {

    def scriptInstance

    PipelineBase(def scriptInstance) {
        this.scriptInstance = scriptInstance
    }

    def instance() {
        return this.scriptInstance;
    }

}