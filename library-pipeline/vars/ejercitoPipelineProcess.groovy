import pe.mil.ejercito.pipeline.PipelineBuilder

def call(PipelineBuilder builder, boolean wout, boolean smc, String version) {

    def agentLabel = "linux"
    def solutionProject = ""

    pipeline {

        agent none

        tools {
            maven '3.9.6'
            gradle '7.6.4'
        }

        options {
            disableConcurrentBuilds()
            timeout(time: 30, unit: 'MINUTES')
        }

        environment {
            BUILDER_GRADLE_FILE = 'build.gradle'
            IS_MAVEN_COMPILER = true
            BUILDER_MAVEN_FILE = 'pom.xml'
            COMPILER = "maven"
            REGISTRY_URL = "http://localhost:8082"
            CONTEXT_GH_PR_PREFIX = 'CI/CD -'
        }

        stages {
            /**************************************************************************/
            stage("Setting Up & Initialising Env") {
                agent {
                    label agentLabel
                }
                steps {
                    echo "Setting Up & Initialising Env"
                    sh "ls -la"

                    script {
                        (agentLabel, solutionProject) = utils.prepareDeploy()

                        if (agentLabel == null) {
                            agentLabel = "linux"
                        }
                        sh "ls -la"

                        builder.prepareStage("GitlabBased", solutionProject)
                    }
                }
            }
            /**************************************************************************/
            stage("Unit Test") {
                agent {
                    label agentLabel
                }

                steps {
                    script {
                        if (version == "GravitonPipelineDeploy") {
                            echo "Pipeline Graviton para despliegue"
                        } else {
                            if (!wout) {
                                echo "Pipeline Graviton test"
                                builder.unitTestsStage()
                            } else {
                                try {
                                    echo "Pipeline Graviton test else"
                                    builder.unitTestsStage()
                                } catch (err) {
                                    unstable(message: "̣La etapa '${env.STAGE_NAME}' presenta problemas. Por favor validar el log.")
                                }
                            }
                        }
                    }
                }
                post {
                    always {
                        script {
                            echo "WOUT test post: $wout"
                            if (version == "GravitonPipelineDeploy") {
                                echo "Pipeline Graviton para despliegue post"
                            } else {
                                if (!wout) {
                                    echo "Pipeline Graviton test post"
                                } else {
                                    try {
                                        echo "Pipeline Graviton test else post"
                                    } catch (err) {
                                        unstable(message: "̣La etapa '${env.STAGE_NAME}' presenta problemas. Por favor validar el log.")
                                    }
                                }
                            }
                        }

                    }
                }
            }
            /**************************************************************************/

            stage("Dependencies, Code Scan & Bugs") {
                agent none
                steps {
                    script {
                        if (version == "GravitonPipelineDeploy") {
                            echo "Pipeline Graviton para despliegue"
                        } else {
                            /*
                            parallel(
                                    verify: {
                                        script {
                                            node(agentLabel) {
                                                unstash 'project-information'
                                                if (!wout) {
                                                    try {
                                                        echo "Pipeline verify"
                                                    } finally {
                                                        echo "Pipeline finally"
                                                    }
                                                } else {
                                                    try {
                                                        echo "Pipeline verify else"
                                                    } catch (err) {
                                                        unstable(message: "̣La etapa '${env.STAGE_NAME}' presenta problemas. Por favor validar el log.")
                                                    } finally {
                                                        echo "Pipeline finally else"
                                                    }
                                                }
                                                stash name: 'project-information', useDefaultExcludes: false
                                            }
                                        }

                                    },
                                    analysts: {
                                        script {
                                            node(agentLabel) {
                                                if (!wout) {
                                                    try {
                                                        unstash 'project-information'
                                                        echo "Pipeline analysts"
                                                    } finally {
                                                        echo "Pipeline analysts finally"
                                                        stash name: 'project-information', useDefaultExcludes: false
                                                    }
                                                } else {
                                                    try {
                                                        unstash 'project-information'
                                                        echo "Pipeline analysts else"
                                                    } catch (err) {
                                                        unstable(message: "̣La etapa '${env.STAGE_NAME}' presenta problemas. Por favor validar el log.")
                                                    } finally {
                                                        echo "Pipeline analysts finally else"
                                                        stash name: 'project-information', useDefaultExcludes: false
                                                    }
                                                }
                                            }
                                        }

                                    },
                                    bugs: {
                                        script {
                                            node(agentLabel) {
                                                unstash 'project-information'
                                                if (!wout) {
                                                    try {
                                                        echo "Pipeline bugs"
                                                    } finally {
                                                        echo "Pipeline bugs finally"
                                                    }
                                                } else {
                                                    try {
                                                        echo "Pipeline bugs else"
                                                    } catch (err) {
                                                        unstable(message: "̣La etapa '${env.STAGE_NAME}' presenta problemas. Por favor validar el log.")
                                                    } finally {
                                                        echo "Pipeline bugs else finally"
                                                    }
                                                }
                                                stash name: 'project-information', useDefaultExcludes: false
                                            }
                                        }
                                    },
                                    failFast: false
                            )
                            */
                        }
                    }
                }
                post {
                    always {
                        script {
                            echo "TO DO"
                        }
                    }
                }
            }
            /**************************************************************************/
            stage("SonarQube Quality Gate") {
                agent {
                    label agentLabel
                }

                steps {
                    script {
                        if (version == "GravitonPipelineDeploy") {
                            echo "Pipeline Graviton para despliegue"
                        } else {
                            //unstash 'project-information'
                            if (!wout) {
                                echo "SonarQube if"
                            } else {
                                try {
                                    echo "SonarQube else"
                                } catch (err) {
                                    unstable(message: "̣La etapa '${env.STAGE_NAME}' presenta problemas. Por favor validar el log.")
                                }
                            }
                            //stash 'project-information'
                        }
                    }
                }

            }
            /**************************************************************************/
            stage("Build Image") {
                agent {
                    label agentLabel
                }

                when {
                    anyOf {
                        branch 'master'
                        branch 'main'
                        branch 'release/*'
                        branch 'fix/*'
                    }
                }

                steps {

                    script {
                        echo "Build Image"
                    }

                }
            }
            /**************************************************************************/
            stage("deploy to Dev") {
                agent none
                when {
                    anyOf {
                        branch 'master'
                        branch 'main'
                        branch 'fix/*'
                    }
                }
                steps {
                    script {
                        echo "deploy to Dev"
                    }
                }
            }
            /**************************************************************************/
            stage("deploy to Test") {
                agent none
                when {
                    anyOf {
                        branch 'release/*'
                    }
                }
                steps {
                    script {
                        echo "deploy to Test"
                    }
                }
            }
            /**************************************************************************/
            stage("deploy to UAT") {
                agent none
                when {
                    anyOf {
                        branch 'release/*'
                    }
                }
                steps {
                    input "Deploy to UAT?"
                    script {
                        echo "deploy to UAT"
                    }
                }
            }
            /**************************************************************************/
            stage("deploy to Prod") {
                agent none
                when {
                    anyOf {
                        branch 'release/*'
                    }
                }
                steps {
                    input message: "Deploy to Prod?", submitter: "cbaciliod"
                    script {
                        echo "deploy to Prod"
                    }
                }
            }
            /**************************************************************************/
            stage("Release") {
                agent {
                    label agentLabel
                }
                when {
                    anyOf {
                        branch 'release/*'
                    }
                }
                steps {
                    script {
                        echo "Release"
                    }
                }
            }
            /**************************************************************************/
            stage("Archive Build") {
                agent {
                    label agentLabel
                }
                when {
                    anyOf {
                        branch 'release/*'
                    }
                }
                steps {
                    script {
                        echo "Archive Build"
                    }
                }
            }
            /**************************************************************************/
        }
        post {
            failure {
                script {
                    echo "failure Build jenkins"
                }
            }
            always {
                script {
                    echo "always Build jenkins"
                }
            }
        }
    }
}