package aoc2020.day1

fun main() {
    val input = processedInput()

    input.forEachIndexed { index, first ->
        input.subList(index + 1, input.size).forEach { second ->
            if(first + second == 2020) {
                println("$first, $second, ${first * second}")
            }
        }
    }
}