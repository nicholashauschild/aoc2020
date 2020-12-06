package aoc2020.day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App2Test {
    @Test
    fun testPuzzle1() {
        val pwDatabase = processedInput()

        Assertions.assertEquals(2, pwDatabase.countValidEntries(puzzleFunction1))
    }

    @Test
    fun testPuzzle2() {
        val pwDatabase = processedInput()

        Assertions.assertEquals(1, pwDatabase.countValidEntries(puzzleFunction2))
    }
}