import Day02.Companion.isSafe
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun isSafeTest() {
        assertTrue(isSafe(listOf(7, 6, 4, 2, 1)))
        assertFalse(isSafe(listOf(1, 2, 7, 8, 9)))
        assertFalse(isSafe(listOf(9, 7, 6, 2, 1)))
        assertTrue(isSafe(listOf(1, 3, 2, 4, 5)))
        assertTrue(isSafe(listOf(8, 6, 4, 4, 1)))
        assertTrue(isSafe(listOf(1, 3, 6, 7, 9)))
    }
}