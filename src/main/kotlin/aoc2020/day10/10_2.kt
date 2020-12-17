package aoc2020.day10

fun main() {
    val adapterBag = processInput()

    println(adapterBag.generateDifferentials().runsOf(1).map {
        when (it) {
            1L -> 1L
            2L -> 2L
            3L -> 4L
            4L -> 7L
            else -> 0L
        }
    }.reduce { a, b -> a * b })
}