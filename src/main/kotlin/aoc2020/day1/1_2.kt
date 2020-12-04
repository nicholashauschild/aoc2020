package aoc2020.day1

fun main() {
    val input = processedInput()

    input.forEachIndexed { firstIdx, first ->
        val inner = input.subList(firstIdx + 1, input.size)
        inner.forEachIndexed { secondIdx, second ->
            inner.subList(secondIdx + 1, inner.size).forEach { third ->
                if(first + second + third == 2020) {
                    println("$first, $second, $third, ${first * second * third}")
                }
            }
        }
    }
}

