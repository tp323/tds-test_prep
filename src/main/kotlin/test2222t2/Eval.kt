package test2222t2

class Eval private constructor(val quotation: Int) {
    companion object {
        const val DELTA = 5; const val MIN = 0; const val MAX = 100
        val default = Eval(MIN)
        fun of(q: Int) = if (q in MIN..MAX && q % DELTA == 0) Eval(q) else null
    }

    fun inc(): Eval = if (quotation==MAX) this else Eval(quotation+DELTA)
    fun dec(): Eval = if (quotation==MIN) this else Eval(quotation-DELTA)

    override fun equals(other: Any?): Boolean {
        require(other is Eval)
        return quotation == other.quotation
    }
}

fun Grade.partialValue(eval: Eval): Double = ((value).toDouble() * eval.quotation) / 100

fun main(){
    println(Grade(4).partialValue(Eval.of(35)?: Eval.default))
}