package pe.mil.ejercito.pipeline

class Artifacts extends PipelineBase implements Serializable {

    Artifacts(scriptInstance) {
        super(scriptInstance)
    }

    def archive(String artifactsPath, boolean allowEmpty = false) {
        scriptInstance.archiveArtifacts(artifacts: "$artifactsPath", allowEmptyArchive: allowEmpty)
    }

    def saveJunitReports(String path, boolean allowEmpty, boolean skipChecks) {
        scriptInstance.junit(testResults: path, allowEmptyResults: allowEmpty, skipPublishingChecks: skipChecks)
    }

    def saveJacocoReports(String execPath, String classPath, String sourcePath, String exclusionPath) {
        scriptInstance.jacoco(
                execPattern: execPath,
                classPattern: classPath,
                sourcePattern: sourcePath,
                exclusionPattern: exclusionPath
        )
    }

    def zipFiles(String path, boolean archive, String glob, boolean override) {
        scriptInstance.zip zipFile: path, archive: archive, glob: glob, overwrite: override
    }

    def dependencyCheckPublisher(String dependencyCheckReportPath) {
        scriptInstance.dependencyCheckPublisher(
                pattern: "$dependencyCheckReportPath"
        )
    }

    def execute() {
        if (scriptInstance.IS_MAVEN_COMPILER) {
            archive("**/target/*.jar", true)
        } else {
            archive("**/build/libs/*.jar", true)
        }
    }
}