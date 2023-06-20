package test2222t2

import kotlin.math.sqrt


fun error(msg: String?): Nothing {
    val value: Int? = msg?.toInt()
    //val value: Any = msg ?: Unit
    //val value: String = msg ?: return
    //val value = msg ?: "null"
    throw IllegalStateException("$msg: $value")
}
/*
suspend fun f1(scope: CoroutineScope) {
    print(1)
    scope.launch { print(2); delay(50); print(3) }
    delay(100); print(4)
}
*/

data class Point(val x:Int, val y: Int) {
    //val module by lazy { sqrt(x.toDouble()*x + y*y) }
    //val module = sqrt(x.toDouble()*x + y*y).also { return it } //compile error
    //val module: Double = sqrt(x.toDouble()*x + y*y)
    //val module get() = sqrt(x.toDouble()*x + y*y)
}

fun main() {
    val g = Grade(10)
    //Grade(22)
    //println(Grade(8).value==8)

    //println(Grade.Companion.invoke(8)===Grade(8))

    val grade1 = Grade(8)
    val grade2 = Grade(8)
    val grade3 = Grade(1)
    println(grade1==grade2)
    println(grade1==grade3)

    println(grade1===grade2)
    println(grade1===grade3)
}

