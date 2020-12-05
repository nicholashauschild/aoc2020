package aoc2020

import java.io.File
import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Paths

class BadInputException(message: String) : RuntimeException(message)

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun <T> processLines(file: String, apply: (String)->T): List<T> {
    val resource = object {}::class.java.classLoader.getResource("$file.txt").toURI()
    return Files.readAllLines(Paths.get(resource))
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map { apply(it) }
}