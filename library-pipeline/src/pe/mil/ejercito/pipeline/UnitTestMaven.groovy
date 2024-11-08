package pe.mil.ejercito.pipeline

import groovy.transform.PackageScope

class UnitTestMaven extends PipelineBase implements Serializable {

    final def COMPILER_BASE = "mvn"
    final def PROPERTIES = "-Dorg.slf4j.simpleLogger.logFile='./tests.log' -B"
    final def TASKS = "test surefire-report:report"
    final def DEBUG = "--debug"
    String toolName
    String settingsName

    String args = ""
    boolean debug

    UnitTestMaven(def scriptInstance) {
        super(scriptInstance)
    }

    void withToolName(String name) {
        this.toolName = name
    }

    void withSettings(String settingsName) {
        this.settingsName = settingsName
    }

    void withDebug(boolean debug) {
        this.debug = debug
    }

    void buildArgs() {
        args = ""
        if (debug) {
            args += " ${DEBUG}"
        }

    }

    @PackageScope
    void execute() {
        if (toolName) {
            scriptInstance.withMaven(maven: this.toolName, mavenSettingsConfig: this.settingsName, publisherStrategy: 'EXPLICIT') {
                scriptInstance.sh "${COMPILER_BASE} ${PROPERTIES} ${TASKS}"
            }
        } else {
            scriptInstance.sh "${COMPILER_BASE} ${PROPERTIES} ${args} ${TASKS}"
        }
    }

    def getMavenSummary() {
        def command = 'grep -n "\\[INFO\\]  T E S T S" tests.log | cut -f1 -d:'
        def startLine = scriptInstance.sh(script: command, returnStdout: true).trim() as int
        startLine = (startLine - 1)
        command = 'grep -n "\\[INFO\\] Results:" tests.log | cut -f1 -d:'
        def endLine = scriptInstance.sh(script: command, returnStdout: true).trim() as int
        endLine = (endLine + 3)
        command = "sed -n ${startLine},${endLine}p tests.log"
        def text = scriptInstance.sh(script: command, returnStdout: true).trim()
        return text
    }

    def getMavenError() {
        def text = scriptInstance.sh(script: "cat tests.log", returnStdout: true).trim()
        return text
    }
}