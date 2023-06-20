package test2122t1

data class Occupancy(val current: Int, val capacity: Int) {
    init {
        require(current in 0..capacity && capacity >= 0)
    }
    val isFull get() = current == capacity
    val isEmpty get() = current == 0
}

fun Occupancy.increment(): Occupancy{
    check(!isFull)
    return copy(current = current+1)
}

fun Occupancy.decrement(): Occupancy{
    check(!isEmpty)
    return copy(current = current-1)
}