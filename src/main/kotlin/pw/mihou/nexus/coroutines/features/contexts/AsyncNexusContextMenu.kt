package pw.mihou.nexus.coroutines.features.contexts

import kotlinx.coroutines.runBlocking
import org.javacord.api.event.interaction.MessageContextMenuCommandEvent
import org.javacord.api.event.interaction.UserContextMenuCommandEvent
import org.javacord.api.interaction.MessageContextMenuInteraction
import org.javacord.api.interaction.UserContextMenuInteraction
import pw.mihou.nexus.features.contexts.NexusContextMenuEvent
import pw.mihou.nexus.features.contexts.enums.ContextMenuKinds
import pw.mihou.nexus.features.contexts.facade.NexusContextMenuHandler

abstract class AsyncNexusUserContextMenu: NexusContextMenuHandler<UserContextMenuCommandEvent, UserContextMenuInteraction> {
    val kind = ContextMenuKinds.USER

    override fun onEvent(event: NexusContextMenuEvent<UserContextMenuCommandEvent, UserContextMenuInteraction>) {
        runBlocking { on(event) }
    }

    abstract suspend fun on(event: NexusContextMenuEvent<UserContextMenuCommandEvent, UserContextMenuInteraction>)
}

abstract class AsyncNexusMessageContextMenu:
    NexusContextMenuHandler<MessageContextMenuCommandEvent, MessageContextMenuInteraction> {
    val kind = ContextMenuKinds.MESSAGE

    override fun onEvent(event: NexusContextMenuEvent<MessageContextMenuCommandEvent, MessageContextMenuInteraction>) {
        runBlocking { on(event) }
    }

    abstract suspend fun on(event: NexusContextMenuEvent<MessageContextMenuCommandEvent, MessageContextMenuInteraction>)
}