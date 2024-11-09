package pe.mil.ejercito.pipeline

import groovy.transform.PackageScope

class UnitTestGradle extends PipelineBase implements Serializable {

    final def COMPILER_BASE = "sh gradlew"
    final def TASKS = "test"
    final def DEBUG = "--debug"

    def args
    String gradleHome
    boolean debug

    UnitTestGradle(scriptInstance) {
        super(scriptInstance)
    }

    void withGradleHome(String gradleHome) {
        this.gradleHome = gradleHome
    }

    void withDebug(boolean debug) {
        this.debug = debug
    }

    void buildArgs() {
        args = ""
        if (debug) {
            args += " ${DEBUG}"
        }

        if (gradleHome) {
            args += " -g ${gradleHome}"
        }
    }

    @PackageScope
    void execute() {
        buildArgs()
        scriptInstance.sh "${COMPILER_BASE} ${args} ${TASKS}"
    }
}