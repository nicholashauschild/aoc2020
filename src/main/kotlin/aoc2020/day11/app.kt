package aoc2020.day11

import aoc2020.processLines

// data structures
internal class FerrySeatLayout(
    val seats: List<List<FerrySlot>>
)

internal class FerrySlot(
    val seat: Boolean
)

internal class SeatOccupiedSnapshot(
    val occupied: List<List<Boolean>>
)

// functionality


// input processing
internal fun processInput(): FerrySeatLayout {
    return FerrySeatLayout(processLines("input_11", ::createFerrySeatLayout))
}

internal fun createFerrySeatLayout(input: String): List<FerrySlot> {
    return input.map { FerrySlot(it == 'L') }
}