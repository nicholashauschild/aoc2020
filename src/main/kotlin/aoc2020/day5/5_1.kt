package aoc2020.day5

fun main() {
    val boardingPasses = processedInput()

    println(boardingPasses.maxOf { it.determineSeatNum() })
}