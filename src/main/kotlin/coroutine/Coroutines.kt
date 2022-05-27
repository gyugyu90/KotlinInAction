import kotlinx.coroutines.*
import java.time.LocalDateTime

fun main() {
//    log("main() started")
//    launchInGlobalScope()
//    runBlockingExample()
//    log("launchInGlobalScope() executed")
//    Thread.sleep(5000L)
//    log("main() terminated")

    sumAll()
}

fun log(msg: String) = println("${LocalDateTime.now()}: ${Thread.currentThread()}: $msg")

fun launchInGlobalScope() {
    GlobalScope.launch {
        log("coroutine started.")
    }
}

fun runBlockingExample() {
    runBlocking {
        launch {
            log("coroutine started.")
        }
    }
}

fun sumAll() {
    runBlocking {
        val d1 = async { delay(1000L); 1 }
        log("after async(d1)")
        val d2 = async { delay(2000L); 2 }
        log("after async(d2)")
        val d3 = async { delay(3000L); 3 }
        log("after async(d3)")

        log("1+2+3 = ${d1.await() + d2.await() + d3.await()}")
        log("after await all & add")
    }
}