import kotlinx.serialization.cbor.Cbor

fun main() {
    val data = Data(16, "a")

    val cbor = Cbor.dump(Data.serializer(), data)
    println(cbor)

    val obj = Cbor.load(Data.serializer(), cbor)
    println(obj)
}