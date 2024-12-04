import java.util.stream.Collectors

fun main(args: Array<String>) {
    Day1().method()
}

class Day1 {

    fun method() {

        val lines: List<String> = object {}.javaClass.getResourceAsStream("2024-day01-input.txt")?.bufferedReader()!!.readLines()

        val pairs = lines.map { line ->
            val values = line.split("   ")
            Pair(values[0], values[1])
        }

        val a = pairs.stream().map { p -> p.first.toInt() }.sorted().collect(Collectors.toList())
        val b = pairs.stream().map { p -> p.second.toInt() }.sorted().collect(Collectors.toList())

        val countOfElements = b.groupingBy { it }.eachCount()

        var count = 0;

        for ((index) in a.withIndex()) {
            val current = a[index]
            count += current * (countOfElements[current] ?: 0)
        }

        System.out.println(count)

    }

}

