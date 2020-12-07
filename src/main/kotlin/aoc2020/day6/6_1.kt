package aoc2020.day6

internal val countingFunction1 = { acc: MutableSet<Question>, declaration: CustomsDeclaration ->
    acc.union(declaration.yesQuestions).toMutableSet()
}

internal fun createEmptySet(): MutableSet<Question> {
    return HashSet<Question>()
}

fun main() {
    val customDeclarationGroups = processedInput()

    println(customDeclarationGroups.sumBy { it.countYesForGroup(createEmptySet(), countingFunction1) })
}