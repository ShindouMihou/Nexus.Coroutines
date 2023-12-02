package pw.mihou.nexus.coroutines.utils

import kotlinx.coroutines.*
import pw.mihou.nexus.Nexus

private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
fun coroutine(task: suspend () -> Unit) =
    scope.launch {
        try {
            task()
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: Exception) {
            Nexus.logger.error("An uncaught exception was captured by the coroutine launcher.", exception)
        }
    }