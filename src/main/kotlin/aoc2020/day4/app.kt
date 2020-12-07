package aoc2020.day4

import aoc2020.processLines
import aoc2020.splitFile

// data structures
internal class Passport(
    fields: Map<String, String>
) {
    private val defaultedFields = fields.withDefault { null }

    val byr: String? by defaultedFields
    val iyr: String? by defaultedFields
    val eyr: String? by defaultedFields
    val hgt: String? by defaultedFields
    val hcl: String? by defaultedFields
    val ecl: String? by defaultedFields
    val pid: String? by defaultedFields
    val cid: String? by defaultedFields

    override fun toString(): String {
        return "Passport: [$byr, $iyr, $eyr, $hgt, $hcl, $ecl, $pid, $cid]"
    }
}

// input processing
internal fun processedInput(): List<Passport> {
    return splitFile("input_4", "", ::createPassport)
}

internal fun createPassport(fileLines: List<String>): Passport {
    val fields = HashMap<String, String>()
    fileLines.forEach {
        it.split(" ").forEach {
            val kv = it.split(":")
            fields.put(kv[0], kv[1])
        }
    }
    return Passport(fields)
}