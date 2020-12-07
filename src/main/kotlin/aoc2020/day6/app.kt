package aoc2020.day6

import aoc2020.splitFile

// data structures
internal class CustomsDeclarationGroup(
    val customDeclarations: List<CustomsDeclaration>
)

internal class CustomsDeclaration(
    val yesQuestions: Set<Question>
)

internal class Question(
    val char: Char
) {
    override fun equals(other: Any?): Boolean {
        return char == (other as Question).char
    }

    override fun hashCode(): Int {
        return char.hashCode()
    }
}

// functionality
internal fun CustomsDeclarationGroup.countYesForGroup(initial: MutableSet<Question>,
                                                      countingFunction: (MutableSet<Question>, CustomsDeclaration) -> MutableSet<Question>): Int {
    return customDeclarations.fold(initial, countingFunction).size
}

// input processing
internal fun processedInput(): List<CustomsDeclarationGroup> {
    return splitFile("input_6", "", ::createCustomsDeclarationGroup)
}

internal fun createCustomsDeclarationGroup(input: List<String>): CustomsDeclarationGroup {
    return CustomsDeclarationGroup(input.map {
        CustomsDeclaration(it.map {
            Question(it)
        }.toSet())
    })
}