package aoc2020.day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App5Test {
    @Test
    fun testPuzzle1() {
        val boardingPass = BoardingPass("FBFBBFF", "RLR")

        Assertions.assertEquals(44, boardingPass.determineRow())
        Assertions.assertEquals(5, boardingPass.determineColumn())
        Assertions.assertEquals(357, boardingPass.determineSeatNum())
    }
}