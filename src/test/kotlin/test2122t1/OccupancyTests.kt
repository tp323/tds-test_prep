package test2122t1
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse


class OccupancyTests {
    @Test
    fun `test occupancy`() {
        val valid = Occupancy(20, 25)
        assertEquals(20,valid.current)
        assertEquals(25, valid.capacity)
        assertFalse(valid.isEmpty)
        assertFalse(valid.isFull)
        assertFailsWith<IllegalArgumentException> { Occupancy(25,20)}
    }
    @Test
    fun `test increment`() {
        val occup = Occupancy(4,5)
        assertEquals(5, occup.increment().current)
        val occup1 = Occupancy(5,5)
        assertFailsWith<IllegalStateException> { occup1.increment()}
    }
}