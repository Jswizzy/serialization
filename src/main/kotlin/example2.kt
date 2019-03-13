import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.Transient

@Serializable
class Data3(val a: Int, @Transient val c: String = "42", @Optional val b: String = "2") {


    init {
        check(a >= 0)
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}

fun main() {
    val json = Json.unquoted.stringify(Data3.serializer(), Data3(1))
    println(json)
}