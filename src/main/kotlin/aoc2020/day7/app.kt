package aoc2020.day7

import aoc2020.BadInputException
import aoc2020.processLines

// data structures
internal class BaggageRules(
    val rules: List<BaggageRule>
)

internal class BaggageRule(
    val color: String,
    val ruleClauses: Set<ContainsRuleClause> = emptySet()
) {
    override fun toString(): String {
        return "$color: $ruleClauses"
    }
}

internal class ContainsRuleClause(
    val count: Int,
    val color: String
) {
    override fun equals(other: Any?): Boolean {
        val o = (other as ContainsRuleClause)
        return count == o.count && color == o.color
    }

    override fun hashCode(): Int {
        return 31 * count + color.hashCode()
    }

    override fun toString(): String {
        return "$count of $color"
    }
}

// functionality
internal fun BaggageRules.findBagColorsThatCanContain(target: String): Set<String> {
    val foundInBags = buildFoundInBagsMap()
    return findBagsThatContain(target, HashSet<String>(), foundInBags)
}

internal fun BaggageRules.countBagsRequiredIn(target: String): Int {
    val map = HashMap<String, Set<ContainsRuleClause>>()
    rules.forEach {
        map[it.color] = it.ruleClauses
    }

    return countBagsIn(target, map)
}

private fun countBagsIn(target: String, map: Map<String, Set<ContainsRuleClause>>): Int {
    return (map[target] ?: emptySet()).sumBy {
        it.count * countBagsIn(it.color, map) + it.count
    }
}

private fun BaggageRules.buildFoundInBagsMap(): Map<String, Set<String>> {
    val map = HashMap<String, MutableSet<String>>()
    rules.forEach { rule ->
        rule.ruleClauses.forEach {
            map.compute(it.color) { _, v ->
                if(v == null) {
                    hashSetOf(rule.color)
                } else {
                    v.add(rule.color)
                    v
                }
            }
        }
    }

    return map
}

private fun BaggageRules.findBagsThatContain(target: String,
                                             seen: MutableSet<String>,
                                             bagMap: Map<String, Set<String>>): Set<String> {
    val out = HashSet<String>()
    val bagsThatContainTarget = bagMap.getOrDefault(target, HashSet<String>())
    out.addAll(bagsThatContainTarget)

    bagsThatContainTarget.forEach {
        if(it !in seen) {
            seen.add(target)
            out.addAll(findBagsThatContain(it, seen, bagMap))
        }
    }

    return out
}

// input processing
internal fun processedInput(): BaggageRules {
    return BaggageRules(processLines("input_7", ::createBaggageRule))
}

internal fun createBaggageRule(input: String): BaggageRule {
    val words = input.split(" ")
    val color = "${words[0]}_${words[1]}"
    if (words.size == 7) {
        return BaggageRule(color)
    }

    if (words.size % 4 != 0) {
        throw BadInputException("Unexpected BaggageRule text: $input")
    }

    var clauses = words.subList(4, words.size)
    val rulesClauses = HashSet<ContainsRuleClause>()
    while(clauses.isNotEmpty()) {
        rulesClauses.add(ContainsRuleClause(clauses[0].toInt(), "${clauses[1]}_${clauses[2]}"))
        clauses = clauses.subList(4, clauses.size)
    }

    return BaggageRule(color, rulesClauses)
}