package aoc2020.day2

fun main() {
    val input = processedInput()

    println(input.count { dbEntry ->
        val policyDetails = dbEntry.policyDetails
        val pw = dbEntry.plaintextPassword

        val min = policyDetails.firstInt
        val max = policyDetails.secondInt
        val letter = policyDetails.letter

        pw.count { it == letter } in min..max
    })
}