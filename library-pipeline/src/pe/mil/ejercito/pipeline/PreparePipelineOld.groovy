package pe.mil.ejercito.pipeline

class PreparePipelineOld extends PipelineBase implements Serializable {

    private GlobalConfigBuilder globalConfigBuilder
    private static final String STATIC_CONFIG = "static_environment.env"

    PreparePipelineOld(def scriptInstance) {
        super(scriptInstance)
        this.globalConfigBuilder = new GlobalConfigBuilder(scriptInstance)
    }


    def prepareMaven() {
        def projectData = scriptInstance.readMavenPom()
        scriptInstance.env.SONAR_KEY = scriptInstance.utils.getSonarKey(projectData)
        scriptInstance.env.APP_NAME = scriptInstance.utils.getRepositoryName(scriptInstance.scm)
        scriptInstance.env.IMAGE = scriptInstance.env.APP_NAME
        scriptInstance.env.VERSION_NUM = scriptInstance.utils.getVersion(projectData)
        scriptInstance.env.VERSION = projectData.getVersion()
        scriptInstance.env.APP_TYPE = scriptInstance.utils.getAppType(projectData)
        scriptInstance.SOLUTION = scriptInstance.utils.getAppSolution(projectData)
    }

    def prepareReact() {
        scriptInstance.COMPILER = "npm"
        scriptInstance.IS_MAVEN_COMPILER = false
        scriptInstance.COMPILER_BASE = "npm"
        scriptInstance.env.SOLUTION = scriptInstance.readjson.getPropertyValuesFromJsonFile("solution")
        scriptInstance.env.VERSION_NUM = scriptInstance.readjson.getPropertyValuesFromJsonFile("version")
        scriptInstance.env.APP_NAME = scriptInstance.utils.getRepositoryName(scriptInstance.scm)
        scriptInstance.env.IMAGE = scriptInstance.env.APP_NAME
        scriptInstance.env.SONAR_KEY = "${scriptInstance.env.SOLUTION}:${scriptInstance.env.APP_NAME}"
    }

    def prepareGo() {
        scriptInstance.env.SOLUTION = scriptInstance.readxml.getPropertyValuesFromYamlFile("solution")
        scriptInstance.env.VERSION_NUM = scriptInstance.readxml.getPropertyValuesFromYamlFile("microserviceVersion")
        scriptInstance.env.APP_NAME = scriptInstance.utils.getRepositoryName(scriptInstance.scm)
        scriptInstance.env.IMAGE = scriptInstance.env.APP_NAME
        scriptInstance.env.SONAR_KEY = "${scriptInstance.env.SOLUTION}:${scriptInstance.env.APP_NAME}"
    }

    def prepareGradle(branchingVersion) {
        scriptInstance.COMPILER = "gradle"
        scriptInstance.IS_MAVEN_COMPILER = false
        scriptInstance.COMPILER_BASE = "sh gradlew"

        if (!scriptInstance.fileExists("./gradle/wrapper/gradle-wrapper.jar")) {
            scriptInstance.sh 'gradle wrapper'
        }

        def propertyFile = 'properties.tmp'
        scriptInstance.sh "chmod +x ./gradlew"
        scriptInstance.sh "./gradlew -q properties > ${propertyFile}"
        scriptInstance.env.FOLDER = readGradleProperty(propertyFile, 'pipelineFolderModule')
        scriptInstance.env.PIPE_VERSION = readGradleProperty(propertyFile, 'pipelineVersion')
        scriptInstance.env.VERSION_NUM = readGradleProperty(propertyFile, 'sdk_version_number')
        scriptInstance.env.VERSION = readGradleProperty(propertyFile, 'sdk_version_number')
        scriptInstance.env.SOLUTION = readGradleProperty(propertyFile, 'pipelineSolution')
        scriptInstance.env.APP_NAME = scriptInstance.utils.getRepositoryName(scriptInstance.scm)
        scriptInstance.env.SONAR_KEY = "${scriptInstance.env.SOLUTION}:${scriptInstance.env.APP_NAME}"
    }

    def prepareGradle() {
        scriptInstance.COMPILER = "gradle"
        scriptInstance.IS_MAVEN_COMPILER = false
        scriptInstance.env.GRADLE_USER_HOME = scriptInstance.env.JENKINS_HOME + "/.gradle"

        scriptInstance.COMPILER_BASE = "sh gradlew"
        scriptInstance.sh 'gradle wrapper'

        def propertyFile = 'properties.tmp'
        scriptInstance.sh "chmod +x ./gradlew"

        scriptInstance.sh "gradle -q properties > ${propertyFile}"
        scriptInstance.env.VERSION = readGradleProperty(propertyFile, 'version')
        scriptInstance.env.VERSION_NUM = scriptInstance.env.VERSION.replace("-SNAPSHOT", "")
        scriptInstance.env.APP_NAME = scriptInstance.utils.getRepositoryName(scriptInstance.scm)
        scriptInstance.env.IMAGE = scriptInstance.env.APP_NAME
        scriptInstance.SOLUTION = readGradleProperty(propertyFile, 'solution') ? readGradleProperty(propertyFile, 'solution') : readGradleProperty(propertyFile, 'app.solution')
        scriptInstance.env.SONAR_KEY = readGradleProperty(propertyFile, 'group') + ':' + scriptInstance.env.IMAGE
        scriptInstance.env.APP_TYPE = readGradleProperty(propertyFile, 'type')

    }

    String readGradleProperty(String propertyFile, String property) {
        return scriptInstance.sh(script: "cat ${propertyFile} | grep '${property}:' | awk '{print \$2}'", returnStdout: true).trim()
    }
}