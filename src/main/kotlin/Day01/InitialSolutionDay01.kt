package Day01

import readInput
import java.util.ArrayList

fun main() {

    // part 2
    val input = readInput("Day01")
    val numbers = ArrayList<Int>()
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
    input.forEach { line ->
        val digitIndexMap = HashMap<Int, String>()
        digitsAsWords.entries.forEach { pair ->
            val indexWordFirst = line.indexOf(pair.key, 0, true)
            val indexDigitFirst = line.indexOf(pair.value, 0, true)
            val indexWordLast = line.lastIndexOf(pair.key, line.length, true)
            val indexDigitLast = line.lastIndexOf(pair.value, line.length, true)

            if (indexWordFirst != -1)
                digitIndexMap.put(indexWordFirst, pair.value)

            if (indexDigitFirst != -1)
                digitIndexMap.put(indexDigitFirst, pair.value)

            if (indexWordFirst != -1)
                digitIndexMap.put(indexWordLast, pair.value)

            if (indexDigitFirst != -1)
                digitIndexMap.put(indexDigitLast, pair.value)
        }

        if (digitIndexMap.isNotEmpty()) {
            val number = String.format("%s%s", digitIndexMap.entries.minByOrNull { it.key }!!.value,
                digitIndexMap.entries.maxByOrNull { it.key }!!.value
            )
            numbers.add(number.toInt())
        }
    }

    println(numbers.sum())
}