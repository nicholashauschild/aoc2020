package aoc2020.day2

internal val puzzleFunction2 = { pw: String, policyDetails: CorporatePasswordPolicyDetails ->
    val first = policyDetails.firstInt
    val second = policyDetails.secondInt
    val letter = policyDetails.letter

    (pw[first - 1] == letter) xor (pw[second - 1] == letter)
}

fun main() {
    val pwDatabase = processedInput()

    println(pwDatabase.countValidEntries(puzzleFunction2))
}