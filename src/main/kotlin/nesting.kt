import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

enum class TintEnum { LIGHT, DARK }

@Serializable
data class D3(
    val a: String,
    val b: List<Int>,
    val c: Map<String, TintEnum>
)

val d3 = D3("Str", listOf(1, 2), mapOf("lt" to TintEnum.DARK, "dk" to TintEnum.LIGHT))

fun main() {
    val json = Json.unquoted.stringify(D3.serializer(), d3)
    println(json)

    val d31 = Json.parse(D3.serializer(), json)
    println(d31)
}