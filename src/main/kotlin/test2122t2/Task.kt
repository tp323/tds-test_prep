package test2122t2

data class Task(val name: String) {
    init{
        check(name.length in 0..40)
    }
}