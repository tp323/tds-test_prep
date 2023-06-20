package test2122t2

import org.junit.jupiter.api.Test
import java.lang.IllegalStateException
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TodoListTests {
    @Test
    fun `valid add TodoList`(){
        val todoList = TodoList(listOf(Task("1"), Task("2")))

        assertContentEquals(listOf(Task("1"), Task("2")), todoList.tasks)
        val newList = todoList.add(Task("3"))

        assertEquals(Task("3"), newList.tasks.last())
    }
    @Test
    fun `ìnvalid remove TodoList`(){
        val todoList = TodoList(listOf(Task("1"), Task("2")))
        assertFailsWith<IllegalStateException>{todoList.remove(Task("3"))}

    }
}