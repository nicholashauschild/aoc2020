package aoc2020.day9

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App9Test {
    @Test
    fun testPuzzle1() {
        val file = processedInput()

        Assertions.assertEquals(127, file.initiateHack(5))
    }

    @Test
    fun testPuzzle2() {
        val file = processedInput()

        Assertions.assertEquals(62, file.exposeWeakness(file.initiateHack(5)))
    }
}