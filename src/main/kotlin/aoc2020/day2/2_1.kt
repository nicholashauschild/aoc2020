package aoc2020.day2

fun main() {
    val pwDatabase = processedInput()

    println(pwDatabase.countValidEntries { pw, policyDetails ->
        val min = policyDetails.firstInt
        val max = policyDetails.secondInt
        val letter = policyDetails.letter

        pw.count { it == letter } in min..max
    })
}