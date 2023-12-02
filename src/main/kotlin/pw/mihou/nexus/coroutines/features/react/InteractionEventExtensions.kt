package pw.mihou.nexus.coroutines.features.react

import kotlinx.coroutines.future.await
import kotlinx.coroutines.runBlocking
import org.javacord.api.event.interaction.ApplicationCommandEvent
import org.javacord.api.interaction.InteractionBase
import pw.mihou.nexus.features.commons.NexusInteractionEvent
import pw.mihou.nexus.features.commons.R
import pw.mihou.nexus.features.react.React
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

@JvmSynthetic
suspend fun <Event: ApplicationCommandEvent, Interaction: InteractionBase> NexusInteractionEvent<Event, Interaction>.AsyncR(ephemeral: Boolean = false, lifetime: Duration = 1.hours, react: React.() -> Unit)  =
    interaction.R(ephemeral, lifetime) {
        runBlocking {
            react()
        }
    }.await()