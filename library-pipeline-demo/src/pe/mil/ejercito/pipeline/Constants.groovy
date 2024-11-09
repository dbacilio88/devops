package pe.mil.ejercito.pipeline

interface Constants extends Serializable {
    String BRANCHING_GRAVITON = "GravitonPipeline"
    String BRANCHING_VERSION_GITFLOW = "GitflowBased"
    String BRANCHING_VERSION_GITLAB_FLOW = "GitlabBased"
    String BRANCHING_VERSION_BACKEND = "Backend"
    String BRANCHING_MOBILE_LIB = "MobileLib"
    String BRANCHING_GRAVITON_DEPLOY = "GravitonPipelineDeploy"
    String BRANCHING_REACT_DEPLOY = "FrontEndReact"
    String BRANCHING_GO_DEPLOY = "BackendGo"
    String BRANCHING_JDK21_DEPLOY = "GitlabJdk21"
    String BRANCHING_DEPLOY_WAR = "DeployWar"
    String DEFAULT_SOLUTION = "service"
    String TAG_LOGS_SUMMARY = "{{logs-summary}}"
    String TAG_IMAGE_JACOCO = "{{image-jacoco}}"
    String TAG_TEST_REPORT_LINK = "{{test-report-link}}"
    String TAG_TITLE = "{{title}}"
    String PATH_JACOCO_RESULTS = "jacoco-results.png"

    enum PullRequestStatus {
        PENDING("pending"),
        IN_PROGRESS("in_progress"),
        SUCCESS("success"),
        FAILURE("failure"),
        ERROR("error")
        private String value;

        PullRequestStatus(final String value) {
            this.value = value;
        }

        String value() {
            return this.value;
        }
    }

    enum PipelineVersion {
        Version("GitlabBased"),
        V4("V4"),
        Backend("Backend"),
        GitflowBased("GitflowBased"),
        GitlabBased("GitlabBased"),
        GitlabBasedWout("GitlabBasedWout"),
        GitflowWout("GitflowWout"),
        ApiProxyGitflow("ApiProxyGitflow"),
        GitlabBasedWar("GitlabBasedWar"),
        DeployWar("DeployWar"),
        MobileAndroid("MobileAndroid"),
        MobileLib("MobileLib"),
        ContIntegration("CI"),
        CIGraviton("GravitonPipelineCI"),
        Deployment("deployment"),
        PROPERTY("property"),
        DEPLOY("deploy"),
        UNDEPLOY("undeploy"),
        GravitonPipeline("GravitonPipeline"),
        GravitonPipelineDeploy("GravitonPipelineDeploy"),
        FrontEndReact("FrontEndReact"),
        BackendGo("BackendGo"),
        GitlabJdk21("GitlabJdk21"),
        Microservices("Microservices")

        private String value;

        PipelineVersion(final String value) {
            this.value = value;
        }

        String value() {
            return this.value;
        }

    }
}