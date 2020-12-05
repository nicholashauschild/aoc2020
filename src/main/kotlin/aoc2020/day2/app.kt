package aoc2020.day2

import aoc2020.BadInputException
import aoc2020.processLines

// data structures
internal class PasswordDatabase(
    val entries: List<PasswordDatabaseEntry>
)

internal class PasswordDatabaseEntry(
    val policyDetails: CorporatePasswordPolicyDetails,
    val plaintextPassword: String
)

internal class CorporatePasswordPolicyDetails(
    val firstInt: Int,
    val secondInt: Int,
    val letter: Char
)

// functionality
internal fun PasswordDatabase.countValidEntries(
        action: (password: String, policyDetails: CorporatePasswordPolicyDetails) -> Boolean): Int {
    return entries.count { action(it.plaintextPassword, it.policyDetails) }
}

// input processing
internal fun processedInput(): PasswordDatabase {
    return PasswordDatabase(processLines("input_2", ::createDatabaseEntry))
}

private fun createDatabaseEntry(input: String): PasswordDatabaseEntry {
    val inputParts = input.split(':')

    if (inputParts.size != 2) {
        throw BadInputException("More than two parts: ${input}")
    }

    val policy = extractPolicyDetails(inputParts[0])
    val password = inputParts[1].trim()

    return PasswordDatabaseEntry(policy, password)
}

private fun extractPolicyDetails(rawPolicy: String): CorporatePasswordPolicyDetails {
    val policyParts = rawPolicy.split(' ')
    val rangeParts = policyParts[0].split('-')
    val first = rangeParts[0].toInt()
    val second = rangeParts[1].toInt()
    val letterString = policyParts[1].trim()

    if (letterString.length != 1) {
        throw BadInputException("Expected single letter in policy details: $rawPolicy")
    }

    return CorporatePasswordPolicyDetails(first, second, letterString[0])
}
