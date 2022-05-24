import java.lang.StringBuilder

fun main() {
    val list = listOf(1, 2, 3)
    println(list)

    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
    println(list.joinToString())
    println(list.joinToString("; "))

    println("abc".lastChar())

    listOf("aa", "bb", "cc").last()

    mapOf(1 to "one")
    val pair = 1.to("one")
    print(pair)
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = this.get(this.length - 1) // extension
