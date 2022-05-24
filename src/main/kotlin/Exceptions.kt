import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main() {
    println(readNumber(BufferedReader(StringReader("239"))))
    println(readNumber(BufferedReader(StringReader(""))))
}

fun validatePercentage(number: Int): Int {
    return if (number in 0..100)
        number
    else
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
}


fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}