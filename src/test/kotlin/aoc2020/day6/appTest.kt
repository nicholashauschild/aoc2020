package aoc2020.day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App6Test {
    @Test
    fun testPuzzle1() {
        val customsDeclarationGroups = processedInput()

        Assertions.assertEquals(5, customsDeclarationGroups.size)
        Assertions.assertEquals(3,
            customsDeclarationGroups[0].countYesForGroup(createEmptySet(), countingFunction1))
        Assertions.assertEquals(3,
            customsDeclarationGroups[1].countYesForGroup(createEmptySet(), countingFunction1))
        Assertions.assertEquals(3,
            customsDeclarationGroups[2].countYesForGroup(createEmptySet(), countingFunction1))
        Assertions.assertEquals(1,
            customsDeclarationGroups[3].countYesForGroup(createEmptySet(), countingFunction1))
        Assertions.assertEquals(1,
            customsDeclarationGroups[4].countYesForGroup(createEmptySet(), countingFunction1))
    }

    @Test
    fun testPuzzle2() {
        val customsDeclarationGroups = processedInput()

        Assertions.assertEquals(5, customsDeclarationGroups.size)
        Assertions.assertEquals(3,
            customsDeclarationGroups[0].countYesForGroup(createFullSet(), countingFunction2))
        Assertions.assertEquals(0,
            customsDeclarationGroups[1].countYesForGroup(createFullSet(), countingFunction2))
        Assertions.assertEquals(1,
            customsDeclarationGroups[2].countYesForGroup(createFullSet(), countingFunction2))
        Assertions.assertEquals(1,
            customsDeclarationGroups[3].countYesForGroup(createFullSet(), countingFunction2))
        Assertions.assertEquals(1,
            customsDeclarationGroups[4].countYesForGroup(createFullSet(), countingFunction2))
    }
}