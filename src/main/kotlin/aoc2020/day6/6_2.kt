package aoc2020.day6

internal val countingFunction2 = { acc: MutableSet<Question>, declaration: CustomsDeclaration ->
    acc.intersect(declaration.yesQuestions).toMutableSet()
}

internal fun createFullSet(): MutableSet<Question> {
    val out = HashSet<Question>()
    ('a'..'z').forEach { out.add(Question(it)) }
    return out
}

fun main() {
    val customDeclarationGroups = processedInput()

    println(customDeclarationGroups.sumBy { it.countYesForGroup(createFullSet(), countingFunction2) })
}