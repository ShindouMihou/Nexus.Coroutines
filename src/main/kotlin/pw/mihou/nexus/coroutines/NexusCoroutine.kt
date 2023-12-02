package pw.mihou.nexus.coroutines

import kotlinx.coroutines.delay
import pw.mihou.nexus.Nexus
import pw.mihou.nexus.configuration.modules.Cancellable
import pw.mihou.nexus.configuration.modules.NexusLaunchWrapper
import pw.mihou.nexus.configuration.modules.NexusScheduledLaunchWrapper
import pw.mihou.nexus.coroutines.utils.coroutine

fun Nexus.useCoroutines() {
    configuration.launch.launcher = NexusLaunchWrapper { task ->
        coroutine {
            task.run()
        }
    }
    configuration.launch.scheduler = NexusScheduledLaunchWrapper { timeInMillis, task ->
        return@NexusScheduledLaunchWrapper object: Cancellable {
            val scheduledTask = coroutine {
                delay(timeInMillis)
                task.run()
            }

            override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                scheduledTask.cancel()
                return true
            }
        }
    }
}