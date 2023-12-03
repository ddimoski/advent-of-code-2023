package Day02

import readInput

fun main() {

    // part 1
    val input = readInput("Day02")
    val maximumBalls = mapOf(
        Pair("red", 12),
        Pair("green", 13),
        Pair("blue", 14)
    )
    var sumOfIndexes = 0
    input.forEach line@{ line ->
        val gameInfo = line.split(":") // gameInfo[0] - meta data, gameInfo[1] - values
        val gameNumber = gameInfo[0].split(" ").get(1).toInt()
        gameInfo.get(1).trim().split(";").forEach game@{ game ->
            val colorPairs = HashMap<String, Int>()
            game.trim().split(",").forEach bag@{
                val numberOfBalls = it.trim().split(" ").get(0).trim().toInt()
                val color = it.trim().split(" ").get(1).trim()
                if (colorPairs.containsKey(color))
                    colorPairs.put(color, colorPairs.get(color)!! + numberOfBalls)
                else
                    colorPairs.put(color, numberOfBalls)
                if (colorPairs.get(color)!! > maximumBalls.get(color)!!) {
                    return@line
                }
            }
        }
        sumOfIndexes += gameNumber
    }
    println(sumOfIndexes)

    var sumOfPowers = 0
    // part 2
    input.forEach line@{ line ->
        val gameInfo = line.split(":") // gameInfo[0] - meta data, gameInfo[1] - values
        val colorPairs = HashMap<String, Int>()
        gameInfo.get(1).trim().split(";").forEach game@{ game ->
            game.trim().split(",").forEach bag@{
                val (numberOfBalls, color) = it.trim().split(" ")

                if (colorPairs.containsKey(color) && numberOfBalls.toInt() > colorPairs.get(color)!!)
                    colorPairs.put(color, numberOfBalls.toInt())
                else if (!colorPairs.containsKey(color))
                    colorPairs.put(color, numberOfBalls.toInt())

            }
        }
        val powerOfMax = colorPairs.map { it.value }.reduce { a, b -> a * b }
        sumOfPowers += powerOfMax
    }

    println(sumOfPowers)

}