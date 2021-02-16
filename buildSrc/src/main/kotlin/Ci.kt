object Ci {
    private const val snapshotBase = "0.0.1"

    private val githubBuildNumber = System.getenv("GITHUB_RUN_NUMBER")

    private val snapshotVersion = when (githubBuildNumber) {
        null -> "$snapshotBase-LOCAL"
        else -> "$snapshotBase.$githubBuildNumber-SNAPSHOT"
    }

    private val releaseVersion = System.getenv("RELEASE_VERSION")

    val publishVersion = releaseVersion ?: snapshotVersion
}
