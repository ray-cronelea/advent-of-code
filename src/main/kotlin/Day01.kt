import java.util.stream.Collectors

fun main(args: Array<String>) {
    Day01().method()
}

class Day01 {

    fun method() {

        val lines: List<String> = object {}.javaClass.getResourceAsStream("2024-day01-input.txt")?.bufferedReader()!!.readLines()

        val pairs = lines.map { line ->
            val values = line.split("   ")
            Pair(values[0], values[1])
        }

        val a = pairs.map { it.first.toInt() }.sorted().toList()
        val b = pairs.map { it.second.toInt() }.sorted().toList()

        val countOfElements = b.groupingBy { it }.eachCount()

        var count = 0;

        for ((index) in a.withIndex()) {
            val current = a[index]
            count += current * (countOfElements[current] ?: 0)
        }

        System.out.println(count)

    }

}

