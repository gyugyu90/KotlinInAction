package lambda



fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age > 30 })

    println(listOf(1, 2, 3, 4).map { it * it })

    val numbers = listOf(1, 2, 3)
    println(!numbers.all { it == 3 })
    println(numbers.any { it != 3 })

    val people2 = listOf(Person("Alice", 29), Person("Bob", 31), Person("Carol", 31))
    println(people2.groupBy { it.age })

    val listOfLists = listOf(listOf(1, 2, 3), listOf(5, 6, 7, 8))
    println(listOfLists.flatten())

    people2.asSequence()
        .map (Person::name)
        .filter { it.startsWith("A") }
        .toList()

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())


}

class Book(val title: String, val authors: List<String>)
