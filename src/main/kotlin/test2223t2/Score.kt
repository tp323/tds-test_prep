package test2223t2

class Score(val name: String, val rating: Int) {
    init {
        check(rating in 1..MAX_RATING)
    }
}

fun List<Score>.replace(score: Score): List<Score> {
    val target = firstOrNull { it.name == score.name }
    require(target!=null)
    val t = map { if(it.name == score.name) score else it}
    return t
    //return this - target +score
}