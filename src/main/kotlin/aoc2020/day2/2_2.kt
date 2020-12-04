package aoc2020.day2

fun main() {
    val input = processedInput()

    println(input.count { dbEntry ->
        val policyDetails = dbEntry.policyDetails
        val pw = dbEntry.plaintextPassword

        val first = policyDetails.firstInt
        val second = policyDetails.secondInt
        val letter = policyDetails.letter

        (pw[first - 1] == letter) xor (pw[second - 1] == letter)
    })
}