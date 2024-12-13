import java.util.*

fun main(args: Array<String>) {
    Day07().method()
}

enum class Direction {
    NORTH {
        override fun turnRight(): Direction {
            return EAST
        }

        override fun nextPosition(currentPosition: Position): Position {
            return Position(currentPosition.i - 1, currentPosition.j, this)
        }
    },
    EAST {
        override fun turnRight(): Direction {
            return SOUTH
        }

        override fun nextPosition(currentPosition: Position): Position {
            return Position(currentPosition.i, currentPosition.j + 1, this)
        }
    },
    SOUTH {
        override fun turnRight(): Direction {
            return WEST
        }

        override fun nextPosition(currentPosition: Position): Position {
            return Position(currentPosition.i + 1, currentPosition.j, this)
        }
    },
    WEST {
        override fun turnRight(): Direction {
            return NORTH
        }

        override fun nextPosition(currentPosition: Position): Position {
            return Position(currentPosition.i, currentPosition.j - 1, this)
        }
    };

    abstract fun turnRight(): Direction
    abstract fun nextPosition(currentPosition: Position): Position
}

class Position(val i: Int, val j: Int, val facing: Direction = Direction.NORTH) {

    fun nextPosition(): Position {
        return facing.nextPosition(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Position) return false
        return this.i == other.i && this.j == other.j
    }

    override fun hashCode(): Int {
        return Objects.hash(i, j)
    }

    override fun toString(): String {
        return "Position(i=$i, j=$j, facing=$facing)"
    }

}

class Day06 {

    companion object {
        var OBSTACLE = '#'
        var GAURD = '^'
    }

    fun method() {

        val input: List<String> = object {}.javaClass.getResourceAsStream("2024-day06-input-full.txt")
            ?.bufferedReader()!!
            .readLines()

        var currentPosition = getInitalPosition(input)
        var steps: MutableSet<Position> = mutableSetOf()

        while (inBounds(currentPosition.nextPosition(), input)) {
            val nextPosition = currentPosition.nextPosition()

            if (input[nextPosition.i][nextPosition.j] == OBSTACLE) {
                currentPosition = Position(currentPosition.i, currentPosition.j, currentPosition.facing.turnRight())
            } else {
                currentPosition = currentPosition.nextPosition()
                steps.add(currentPosition)
            }
            System.out.println("New Position $currentPosition")

        }

        System.out.println(steps.size)
    }

    private fun inBounds(nextPosition: Position, input: List<String>): Boolean {
        try {
            input[nextPosition.i][nextPosition.j]
            return true
        } catch (e: Exception) {
            return false
        }
    }

    private fun getInitalPosition(input: List<String>): Position {
        input.forEachIndexed { i, line ->
            line.forEachIndexed { j, c ->
                if (c == GAURD) {
                    return Position(i, j, Direction.NORTH)
                }
            }
        }
        throw Exception("Initial position was not found")
    }

}

