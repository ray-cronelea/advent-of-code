fun main(args: Array<String>) {
    Day07().method()
}

class Day07 {

    companion object {
        fun canBeSolved(formula: Formula): Boolean {
            return evaluate(formula)
        }

        fun evaluate(formula: Formula): Boolean {

            if (formula.numbers.size == 1) {
                return formula.answer == formula.numbers[0]
            }


            var remainingNumbers = if(formula.numbers.size >= 3) {
                formula.numbers.subList(2, formula.numbers.size)
            } else {
                emptyList()
            }

            return evaluate(formula.update(listOf(formula.numbers[0] * formula.numbers[1]) + remainingNumbers))
                    || evaluate(formula.update(listOf(formula.numbers[0] + formula.numbers[1]) + remainingNumbers))
                    || evaluate(formula.update(listOf(append(formula.numbers[0], formula.numbers[1])) + remainingNumbers))
        }

        fun append(l: Long, l1: Long): Long {

            return (l.toString() + l1.toString()).toLong();
        }
    }

    fun method() {

        val output = object {}.javaClass.getResourceAsStream("2024-day07.txt")
            ?.bufferedReader()!!
            .readLines()
            .map { it -> Formula.from(it) }
            .filter { it -> canBeSolved(it) }
            .map{it -> it.answer}
            .sum()

        System.out.println(output)
    }


}

data class Formula(val answer: Long, val numbers: List<Long>) {
    companion object {
        fun from(line: String): Formula {
            val split = line.split(":");
            val numbers = split[1]
                .split(" ")
                .filter { it.isNotBlank() }
                .map { it.toLong() }
                .toList()
            return Formula(split[0].toLong(), numbers)
        }
    }

    fun update(numbers: List<Long>): Formula {
        return Formula(this.answer, numbers)
    }
}
