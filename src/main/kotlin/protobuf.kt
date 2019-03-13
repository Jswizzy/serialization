import kotlinx.serialization.SerialId
import kotlinx.serialization.Serializable
import kotlinx.serialization.dumps
import kotlinx.serialization.protobuf.ProtoBuf

@Serializable
data class KtestInt32(@SerialId(1) val a: Int)

fun main() {
    val kt = KtestInt32(32)

    val bytes = ProtoBuf.dump(KtestInt32.serializer(), kt)
    println(bytes)

    val obj = ProtoBuf.load(KtestInt32.serializer(), bytes)
    println(obj)

}