package aoc2020.day7

import aoc2020.processLines
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App7Test {
    @Test
    fun testPuzzle1() {
        val baggageRules = processedInput()

        Assertions.assertEquals(4, baggageRules.findBagColorsThatCanContain("shiny_gold").size)
    }

    @Test
    fun testPuzzle2() {
        val baggageRules = BaggageRules(processLines("input_7_2", ::createBaggageRule))

        Assertions.assertEquals(2, baggageRules.countBagsRequiredIn("dark_blue"))
        Assertions.assertEquals(6, baggageRules.countBagsRequiredIn("dark_green"))
        Assertions.assertEquals(126, baggageRules.countBagsRequiredIn("shiny_gold"))
    }
}