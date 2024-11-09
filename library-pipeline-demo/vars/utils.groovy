/**
 * method to get repository name
 * @param repository
 * @see <a href="https://javadoc.jenkins.io/plugin/git/hudson/plugins/git/GitSCM.html">GitSCM</a>
 * @see <a href="https://javadoc.jenkins.io/plugin/git/hudson/plugins/git/UserRemoteConfig.html">getUserRemoteConfigs</a>
 * @see <a href="https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#unstable-set-stage-result-to-unstable">Pipeline: Basic Steps</a>
 */
def repositoryName(Object scm) {
    def name = scm.getUserRemoteConfigs()[0].getUrl().tokenize('/').last().split("\\.")[0]
    echo "name repository ${name}"
    return name
}


/**
 * method prepare to deploy
 */
def prepareDeploy() {
    def REPO_NAME = repositoryName(scm)
    echo "REPO_NAME ${REPO_NAME}"
    def agentLabel1 = "linux"
    def solutionProject = "ejercito-solution"
    echo "Agent: ${agentLabel1}, Group: ${solutionProject}"
    return [agentLabel1, solutionProject]
}

/**
 * method to get sonar key
 * @param mavenData
 */
def getSonarKey(Object mavenData) {
    def sonarKey = mavenData.getGroupId() + ":" + mavenData.getArtifactId()
    return sonarKey;
}

/**
 * method to get version project maven
 * @param mavenData
 */
def getVersion(Object mavenData) {
    def version = mavenData.getVersion().replace("-SNAPSHOT", "")
    return version;
}

/**
 * method to get type project
 * @param mavenData
 */
def getAppType(Object mavenData) {
    def appType = mavenData.getProperties()["app.type"]
    if (!appType) {
        appType = "service"
    }
    return appType
}

/**
 *
 * @param currentBuild
 */
def getDisplayName(currentBuild) {
    def project = currentBuild.rawBuild.project
    return "${project.parent.displayName} (${project.displayName})"
}

/**
 * method to get app solution project
 * @param mavenData
 */
def getAppSolution(Object mavenData) {
    def propSolution = mavenData.getProperties()["app.solution"]
    def solution = (propSolution != null || "" != propSolution) ? mavenData.getProperties()["app.solution"] : mavenData.getProperties()["solution"]
    if (!solution) {
        solution = ""
    }
    return solution
}