package aoc2020.day10

fun main() {
    val adapterBag = processInput()

    val distributions = adapterBag.joltageDiffDistributions()
    val ones = distributions.getOrDefault(1, 0)
    val twos = distributions.getOrDefault(2, 0)
    val threes = distributions.getOrDefault(3, 0)
    println("$ones, $twos, $threes, 1's x 3's ${ones * threes}")
}