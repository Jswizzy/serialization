import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json

@Serializable
data class Data2(val a: Int, val b: Int)
val data2 = Data2(1, 2)

@Serializer(forClass = Data2::class)
object ExtDataSerializer

fun main() {
    val json = Json.unquoted.stringify(Data2.serializer(), data2)
    println(json)

    val obj = Json.parse(Data2.serializer(), json)
    println(obj)

    val json2 = Json.unquoted.stringify(ExtDataSerializer, data2)
    println(json2)

    val obj2 = Json.parse(ExtDataSerializer, "{a:1,b:2}")
    println(obj2)
}
