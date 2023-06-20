package test2122t2

data class TodoList(val tasks: List<Task> = emptyList())

fun TodoList.add(newTask: Task): TodoList {
    check(!this.tasks.contains(newTask))
    return copy(tasks = tasks + newTask)
}
fun TodoList.remove(oldTask: Task): TodoList {
    check(this.tasks.contains(oldTask))
    return copy(tasks = tasks - oldTask)
}

