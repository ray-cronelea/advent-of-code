fun main(args: Array<String>) {
    Day10().method()
}

class Day10 {

    companion object {
        data class Position(val i: Int, val j: Int)

        fun countRoute(lookingFor: Int, position: Position, map: List<String>): Int {
            System.out.println("lookingFor: $lookingFor, position: $position")

            val moves = mutableSetOf<Position>()

            val nextChar = lookingFor.toString()
            try {
                if (map[position.i - 1][position.j] == nextChar[0]) {
                    moves.add(Position(position.i - 1, position.j))
                }
            } catch (e: Exception) {
                // do nothing
            }

            try {
                if (map[position.i + 1][position.j] == nextChar[0]) {
                    moves.add(Position(position.i + 1, position.j))
                }
            } catch (e: Exception) {
                // do nothing
            }

            try {
                if (map[position.i][position.j - 1] == nextChar[0]) {
                    moves.add(Position(position.i, position.j - 1))
                }
            } catch (e: Exception) {
                // do nothing
            }

            try {
                if (map[position.i][position.j + 1] == nextChar[0]) {
                    moves.add(Position(position.i, position.j + 1))
                }
            } catch (e: Exception) {
                // do nothing
            }

            System.out.println("Moves: $moves")

            if (lookingFor == 9) {
                System.out.println("ON 9: ${moves.size}")
                return moves.size
            }
            System.out.println("")

            return moves.sumOf { countRoute(lookingFor + 1, it, map) }
        }
    }


    fun method() {

        val map = object {}.javaClass.getResourceAsStream("2024-day10.txt")
            ?.bufferedReader()!!
            .readLines()

        val trailheads = mutableSetOf<Position>()
        map.forEachIndexed { i, line ->
            line.forEachIndexed { j, character ->
                if (character == '0') trailheads.add(Position(i, j))
            }
        }

        val sum = trailheads.sumOf { countRoute(1, it, map) }
        System.out.println(sum)

        //System.out.println(countRoute(1, Position(0, 2), map))
    }

}
