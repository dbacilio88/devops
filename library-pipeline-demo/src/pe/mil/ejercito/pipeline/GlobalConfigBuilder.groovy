package pe.mil.ejercito.pipeline

import groovy.transform.PackageScope

class GlobalConfigBuilder extends PipelineBase implements Serializable {

    String CONFIG_PATH_PASE = "pe/mil/ejercito/pipeline/config"
    String configName

    GlobalConfigBuilder(def scriptInstance) {
        super(scriptInstance)
    }

    GlobalConfigBuilder withConfig(String configName) {
        this.configName = configName
        return this
    }

    def loadConfigFile(String configPath, String targetPath = null) {
        if (!targetPath) {
            targetPath = configPath
        }
        getConfigFile(configPath, targetPath)
        scriptInstance.load "${targetPath}"
    }

    def getConfigFile(String configPath, String targetPath = null) {
        if (!targetPath) {
            targetPath = configPath
        }
        def configContent = scriptInstance.libraryResource "${CONFIG_PATH_PASE}/${configPath}"
        scriptInstance.writeFile file: targetPath, text: configContent
    }

    def getConfigContent(String configPath) {
        def configContent = scriptInstance.libraryResource "${CONFIG_PATH_PASE}/${configPath}"
        return configContent
    }

    @PackageScope
    def execute() {
        def configContent = scriptInstance.libraryResource "${CONFIG_PATH_PASE}/${configName}"
        scriptInstance.writeFile file: configName, text: configContent
        scriptInstance.sh "cat ./${configName}"
        scriptInstance.load "./${configName}"
        scriptInstance.println("configTest=${scriptInstance.TEST_CONFIG}")
    }
}