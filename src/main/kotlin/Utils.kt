import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(dayNumber: String) = File("src/main/kotlin/$dayNumber", "input.txt").readLines()