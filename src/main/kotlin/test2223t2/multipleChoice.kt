package test2223t2


open class A { open fun f() = "fA" }
fun A.h() = "hA"
class B: A() { override fun f() = "fB" }
fun B.h() = "hB"

typealias Oper = (Int,Int) -> Int
fun eval(a: Int, b: Int, op: Oper) { println("Result = ${op(a,b)}") }


class Direction private constructor(val dRow: Int, val dCol: Int) {
    companion object {
        val LEFT = Direction(0,-1); val UP = Direction(-1,0)
        val RIGHT = Direction(0,+1); val DOWN = Direction(+1,0)
        val values = listOf(LEFT, UP, RIGHT, DOWN)
    }
    val ordinal by lazy { values.indexOf(this) }
    override fun equals(other: Any?) = this === other
    //override fun equals(other: Any?) = other is Direction && ordinal == other.ordinal
    //override fun equals(other: Any?) = other is Direction && dRow==other.dRow && dCol==other.dCol
}
fun foo() { "ISEL".forEach{ if (it=='E') return; print(it) }; print("_OK") }

fun main() {
    //val value = null
    //val a: Any = value
    //val a: Any? = value
    //val a: Any = value as Any
    //val a: Any? = value as Any?
    //println(a)

    //println(listOf(B(),A()).map{ it.f() + it.h() } + B().h() + A().f())

    /*fun sum(a: Int, b: Int) = a + b
    eval(3, 10, ::sum)
    val sum = { a, b -> a + b } //false
    eval(3, 10, ::sum)*/
    /*val sum: Oper = { a: Int, b: Int -> a + b }
    eval(3, 10, sum)*/
    //eval(3, 10) { a, b -> a + b }
    val dir1 = Direction.LEFT
    val dir2 = Direction.LEFT
    val dir3 = Direction.UP

    println(dir1.equals(dir2))
    println(dir1.equals(dir3))

    //foo()


}

