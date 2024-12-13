import Day07.Companion.append
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable


class Day07Test {

    @Test
    fun `Formula object can be created from line`() {
        assertEquals(Formula(190, listOf(10, 19)), Formula.from("190: 10 19"))
        assertEquals(Formula(161011, listOf(16, 10, 13)), Formula.from("161011: 16 10 13"))
        assertEquals(Formula(21037, listOf(9, 7, 18, 13)), Formula.from("21037: 9 7 18 13"))
    }

    @Test
    fun `A Formula object can be evaluated`() {

        assertAll(
            Executable { assertTrue(Day07.canBeSolved(Formula(190, listOf(190)))) },
            Executable { assertFalse(Day07.canBeSolved(Formula(190, listOf(198)))) },
            Executable { assertTrue(Day07.canBeSolved(Formula(190, listOf(10, 19)))) },
            Executable { assertTrue(Day07.canBeSolved(Formula(29, listOf(10, 19)))) },
            Executable { assertTrue(Day07.canBeSolved(Formula(39, listOf(10, 19, 10)))) },
            Executable { assertFalse(Day07.canBeSolved(Formula(39, listOf(10, 10, 10)))) },
            Executable { assertFalse(Day07.canBeSolved(Formula(39, listOf(10, 10, 10, 10)))) },
            Executable { assertTrue(Day07.canBeSolved(Formula(40, listOf(10, 10, 10, 10)))) },
        )

    }

    @Test
    fun `test append`() {
        assertEquals(1234, append(12, 34))
    }
}


