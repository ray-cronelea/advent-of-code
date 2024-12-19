import Day10.Companion.Position
import Day10.Companion.countRoute
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day10Test {

    @Test
    fun `test append 1`() {
        val map = listOf(
            "0123",
            "1234",
            "8765",
            "9876",
        )
        assertEquals(1, countRoute(1, Position(0,0), map))
    }

    @Test
    fun `test append 10`() {
        val map = listOf(
            "89010123",
            "78121874",
            "87430965",
            "96549874",
            "45678903",
            "32019012",
            "01329801",
            "10456732",
        )
        assertEquals(5, countRoute(1, Position(0,2), map))
    }
}


