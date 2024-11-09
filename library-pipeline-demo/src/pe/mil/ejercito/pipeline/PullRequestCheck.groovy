package pe.mil.ejercito.pipeline

class PullRequestCheck extends PipelineBase implements Serializable {

    PullRequestCheck(scriptInstance) {
        super(scriptInstance)
    }

    def sendCheckStatus(String name, PullRequestStatus status, String description, String url) {
        publishCheckStatus(name, status.value(), description, url, scriptInstance.GH_PR_AUTHOR)
    }

    def publishCheckStatus(String name, String status, String description, String url, String author, Date created = null) {
        if (scriptInstance.env.CHANGE_ID) {
            scriptInstance.pullRequest.createStatus(context: name
                    , status: status
                    , description: description
                    , targetUrl: url
                    , creator: author
                    , createdAt: created ?: new Date())
        }
    }

    def publishCheck(def name, def status = "COMPLETE", def title, def summary, def details, def detailsURL, def conclusion = "SUCCESS") {
        if (scriptInstance.env.CHANGE_ID) {
            def response = scriptInstance.publishChecks name: "${name}",
                    status: "${status}",
                    title: "${title}",
                    summary: "${summary}",
                    text: "${details}",
                    detailsURL: "${detailsURL}",
                    conclusion: "${conclusion}"

            scriptInstance.echo response
        }
    }
}
