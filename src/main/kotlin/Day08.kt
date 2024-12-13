fun main(args: Array<String>) {
    Day08().method()
}

class Day08 {

    companion object {

        data class Position(val i: Int, val j: Int)

        fun calculateAntinodes(nodes: List<Position>): Set<Position> {

            val mutableSetOf = mutableSetOf<Position>()

            nodes.forEachIndexed { i, position ->

                for (i in 0..<nodes.size - 1) {
                    for (j in i+1..<nodes.size) {

                        val iNode = nodes[i]
                        val jNode = nodes[j]
                        var iDiff = iNode.i - jNode.i
                        var jDiff = iNode.j - jNode.j

                        for(value in 0..100){
                            mutableSetOf.add(Position(iNode.i + (iDiff*value), iNode.j + (jDiff*value)))
                            mutableSetOf.add(Position(jNode.i - (iDiff*value), jNode.j - (jDiff*value)))
                        }
                    }
                }


            }
            return mutableSetOf
        }
    }





    fun method() {

        val lines = object {}.javaClass.getResourceAsStream("2024-day08.txt")
            ?.bufferedReader()!!
            .readLines()

        val positionByChar: MutableMap<Char, List<Position>> = mutableMapOf();

        lines.forEachIndexed { i, line ->
            line.toCharArray()
                .forEachIndexed { j, char ->
                    positionByChar.merge(char, listOf(Position(i, j)), { one, two -> one + two })
                }
        }

        val antiNodes = positionByChar
            .filter { !it.key.equals('.') }
            .map { calculateAntinodes(it.value) }
            .flatten()
            .filter { insideGrid(it, lines.size, lines[0].length) }
            .toSet()

        System.out.println(antiNodes.size)
    }

    private fun insideGrid(position: Position, size: Int, length: Int): Boolean {

        if (position.i < 0) {
            return false
        }

        if (position.i >= size) {
            return false
        }

        if (position.j < 0) {
            return false
        }

        if (position.j >= length) {
            return false
        }

        return true
    }
}
