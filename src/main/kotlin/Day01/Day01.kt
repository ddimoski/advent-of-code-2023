package Day01

import readInput
import java.util.regex.Pattern

fun main() {

    // part 1
    val input = readInput("Day01")
    var numbers: ArrayList<Int> = ArrayList()
    input.forEach { line ->
        val numbersInLine = line.filter { it.isDigit() }.toList()
        if (numbersInLine.isNotEmpty()) {
            val number = String.format("%c%c", numbersInLine.first(), numbersInLine.last())
            numbers.add(number.toInt())
        }
    }
    println(numbers.sum())


    // part 2
    numbers = ArrayList()
    input.forEach { line ->
        val matcher =
            Pattern.compile("(?=(1|2|3|4|5|6|7|8|9|one|two|three|four|five|six|seven|eight|nine))").matcher(line)
        val indexDigitMap = HashMap<Int, String>()

        while (matcher.find()) {
            indexDigitMap.put(matcher.start(), getDigit(matcher.group(1)))
        }

        if (indexDigitMap.isNotEmpty()) {
            val number = String.format("%s%s", indexDigitMap.entries.minByOrNull { it.key }!!.value,
                indexDigitMap.entries.maxByOrNull { it.key }!!.value
            )
            numbers.add(number.toInt())
        }
    }
    println(numbers.sum())

}

fun getDigit(value: String): String {
    val digitsAsWords =
        mapOf(
            Pair("one", "1"),
            Pair("two", "2"),
            Pair("three", "3"),
            Pair("four", "4"),
            Pair("five", "5"),
            Pair("six", "6"),
            Pair("seven", "7"),
            Pair("eight", "8"),
            Pair("nine", "9")
        )
    return digitsAsWords.get(value) ?: value
}