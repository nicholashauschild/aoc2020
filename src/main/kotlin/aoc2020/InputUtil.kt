package aoc2020

import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class BadInputException(message: String) : RuntimeException(message)

fun processLines(file: String): List<String> {
    return Files.readAllLines(pathOf(file))
        .map { it.trim() }
}

fun <T> processLines(file: String, apply: (String)->T): List<T> {
    return processLines(file)
        .filter { it.isNotEmpty() }
        .map { apply(it) }
}

fun splitFile(file: String, delimiter: String): List<List<String>> {
    val lines = processLines(file)
    val out = ArrayList<List<String>>()
    var cur = ArrayList<String>()
    lines.forEach {
        if( it.trim() == delimiter) {
            out.add(cur)
            cur = ArrayList<String>()
        } else {
            cur.add(it)
        }
    }
    out.add(cur)
    return out
}

fun <T> splitFile(file: String, delimiter: String, apply: (List<String>)->T): List<T> {
    return splitFile(file, delimiter)
        .filter { it.isNotEmpty() }
        .map { apply(it) }
}

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
private fun pathOf(file: String): Path =
    Paths.get(object {}::class.java.classLoader.getResource("$file.txt").toURI())