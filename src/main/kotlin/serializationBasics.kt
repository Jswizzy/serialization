import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")

fun main() {
    // serializing objects
    val jsonData = Json.stringify(Data.serializer(), Data(42))
    // serializing lists
    val jsonList = Json.stringify(Data.serializer().list, listOf(Data(42)))
    println(jsonData)
    println(jsonList)

    // parsing data back
    val obj = Json.parse(Data.serializer(), """{"a": 42}""")
    println(obj)
}

