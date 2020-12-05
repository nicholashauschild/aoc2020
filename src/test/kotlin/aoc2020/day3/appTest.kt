package aoc2020.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class App3Test {
    @Test
    fun testPuzzle1() {
        val forest = processedInput()

        assertEquals(7, forest.treesOnSlope(3, 1))
    }

    @Test
    fun testPuzzle2() {
        val forest = processedInput()

        val one_one = forest.treesOnSlope(1, 1)
        val three_one = forest.treesOnSlope(3, 1)
        val five_one = forest.treesOnSlope(5, 1)
        val seven_one = forest.treesOnSlope(7, 1)
        val one_two = forest.treesOnSlope(1, 2)

        assertEquals(2, one_one)
        assertEquals(7, three_one)
        assertEquals(3, five_one)
        assertEquals(4, seven_one)
        assertEquals(2, one_two)
    }
}