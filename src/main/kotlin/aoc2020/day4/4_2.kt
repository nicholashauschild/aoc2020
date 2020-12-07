package aoc2020.day4

internal val validEyeColors = hashSetOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

internal val isPassportValid2 = { passport: Passport ->
    passport.byr != null && (passport.byr as String).toInt() in 1920..2002 &&
            passport.iyr != null && (passport.iyr as String).toInt() in 2010..2020 &&
            passport.eyr != null && (passport.eyr as String).toInt() in 2020..2030 &&
            passport.hgt != null &&
                    (((passport.hgt as String).matches(Regex("[0-9]{3}cm")) && (passport.hgt as String).slice(0..2).toInt() in 150..193) ||
                     ((passport.hgt as String).matches(Regex("[0-9]{2}in")) && (passport.hgt as String).slice(0..1).toInt() in 59..76)) &&
            passport.hcl != null && (passport.hcl as String).matches(Regex("#[0-9a-f]{6}")) &&
            passport.ecl != null && validEyeColors.contains(passport.ecl as String) &&
            passport.pid != null && (passport.pid as String).matches(Regex("[0-9]{9}"))
}

fun main() {
    val passports = processedInput()

    println(passports.count { isPassportValid2(it) })
}