package aoc2020.day8

fun main() {
    val bootCodeListing = processedInput()

    try {
        println("Boot complete. Accumulator=${bootCodeListing.execute()}")
    } catch(ex: LoopException) {
        println("Loop encountered at instruction index ${ex.instructionIndex}. DEBUG: Accumulator=${ex.accumulator}")
    }
}