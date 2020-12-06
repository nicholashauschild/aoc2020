package aoc2020.day2

internal val puzzleFunction1 = { pw: String, policyDetails: CorporatePasswordPolicyDetails ->
    val min = policyDetails.firstInt
    val max = policyDetails.secondInt
    val letter = policyDetails.letter

    pw.count { it == letter } in min..max
}

fun main() {
    val pwDatabase = processedInput()

    println(pwDatabase.countValidEntries(puzzleFunction1))
}