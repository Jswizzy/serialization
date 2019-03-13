import kotlinx.serialization.Mapper
import kotlinx.serialization.Serializable

@Serializable
data class D2(val first: Int, val second: String)

fun main() {
    val map: Map<String, Any> = Mapper.map(D2.serializer(), D2(42, "foo"))
    println(map)

    Mapper.unmap(D2.serializer(), map).run(::println)
}