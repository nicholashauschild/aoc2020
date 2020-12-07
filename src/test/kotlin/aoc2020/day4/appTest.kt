package aoc2020.day4

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class App4Test {
    @Test
    fun testPuzzle1() {
        val passports = processedInput()

        Assertions.assertEquals(12, passports.size)
        Assertions.assertTrue(isPassportValid1(passports[0]))
        Assertions.assertFalse(isPassportValid1(passports[1]))
        Assertions.assertTrue(isPassportValid1(passports[2]))
        Assertions.assertFalse(isPassportValid1(passports[3]))
    }

    @Test
    fun testPuzzle2() {
        val passports = processedInput()

        Assertions.assertEquals(12, passports.size)

        Assertions.assertFalse(isPassportValid2(passports[4]))
        Assertions.assertFalse(isPassportValid2(passports[5]))
        Assertions.assertFalse(isPassportValid2(passports[6]))
        Assertions.assertFalse(isPassportValid2(passports[7]))

        Assertions.assertTrue(isPassportValid2(passports[8]))
        Assertions.assertTrue(isPassportValid2(passports[9]))
        Assertions.assertTrue(isPassportValid2(passports[10]))
        Assertions.assertTrue(isPassportValid2(passports[11]))
    }
}