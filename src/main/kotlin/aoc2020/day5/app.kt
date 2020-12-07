package aoc2020.day5

import aoc2020.processLines
import kotlin.math.pow

// data structures
internal class BoardingPass(
    val encodedRow: String,
    val encodedColumn: String
) {
    override fun toString(): String {
        return "$encodedRow $encodedColumn"
    }
}

// functionality
internal fun BoardingPass.determineRow(): Int {
    return encodedRow.reversed().foldIndexed(0) { index, acc, char ->
        if(char == 'B') {
            acc + 2.0.pow(index).toInt()
        } else {
            acc
        }
    }
}

internal fun BoardingPass.determineColumn(): Int {
    return encodedColumn.reversed().foldIndexed(0) { index, acc, char ->
        if(char == 'R') {
            acc + 2.0.pow(index).toInt()
        } else{
            acc
        }
    }
}

internal fun BoardingPass.determineSeatNum(): Int {
    return determineRow() * 8 + determineColumn()
}

// input processing
internal fun processedInput(): List<BoardingPass> {
    return processLines("input_5", ::createBoardingPass)
}

internal fun createBoardingPass(input: String): BoardingPass {
    return BoardingPass(input.substring(0, 7), input.substring(7, 10))
}