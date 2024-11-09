package pe.mil.ejercito.pipeline

class PipelineBuilder extends PipelineBase implements Serializable {

    private boolean prepareCustom
    private boolean prepared
    private PreparePipeline preparePipeline
    private LoadEnvironment loadEnvironment
    private UnitTestsStage unitTests

    PipelineBuilder(def scriptInstance) {
        super(scriptInstance)
        this.preparePipeline = new PreparePipeline(scriptInstance)
        this.loadEnvironment = new LoadEnvironment(scriptInstance)
        this.unitTests = new UnitTestsStage(scriptInstance)
        this.prepareCustom = false
        this.prepared = false
    }

    /**
     *
     * @param branchingVersion
     * @param solutionProject
     * @return
     */
    def prepareStage(String branchingVersion = "$BRANCHING_VERSION_GITFLOW", String solutionProject = "") {
        if (!prepared && !prepareCustom) {
            this.preparePipeline.preparePipeline(branchingVersion, solutionProject)
            this.prepared = true;
        }
        if (loadEnvironment) {
            this.loadEnvironment.loadEnvironments()
        }
    }

    def dependencyCheckStage() {

    }

    def unitTestsStage(String branchingVersion = "$BRANCHING_VERSION_GITFLOW") {
        if (this.unitTests) {
            this.unitTests.execute(branchingVersion)
        }
    }
}
