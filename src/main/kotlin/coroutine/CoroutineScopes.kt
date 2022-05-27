import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) { // 특정 스레드에 종속되지 않음 => main
            println("Unconfined: I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Default: I'm working in thread ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyOwnThread")) { // 새 스레드를 사용
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }
}