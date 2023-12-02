package pw.mihou.nexus.coroutines.features.commands.router

import kotlinx.coroutines.runBlocking
import org.javacord.api.interaction.SlashCommandInteractionOption
import pw.mihou.nexus.features.command.facade.NexusCommandEvent
import pw.mihou.nexus.features.command.router.types.Routeable

interface AsyncRouteable: Routeable {
    override fun accept(event: NexusCommandEvent, option: SlashCommandInteractionOption) {
        // runBlocking considering that the dispatcher is already a coroutine, if we use
        // the `Nexus.useCoroutines` method. Don't create too many unnecessary coroutines.
        runBlocking {
            on(event, option)
        }
    }

    suspend fun on(event: NexusCommandEvent, option: SlashCommandInteractionOption)
    suspend fun route(name: String, from: SlashCommandInteractionOption, then: suspend (SlashCommandInteractionOption) -> Unit) {
        subcommand(name, from) {
            runBlocking {
                then(it)
            }
        }
    }
}