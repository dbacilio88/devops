package pe.mil.ejercito.pipeline

import groovy.transform.PackageScope

class UnitTestsStage extends PipelineBase implements Serializable {

    private PullRequestCheck pullRequestCheck
    private UnitTestMaven unitTestMaven
    private UnitTestGradle unitTestGradle
    private PreparePipeline preparePipeline
    private GlobalConfigBuilder globalConfigBuilder
    private Artifacts artifacts

    UnitTestsStage(def scriptInstance) {
        super(scriptInstance)
        this.pullRequestCheck = new PullRequestCheck(scriptInstance)
        this.unitTestMaven = new UnitTestMaven(scriptInstance)
        this.unitTestGradle = new UnitTestGradle(scriptInstance)
        this.preparePipeline = new PreparePipeline(scriptInstance)
        this.globalConfigBuilder = new GlobalConfigBuilder(scriptInstance)
        this.artifacts = new Artifacts(scriptInstance)
    }

    @PackageScope
    def execute(String branchingVersion) {
        String CONTEXT_GH_PR = "${scriptInstance.CONTEXT_GH_PR_PREFIX} Unit Tests"
        String DESCRIPTION_GH_PR = 'Running Unit Tests'
        String URL_GH_PR = "${scriptInstance.env.JOB_URL}${scriptInstance.env.BUILD_NUMBER}/testReport"
        scriptInstance.LAST_STEP = scriptInstance.env.STAGE_NAME
        String results = ""
        String details = ""


        try {
            pullRequestCheck.publishCheck("${CONTEXT_GH_PR}", "IN_PROGRESS", "${CONTEXT_GH_PR}", "### :yellow_circle: In Progress", "Running...", "${URL_GH_PR}")
            scriptInstance.echo("validating compiler")

        } catch (err) {
            details = """### Message:\n${err.getMessage()} \n### Cause:\n${err.getCause()} \n### SrackTtrace:\n```\n${err.getStackTrace()}\n```"""
            pullRequestCheck.publishCheck("${CONTEXT_GH_PR}", "COMPLETED", "${CONTEXT_GH_PR}", "Failed Unit Tests", details, "${URL_GH_PR}", "FAILURE")
            scriptInstance.error("Exception Thrown")
        }
    }


    def buildSummary(String title) {
        String template = this.globalConfigBuilder.getConfigContent("markdown/summary-template.md")
        def details = template.replace(TAG_TITLE, title)
    }

    def buildCheckTestDetails(String testsResults, String testReportLink) {
        String template = this.globalConfigBuilder.getConfigContent("markdown/unit-test-details-template.md")
        this.globalConfigBuilder.getConfigFile("scripts/python/htmlToImage.py", "./htmlToImage.py")
        def details = template.replace(TAG_LOGS_SUMMARY, testsResults)
        details = details.replace(TAG_TEST_REPORT_LINK, testReportLink)
        return details
    }

    def saveReports(String branchingVersion) {

        def jacocoExecPath = "**/target/test-results/jacoco/**/*.exec"
        def jacocoClassPath = "target/classes"
        def jacocoSrcPath = "src/main/java"
        def jacocoExclusionPath = "src/test*"
        def jacocoTestResults = "**/target/test-results/jacoco/**/*.html"
        def surefireTestResults = "**/target/site/surefire-report.html"
        def junitPath = "**/target/test-results/surefire/**/*.xml"
        def zipGlobPath = "target/test-results/**"

        if (!scriptInstance.IS_MAVEN_COMPILER) {
            jacocoExecPath = "**/build/jacoco/**/*.exec"
            jacocoClassPath = "build/classes"
            jacocoSrcPath = "src/main/java"
            jacocoExclusionPath = "src/test*"
            jacocoTestResults = "**/build/reports/jacoco/**/*.html"
            surefireTestResults = "**/target/site/surefire-report.html" //Verificar la ruta de gradle
            junitPath = "**/build/test-results/test/*.xml"
            zipGlobPath = "**/build/reports/**"
        }

        if (scriptInstance.IS_MAVEN_COMPILER) {
            this.artifacts.archive(surefireTestResults, true)
        }

        this.artifacts.saveJacocoReports(jacocoExecPath
                , jacocoClassPath
                , jacocoSrcPath
                , jacocoExclusionPath)

        this.artifacts.saveJunitReports(junitPath, true, true)

        this.artifacts.archive(jacocoTestResults, true)
        this.artifacts.zipFiles("test-reports.zip", true, zipGlobPath, true)
    }

}