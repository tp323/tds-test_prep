package test2122t1

fun log(prefix: String, message: String) { println("$prefix:$message") }
fun getLogger(prefix: String) = { msg: String -> log(prefix, msg) }
val mainLogger = getLogger("main")


class SomeType(val n:Int)


interface I { fun f1() = 0 }
class A: I { override fun f1() = 1 }
object B: I { override fun f1() = 2 }
fun I.f2() = 'I'
fun A.f2() = 'A'


fun main(){
    //mainLogger(prefix = "prefix")
    //log("a_prefix","a_message")//a_prefix:a_message
    //mainLogger("the_message")//main:the_message

    /*val a = SomeType(5)
    val b = SomeType(5)
    val c = a
    println("${a == b} ${a === b} ${a === c}")//false false true*/

    val objs = listOf( A() , B )
    objs.forEach { print( it.f1() ) }
    objs.forEach { print( it.f2() ) }
    //12II
}