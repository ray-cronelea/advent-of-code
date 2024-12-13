import Day08.Companion.calculateAntinodes
import Day08.Companion.Position
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day08Test {

    @Test
    fun `test append`() {
        assertEquals(mutableSetOf<Position>(), calculateAntinodes(listOf()))
        assertEquals(mutableSetOf<Position>(), calculateAntinodes(listOf(Position(1,1))))
        assertEquals(mutableSetOf(Position(-1,-1), Position(5,5)), calculateAntinodes(listOf(Position(1,1), Position(3,3))))
        assertEquals(mutableSetOf(Position(-1,-1), Position(5,5)), calculateAntinodes(listOf(Position(1,1), Position(3,3))))
    }
}


