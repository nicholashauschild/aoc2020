package aoc2020.day9

import aoc2020.processLines
import java.util.ArrayList

// data structures
internal class XmasEncryptedFile(
    val lines: List<Long>
)

// functionality
internal fun XmasEncryptedFile.initiateHack(preambleSize: Int = 25): Long {
    for(i in 0 until (lines.size - preambleSize - 1)) {
        if( validateEntry(lines.slice(i..(i + preambleSize))) < 0 ) {
            return lines[i + preambleSize]
        }
    }
    return -1
}

internal fun XmasEncryptedFile.exposeWeakness(attackValue: Long): Long {
    lines.forEachIndexed { index, first ->
        var runningTotal = first
        val runningList = ArrayList<Long>()
        runningList += first
        for(cur in lines.subList( index + 1, lines.size )) {
            runningTotal += cur
            runningList += cur
            if( runningTotal == attackValue ) {
                runningList.sort()
                return runningList.first() + runningList.last()
            } else if( runningTotal > attackValue) {
                break
            }
        }
    }
    return -1
}

private fun validateEntry(entry: List<Long>): Long {
    val target = entry.last()
    val previous = entry.subList(0, entry.size - 1)
    previous.forEachIndexed { index, first ->
        previous.subList(index + 1, previous.size).forEach { second ->
            if(first + second == target) {
                return 0
            }
        }
    }
    return -1
}

// input processing
internal fun processedInput(): XmasEncryptedFile {
    return XmasEncryptedFile(processLines("input_9", String::toLong))
}