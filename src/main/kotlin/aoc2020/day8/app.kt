package aoc2020.day8

import aoc2020.BadInputException
import aoc2020.processLines
import java.lang.RuntimeException

// data structures
internal class BootCodeListing(
    val instructions: List<BootCodeLine>
) {
    override fun toString(): String {
        return instructions.toString()
    }
}

internal class BootCodeLine(
    val operation: String,
    val argument: Int
) {
    override fun toString(): String {
        return "$operation $argument"
    }
}

internal class StateUpdate(
    val instructionDelta: Int = 1,
    val accumulatorDelta: Int = 0
)

internal class UnknownOperationException(operation: String): RuntimeException("Unknown operation: $operation")
internal class LoopException(val instructionIndex: Int, val accumulator: Int):
    RuntimeException("Instruction loop encountered at instruction $instructionIndex, aborting boot sequence.")
internal class RepairFailure(): RuntimeException("Unable to automatically repair BootCodeListing")

// functionality
internal fun BootCodeListing.execute(): Int {
    val lastInstructionIndex = instructions.size - 1

    var acc = 0
    var instIndex = 0
    val previousInstructions = HashSet<Int>()
    while (instIndex != lastInstructionIndex) {
        if(instIndex in previousInstructions) {
            throw LoopException(instIndex, acc)
        }
        previousInstructions += instIndex
        val update = instructions[instIndex].evaluate()
        acc += update.accumulatorDelta
        instIndex += update.instructionDelta
    }
    acc += instructions[instIndex].evaluate().accumulatorDelta
    return acc
}

internal fun repair(listing: BootCodeListing): Int {
    val instructions = listing.instructions

    instructions.forEachIndexed { index, line ->
        val newOp = when(line.operation) {
            "nop" -> "jmp"
            "jmp" -> "nop"
            else -> null
        }
        if(newOp != null) {
            val newList = instructions.toMutableList()
            newList[index] = BootCodeLine(newOp, line.argument)

            try {
                return BootCodeListing(newList).execute()
            } catch(ex: LoopException) {
                // attempt to repair the next instruction
            }
        }
    }
    throw RepairFailure()
}

internal fun BootCodeLine.evaluate(): StateUpdate {
    return when(operation) {
        "nop" -> StateUpdate()
        "jmp" -> StateUpdate(instructionDelta = argument)
        "acc" -> StateUpdate(accumulatorDelta = argument)
        else -> throw UnknownOperationException(operation)
    }
}

// input processing
internal fun processedInput(): BootCodeListing {
    return BootCodeListing(processLines("input_8", ::createBootCodeLine))
}

internal fun createBootCodeLine(input: String): BootCodeLine {
    val parts = input.split(" ")
    return BootCodeLine(parts[0], parts[1].toInt())
}