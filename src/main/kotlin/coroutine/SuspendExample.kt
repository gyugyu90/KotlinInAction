package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import java.time.LocalDateTime

fun log(msg: String) = println("${LocalDateTime.now()}: ${Thread.currentThread()}: $msg")

suspend fun yieldThreeTimes() {
    log("1")
    delay(1000L)
    yield()
    log("2")
    delay(1000L)
    yield()
    log("3")
    delay(1000L)
    yield()
    log("4")
}

fun main() {
    GlobalScope.launch { yieldThreeTimes() }
    Thread.sleep(3000L)
}