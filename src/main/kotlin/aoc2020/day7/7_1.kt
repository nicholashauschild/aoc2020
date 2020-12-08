package aoc2020.day7

fun main() {
    val baggageRules = processedInput()

    println(baggageRules.findBagColorsThatCanContain("shiny_gold").size)
}