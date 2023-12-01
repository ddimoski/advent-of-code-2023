package Day01

import readInput

fun main(args: Array<String>) {

    val input = readInput("Day01")
    val numbers: ArrayList<Int> = ArrayList()
    input.forEach { line ->
        val numbersInLine = line.filter { it.isDigit() }.toList()
        if (numbersInLine.isNotEmpty()) {
            val number = String.format("%c%c", numbersInLine.first(), numbersInLine.last())
            numbers.add(number.toInt())
        }
    }

    println(numbers.sum())

}