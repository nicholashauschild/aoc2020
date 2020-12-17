package aoc2020.day10

import aoc2020.BadInputException
import aoc2020.processLines
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// data structures
internal class AdapterBag(
    val adapters: MutableList<JoltageAdapter>
)

internal class JoltageAdapter(
    override val outputJoltage: Int
): JoltHolder {
    override fun toString(): String {
        return "Adapter: $outputJoltage"
    }
}

internal class Device(
    override val outputJoltage: Int
): JoltHolder {
    override fun toString(): String {
        return "Device: $outputJoltage"
    }
}

internal object ChargingOutlet: JoltHolder {
    override val outputJoltage: Int = 0
    override fun toString(): String {
        return "ChargingOutlet: $outputJoltage"
    }
}

internal interface JoltHolder {
    val outputJoltage: Int
}

// functionality
internal fun AdapterBag.joltageDiffDistributions(): Map<Int, Int> {
    var cur = 0
    val diffs = HashMap<Int, Int>()
    sortedJoltageHolders().forEach {
        val jolt = it.outputJoltage
        if (jolt - cur > 3) {
            throw BadInputException("Joltage jump is greater than 3: $cur -> $jolt")
        }

        diffs.merge(jolt - cur, 1) { curVal, newVal ->
            curVal + newVal
        }
        cur = jolt
    }

    return diffs
}

internal fun AdapterBag.generateDifferentials(): List<Int> {
    val ints = ArrayList<Int>()
    val joltHolders = sortedJoltageHolders()

    var cur = 0
    joltHolders.subList(1, joltHolders.size).forEach {
        ints.add(it.outputJoltage - cur)
        cur = it.outputJoltage
    }
    return ints
}

internal fun <T> List<T>.runsOf(target: T): List<Long> {
    val out = ArrayList<Long>()

    var cur = 0L
    iterator().forEach {
        if(it == target) {
            cur++
        } else if(cur > 0) {
            out.add(cur)
            cur = 0
        }
    }
    return out
}

private fun AdapterBag.sortedJoltageHolders(): List<JoltHolder> {
    val joltHolders = ArrayList<JoltHolder>(adapters)
    joltHolders += ChargingOutlet
    joltHolders += Device(adapters.maxOf { it.outputJoltage } + 3)
    joltHolders.sortBy { it.outputJoltage }
    return joltHolders
}

// input processing
internal fun processInput(): AdapterBag {
    return AdapterBag(ArrayList(processLines("input_10", ::createJoltageAdapter)))
}

internal fun createJoltageAdapter(input: String): JoltageAdapter {
    return JoltageAdapter(input.toInt())
}