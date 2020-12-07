package aoc2020.day4

internal val isPassportValid1 = { passport: Passport ->
    passport.byr != null &&
            passport.iyr != null &&
            passport.eyr != null &&
            passport.hgt != null &&
            passport.hcl != null &&
            passport.ecl != null &&
            passport.pid != null
}

fun main() {
    val passports = processedInput()

    println(passports.count { isPassportValid2(it) })
}