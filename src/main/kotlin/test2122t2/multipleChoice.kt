package test2122t2

/*interface F { fun oper(): Int = -1 }
class A: F { override fun oper() = 1 }
class B(val f: F): F { override fun oper() = f.oper()+2 }
val C = object :F { override fun oper() = 0 }
*/
/*typealias F = () -> Int
fun A():F = { 1 }
fun B(f: F) = { -> f()+2 }
val C = { 0 }
*/

fun checkProgrammingCourses(courses: List<String>): String = when {
    "PG" !in courses -> "Falta PG"
    "AED" !in courses -> "Falta AED"
    "TDS" !in courses -> "Falta TDS"
    else -> "OK: PG,AED,TDS"
}
/*
fun checkProgrammingCourses(courses: List<String>): String =
    checkCourses(courses, listOf("PG","AED","TDS"))
fun checkCourses(courses: List<String>, required: List<String>): String =
    required.firstOrNull { it !in courses } ?.let { "Falta $it" }
        ?: required.joinToString(separator= ",", prefix= "OK: ")
*/
fun main() {
    /*val fx: List<F> = listOf(A(), B(A()), C)
    val res = fx.map { it.oper() }  //  [1,3,0]*/
    /*val fx: List<F> = listOf(A(), B(A()), C)
    val res = fx.map { it() }*/

}

