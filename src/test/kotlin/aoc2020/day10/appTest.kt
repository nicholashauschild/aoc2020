package aoc2020.day10

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App10Test {
    @Test
    fun testPuzzle1() {
        val adapterBag = processInput()

        val distributions = adapterBag.joltageDiffDistributions()
        Assertions.assertEquals(22, distributions[1])
        Assertions.assertEquals(null, distributions[2])
        Assertions.assertEquals(10, distributions[3])
    }

    @Test
    fun testPuzzle2() {
        val adapterBag = processInput()

        Assertions.assertEquals(19208, adapterBag.generateDifferentials().runsOf(1).map {
            when (it) {
                1L -> 1L
                2L -> 2L
                3L -> 4L
                4L -> 7L
                else -> 0L
            }
        }.reduce { a, b -> a * b })
    }
}