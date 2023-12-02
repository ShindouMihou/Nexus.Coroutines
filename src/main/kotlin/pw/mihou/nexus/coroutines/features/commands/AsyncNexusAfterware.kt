package pw.mihou.nexus.coroutines.features.commands

import pw.mihou.nexus.coroutines.utils.coroutine
import pw.mihou.nexus.features.command.facade.NexusCommandEvent
import pw.mihou.nexus.features.command.interceptors.facades.NexusAfterware

interface AsyncNexusAfterware: NexusAfterware {
    override fun onAfterCommandExecution(event: NexusCommandEvent) {
        coroutine {
            onDispatch(event)
        }
    }

    override fun onFailedDispatch(event: NexusCommandEvent) {
        coroutine {
            onDispatchPrevented(event)
        }
    }

    suspend fun onDispatch(event: NexusCommandEvent)
    suspend fun onDispatchPrevented(event: NexusCommandEvent)
}