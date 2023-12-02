@file:Suppress("FunctionName")

package pw.mihou.nexus.coroutines.features.react

import org.javacord.api.interaction.InteractionBase
import pw.mihou.nexus.coroutines.utils.coroutine
import pw.mihou.nexus.features.commons.R
import pw.mihou.nexus.features.react.React
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

@JvmSynthetic
fun <Interaction: InteractionBase> Interaction.AsyncR(ephemeral: Boolean, lifetime: Duration = 1.hours, react: React.() -> Unit) =
    R(ephemeral, lifetime) {
        coroutine {
            react()
        }
    }