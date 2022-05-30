package lambda

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    val eldest = people.maxByOrNull(Person::age)
    println(eldest)

    val map : Map<String?, String> = mapOf("foo" to "FOO", null to "BAR")
    println(map)

    val names = people.joinToString(separator = " ", transform = {
        p: Person -> p.name
    })
    println(names)

    val names2 = people.joinToString(separator = " ") {
        person -> person.name
    }
    println(names2)
}

