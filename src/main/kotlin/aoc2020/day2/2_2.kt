package aoc2020.day2

fun main() {
    val pwDatabase = processedInput()

    println(pwDatabase.countValidEntries { pw, policyDetails ->
        val first = policyDetails.firstInt
        val second = policyDetails.secondInt
        val letter = policyDetails.letter

        (pw[first - 1] == letter) xor (pw[second - 1] == letter)
    })
}