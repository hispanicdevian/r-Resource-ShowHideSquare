import java.io.File

object LSHandler {
    private const val FILEPATH = "msState.hdi"

    fun lSSTFile(): String {
        return try {
            File(FILEPATH).readText()
        } catch (e: Exception) {
            ""
        }
    }

    fun sSSTFile(scState: String) {
        try {
            val msStateFile = File(FILEPATH)
            msStateFile.writeText(scState)
        } catch (e: Exception) {
            // Handle exceptions
        }
    }
}
