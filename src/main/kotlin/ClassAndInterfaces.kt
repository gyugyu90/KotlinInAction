fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()

    println(FacebookUser(1928374).nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)

    val userWithAddress = UserWithAddress("Alice")
    userWithAddress.address = "Seoul"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)

    val client = Client("홍길동", 4122)
    println(client)

    DelegatingCollection<String>().size

    Payroll.calculateSalary()
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable")
}

class Button : Clickable, Focusable {

    override fun click() {
        println("I was clicked")
    }
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

abstract class Animated {
    abstract fun animate() // open
    open fun stopAnimating() {
        // open to override
    }
    fun animateTwice() {
        // final
    }
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.left) + eval(e.right)
    }

class User(val nickname: String)

class VerboseUser constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
}

open class SnsUser(val nickname: String)
class TwitterUser(nickname: String): SnsUser(nickname)

// 추상 프로퍼티 선언
interface UserWithNickname {
    val nickname: String
}

class PrivateUser(override val nickname: String) : UserWithNickname

class SubscribingUser(val email: String) : UserWithNickname {
    override val nickname: String
        get() = email.substringBefore("@")
}

class FacebookUser(val accountId: Int) : UserWithNickname {
    override val nickname: String
        get() = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "FB$accountId"
    }
}

class UserWithAddress(val name: String) {
    var address: String = "unspecified"
        set (value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".
            """.trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

data class Client(val name: String, val postalCode: Int)

// class delegation `by`
class DelegatingCollection<T> (
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList { }

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            // ...
        }
    }
}

class Person {

}

class CompanionObjectUser private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = CompanionObjectUser(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) = CompanionObjectUser(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int): String {
            TODO("Not yet implemented")
        }
    }
}