package aoc2020

import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Paths

class BadInputException(message: String) : RuntimeException(message)

fun <T> processLines(file: String, apply: (String)->T): List<T> {
    return Files.readAllLines(Paths.get("src/main/resources/$file.txt"))
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map { apply(it) }
}