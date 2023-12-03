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


/**
 * Initial (worse) solution for part 2:
 *
 *     numbers = ArrayList()
 *     val digitsAsWords =
 *         mapOf(
 *             Pair("one", "1"),
 *             Pair("two", "2"),
 *             Pair("three", "3"),
 *             Pair("four", "4"),
 *             Pair("five", "5"),
 *             Pair("six", "6"),
 *             Pair("seven", "7"),
 *             Pair("eight", "8"),
 *             Pair("nine", "9")
 *         )
 *     input.forEach { line ->
 *         val digitIndexMap = HashMap<Int, String>()
 *         digitsAsWords.entries.forEach { pair ->
 *             val indexWordFirst = line.indexOf(pair.key, 0,true)
 *             val indexDigitFirst = line.indexOf(pair.value, 0,true)
 *             val indexWordLast = line.lastIndexOf(pair.key, line.length,true)
 *             val indexDigitLast = line.lastIndexOf(pair.value, line.length,true)
 *
 *             if (indexWordFirst != -1)
 *                 digitIndexMap.put(indexWordFirst, pair.value)
 *
 *             if (indexDigitFirst != -1)
 *                 digitIndexMap.put(indexDigitFirst, pair.value)
 *
 *             if (indexWordFirst != -1)
 *                 digitIndexMap.put(indexWordLast, pair.value)
 *
 *             if (indexDigitFirst != -1)
 *                 digitIndexMap.put(indexDigitLast, pair.value)
 *         }
 *
 *         if (digitIndexMap.isNotEmpty()) {
 *             val number = String.format("%s%s", digitIndexMap.entries.minByOrNull { it.key }!!.value,
 *                 digitIndexMap.entries.maxByOrNull { it.key }!!.value)
 *             numbers.add(number.toInt())
 *         }
 *     }
 *
 *     println(numbers.sum())
 * */

