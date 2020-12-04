package aoc2020.day3

fun main() {
    val forest = processedInput()

    val slopeOne = forest.treesOnSlope(1,1)
    val slopeOneThird = forest.treesOnSlope(3,1)
    val slopeOneFifth = forest.treesOnSlope(5,1)
    val slopeOneSeventh = forest.treesOnSlope(7,1)
    val slopeTwo = forest.treesOnSlope(1,2)

    println("$slopeOne, $slopeOneThird, $slopeOneFifth, $slopeOneSeventh, $slopeTwo")
    println("Product: ${1L * slopeOne * slopeOneThird * slopeOneFifth * slopeOneSeventh * slopeTwo}")
}