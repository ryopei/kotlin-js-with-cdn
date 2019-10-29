
import kotlin.browser.document
import kotlin.browser.window


fun main() {
    document.getElementById("greeting")?.innerHTML = "Hello Kotlin/JS"
}