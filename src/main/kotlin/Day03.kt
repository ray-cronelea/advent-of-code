import java.util.stream.Collectors

fun main(args: Array<String>) {
    Day03().method()
}

private const val DONT_INSTRUCTION = "don't()"
private const val DO_INSTRUCTION = "do()"
private const val DONT = false
private const val DO = true

class Day03 {

    companion object{
        val instructionRegex = Regex("mul\\(\\d*,\\d*\\)|don't\\(\\)|do\\(\\)")
        val numberRegex = Regex("\\d+")
    }

    fun method() {

        val input = object {}.javaClass.getResourceAsStream("2024-day03-input.txt")
            ?.bufferedReader()!!
            .readLines()
            .stream()
            .collect(Collectors.joining())

        var count = 0L

        var mode = DO

        for (instruction in parseInstructions(input)) {

            if (instruction == DONT_INSTRUCTION) {
                mode = DONT
                continue
            }

            if (instruction == DO_INSTRUCTION) {
                mode = DO
                continue
            }

            if (mode == DO) {
                count += evaluate(instruction)
            }
        }

        System.out.println(count)

    }

    private fun parseInstructions(input: String) = instructionRegex
        .findAll(input)
        .map { it.groupValues[0] }
        .toList()

    private fun evaluate(multiplyInstruction: String): Long {
        return numberRegex
            .findAll(multiplyInstruction)
            .map { it.groupValues[0] }
            .map { it.toLong() }
            .reduce { acc, l -> acc * l }
    }

}

