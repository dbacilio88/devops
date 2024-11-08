import pe.mil.ejercito.pipeline.Constants
import pe.mil.ejercito.pipeline.PipelineBuilder

def call(String version = Constants.PipelineVersion.Version.value(), scriptInstance, boolean wout = false, boolean smc = false) {

    def builder = new PipelineBuilder(scriptInstance)
    echo "Current pipeline version: $version"
    echo "WOUT: $wout"

    switch (version) {
        case Constants.PipelineVersion.GravitonPipeline.value():
            echo "version GravitonPipeline"
            ejercitoPipelineProcess(builder, wout, smc, version)
            break
        default:
            println("The value is unknown")
            break
    }
}