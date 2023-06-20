package test2223t1

fun List<String>.maxLength() : Int = this.map { return it.length }.sorted().last()
fun main() = println(listOf("isel", "portugal", "tds").maxLength())
/*
fun List<String>.maxLength() : List<Int> = this.map {
    it.length
}


fun main() {
    val lst = listOf("isel", "portugal", "tds").maxLength()
    val lstSorted = lst.sorted().last()
    println(lstSorted)
}
*/
