fun main(args: Array<String>) {
    Day07().method()
}

class Day04 {

    companion object{
    }

    fun method() {

        val input: List<List<String>> = object {}.javaClass.getResourceAsStream("2024-day04-input.txt")
            ?.bufferedReader()!!
            .readLines()
            .map { it.split("") }
            .toList()

        System.out.println("count")

    }

}

