package aoc2020.day1

import aoc2020.processedInput

fun main() {
    val input = processedInput()

    input.forEachIndexed { index, first ->
        val midList = input.subList(index + 1, input.size)
        midList.forEachIndexed { secondIndex, second ->
            midList.subList(secondIndex + 1, midList.size).forEach { third ->
                if(first + second + third == 2020) {
                    println("$first, $second, $third, ${first * second * third}")
                }
            }
        }
    }
}

