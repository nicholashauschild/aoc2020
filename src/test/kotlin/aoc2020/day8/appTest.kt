package aoc2020.day8

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App8Test {
    @Test
    fun testPuzzle1() {
        val bootCodeListing = processedInput()
        try {
            bootCodeListing.execute()
        } catch(ex: LoopException) {
            Assertions.assertEquals(5, ex.accumulator)
        }
    }

    @Test
    fun testPuzzle2() {
        val bootCodeListing = processedInput()
        Assertions.assertEquals(8, repair(bootCodeListing))
    }
}