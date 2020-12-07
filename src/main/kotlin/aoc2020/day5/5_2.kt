package aoc2020.day5

fun main() {
    val boardingPasses = processedInput()

    val allSeats = HashSet<Int>()
    (0 until 128 * 8 - 1).forEach { allSeats.add(it) }

    val takenSeats = HashSet<Int>()
    boardingPasses.forEach { takenSeats.add(it.determineSeatNum()) }

    val potentialSeats = allSeats - takenSeats
    println(potentialSeats.filter { it + 1 !in potentialSeats && it - 1 !in potentialSeats })
}