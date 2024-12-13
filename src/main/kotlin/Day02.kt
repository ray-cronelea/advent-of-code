import kotlin.math.abs

fun main(args: Array<String>) {
    Day02().method()
}

class Day02 {

    fun method() {

        val count = object {}.javaClass.getResourceAsStream("2024-day02-input.txt")
            ?.bufferedReader()!!
            .readLines()
            .map {
                it.split(" ")
                    .map { it.toInt() }
                    .toList()
            }.count { isSafe(it) }

        System.out.println(count)

    }

    companion object {

        fun isSafe(input: List<Int>): Boolean {
            if (isSafeSingle(input)) return true


            for ((index1, _) in input.withIndex()) {
                val inputWithPositionRemoved = input.filterIndexed { index2, _ ->
                    index2 != index1
                }

                if (isSafeSingle(inputWithPositionRemoved)) return true

            }

            return false
        }

        private fun isSafeSingle(input: List<Int>): Boolean {
            return (increasing(input) || decreasing(input)) && withinTolerance(input)
        }

        private fun withinTolerance(input: List<Int>): Boolean {
            for (index in 0..<input.lastIndex) {
                val count = abs(input[index] - input[index + 1])
                if (count != 1 && count != 2 && count != 3) return false
            }
            return true
        }

        private fun decreasing(input: List<Int>): Boolean {
            for (index in 0..<input.lastIndex) {
                if (input[index] < input[index + 1]) return false
            }
            return true
        }

        private fun increasing(input: List<Int>): Boolean {
            for (index in 0..<input.lastIndex) {
                if (input[index] > input[index + 1]) return false
            }
            return true
        }
    }

}

