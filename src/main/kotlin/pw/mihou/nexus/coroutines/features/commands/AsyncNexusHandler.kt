package pw.mihou.nexus.coroutines.features.commands

import kotlinx.coroutines.runBlocking
import pw.mihou.nexus.features.command.facade.NexusCommandEvent
import pw.mihou.nexus.features.command.facade.NexusHandler

interface AsyncNexusHandler: NexusHandler {
    override fun onEvent(event: NexusCommandEvent) {
        // runBlocking is used since Nexus already wraps the handlers with the async launcher
        // which means that if `Nexus.useCoroutines` was used, we'd be running in a coroutine already.
        // If not, we'd be running on another separate thread anyway, which is already async.
        runBlocking { on(event) }
    }
    suspend fun on(event: NexusCommandEvent)
}