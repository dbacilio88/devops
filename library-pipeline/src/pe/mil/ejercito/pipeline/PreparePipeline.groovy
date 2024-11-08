package pe.mil.ejercito.pipeline

class PreparePipeline extends PipelineBase implements Serializable {

    private GlobalConfigBuilder globalConfigBuilder
    private static final String STATIC_CONFIG = "static_environment.env"

    PreparePipeline(def scriptInstance) {
        super(scriptInstance)
        this.globalConfigBuilder = new GlobalConfigBuilder(scriptInstance)
    }

    def preparePipeline(String branchingVersion, String solutionProject) {
        scriptInstance.LAST_STEP = scriptInstance.env.STAGE_NAME
        this.globalConfigBuilder.withConfig(STATIC_CONFIG).execute();

        def hasCompiler = false

        switch (branchingVersion) {

            case BRANCHING_VERSION_GITFLOW:
                break
            case BRANCHING_VERSION_GITLAB_FLOW:
                if (!scriptInstance.fileExists(scriptInstance.BUILDER_MAVEN_FILE)) {
                    scriptInstance.echo("NO MAVEN AND GRADLE NO IMPLEMENT ${scriptInstance.BUILDER_MAVEN_FILE}")
                } else if (scriptInstance.fileExists(scriptInstance.BUILDER_MAVEN_FILE)) {
                    scriptInstance.echo("EXISTE POM")
                    prepareMaven()
                    hasCompiler = true
                } else {
                    scriptInstance.echo("No cuenta con pom o build.gradle")
                    hasCompiler = false
                    scriptInstance.error(message: "No cuenta con pom o build.gradle")
                }
                break
            default:
                println("The value is unknown")
                break
        }

        if (hasCompiler) {
            scriptInstance.sh "$scriptInstance.COMPILER_BASE clean"
            scriptInstance.env.REPOSITORY_EMAIL = scriptInstance.sh(returnStdout: true, script: 'git --no-pager show -s --format=\'%ae\' --ignore-cr-at-eol').trim()
            scriptInstance.env.COMMITID = scriptInstance.sh(returnStdout: true, script: 'git log --format=\'%h\' -n1').take(4)
            scriptInstance.env.PREFIX = ".B${scriptInstance.env.COMMITID}"
            scriptInstance.env.PREFIX_DISPLAY = ".B${scriptInstance.env.COMMITID}"
            scriptInstance.env.DISPLAY = ".B${scriptInstance.env.COMMITID}"
        }

        if (branchingVersion == BRANCHING_VERSION_GITLAB_FLOW) {
            if (scriptInstance.env.BRANCH_NAME.startsWith("fix")) {
                scriptInstance.env.PREFIX = "-fix" + scriptInstance.env.PREFIX
                scriptInstance.env.DISPLAY = ""
            } else if (scriptInstance.env.BRANCH_NAME.startsWith("release")) {
                scriptInstance.env.PREFIX = "-rls" + scriptInstance.env.PREFIX
                scriptInstance.env.DISPLAY = ""
            } else {
                scriptInstance.env.DISPLAY = ""
            }
        } else if (branchingVersion == BRANCHING_VERSION_GITFLOW) {
            if (scriptInstance.env.BRANCH_NAME == "master" || scriptInstance.env.BRANCH_NAME == "main") {
                scriptInstance.env.PREFIX = ""
            } else if (scriptInstance.env.BRANCH_NAME == "release") {
                scriptInstance.env.PREFIX = "-alpha"
            } else if (scriptInstance.env.BRANCH_NAME == "deploy-uat") {
                scriptInstance.env.PREFIX = "-beta"
            } else if (scriptInstance.env.BRANCH_NAME.startsWith("fix/") || scriptInstance.env.BRANCH_NAME.startsWith("bugfix/") || scriptInstance.env.BRANCH_NAME.startsWith("hotfix/")) {
                scriptInstance.env.PREFIX = "-alpha"
            } else {
                scriptInstance.env.DISPLAY = ""
            }
        } else {
            scriptInstance.echo("[BRANCHING_VERSION_GITFLOW NO VALUE]")
        }

        scriptInstance.env.IMAGE_TAG = "${scriptInstance.env.VERSION_NUM}${scriptInstance.env.PREFIX}"
        scriptInstance.env.DISPLAY_NAME = "${scriptInstance.env.VERSION_NUM}${scriptInstance.env.PREFIX_DISPLAY}"
        scriptInstance.env.ENVIRONMENT = "dev"

        if (branchingVersion == BRANCHING_VERSION_GITLAB_FLOW) {
            if (scriptInstance.env.BRANCH_NAME == "master" || scriptInstance.env.BRANCH_NAME == "main") {
                scriptInstance.env.ENVIRONMENT = "dev"
            } else if (scriptInstance.env.BRANCH_NAME.startsWith("release/")) {
                scriptInstance.env.ENVIRONMENT = "test"
            }
        } else if (branchingVersion == BRANCHING_VERSION_GITFLOW) {
            if (scriptInstance.env.BRANCH_NAME == "master") {
                scriptInstance.env.ENVIRONMENT = "prod"
            } else if (scriptInstance.env.BRANCH_NAME == "develop") {
                scriptInstance.env.ENVIRONMENT = "dev"
            } else if (scriptInstance.env.BRANCH_NAME == "deploy-uat") {
                scriptInstance.env.ENVIRONMENT = "uat"
            } else if (scriptInstance.env.BRANCH_NAME.startsWith("release")) {
                scriptInstance.env.ENVIRONMENT = "test"
            }
        } else {
            scriptInstance.echo("[NO VALUE]")
        }

        if (branchingVersion != PipelineVersion.DEPLOY.value()) {
            scriptInstance.env.REGISTRY_IMAGE = "${scriptInstance.REGISTRY_URL}/" + scriptInstance.env.IMAGE + ":" + scriptInstance.env.IMAGE_TAG
        }

        scriptInstance.env.JOB_NAME_F = scriptInstance.utils.getDisplayName(scriptInstance.currentBuild)
        scriptInstance.currentBuild.displayName = scriptInstance.env.DISPLAY_NAME
    }

    def prepareMaven() {
        def dataMaven = scriptInstance.readMavenPom()
        scriptInstance.env.SONAR_KEY = scriptInstance.utils.getSonarKey(dataMaven)
        scriptInstance.env.APP_NAME = scriptInstance.utils.repositoryName(scriptInstance.scm)
        scriptInstance.env.IMAGE = scriptInstance.env.APP_NAME
        scriptInstance.env.VERSION_NUM = scriptInstance.utils.getVersion(dataMaven)
        scriptInstance.env.VERSION = dataMaven.getVersion()
        scriptInstance.env.APP_TYPE = scriptInstance.utils.getAppType(dataMaven)
        scriptInstance.env.SOLUTION = scriptInstance.utils.getAppSolution(dataMaven)
    }


    String readGradleProperty(String propertyFile, String property) {
        return scriptInstance.sh(script: "cat ${propertyFile} | grep '${property}:' | awk '{print \$2}'", returnStdout: true).trim()
    }
}