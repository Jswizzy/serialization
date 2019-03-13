import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.internal.IntSerializer
import kotlinx.serialization.internal.StringSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import kotlinx.serialization.map

@Serializable
data class D4(val a: Int)

@Serializable
data class Box<T>(val boxed: T)


fun main() {
    val dataSerial: KSerializer<D4> = D4.serializer()
    val boxedDataSerial: KSerializer<Box<D4>> = Box.serializer(dataSerial)

    val i: KSerializer<Int> = IntSerializer
    val ii: KSerializer<List<Int>> = ArrayListSerializer(IntSerializer)

    // or

    val li: KSerializer<List<D4>> = D4.serializer().list
    val mp: KSerializer<Map<String, Int>> = (StringSerializer to IntSerializer).map

    val d4 =  D4(6)
    val json = Json.indented.toJson(D4.serializer(), d4)
    println(json)
}

