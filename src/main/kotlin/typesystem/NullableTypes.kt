package typesystem

class NullableTypes {
}

fun main() {
    // strLen(null) => compile error

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)

    printShippingLabel(person)
}


fun strLen(s: String) = s.length

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase() // allCaps can be null
    println(allCaps)
}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class Person(val name: String, val company: Company?) {

}

class Company(val name: String, val address: Address?) {

}

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String) {

}
