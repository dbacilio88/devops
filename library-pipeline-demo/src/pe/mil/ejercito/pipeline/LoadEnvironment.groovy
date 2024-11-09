package pe.mil.ejercito.pipeline

class LoadEnvironment extends PipelineBase implements Serializable {

    private static final String ENV_CONFIG_PATH = "environment.env"
    private GlobalConfigBuilder globalConfigBuilder

    LoadEnvironment(scriptInstance) {
        super(scriptInstance)
        this.globalConfigBuilder = new GlobalConfigBuilder(scriptInstance)
    }

    def loadEnvironments() {
        def content = this.globalConfigBuilder.getConfigContent(ENV_CONFIG_PATH)
        def lines = content.split("\n")
        lines.each {
            scriptInstance.println(it)
            if (it.trim().isEmpty()) {
                def data = it.split("=")
                def variable = data[0]
                def value = data[1]
                scriptInstance.env["$variable"] = value
            }
        }
    }
}