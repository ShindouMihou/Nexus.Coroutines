@file:Suppress("FunctionName")

package pw.mihou.nexus.coroutines.features.messages

import org.javacord.api.DiscordApi
import org.javacord.api.entity.message.Message
import org.javacord.api.entity.message.Messageable
import org.javacord.api.event.message.CertainMessageEvent
import pw.mihou.nexus.coroutines.utils.coroutine
import pw.mihou.nexus.features.messages.R
import pw.mihou.nexus.features.react.React
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

@JvmSynthetic
fun Messageable.AsyncR(api: DiscordApi, lifetime: Duration = 1.hours, react: suspend React.() -> Unit) =
    R(api, lifetime) {
        coroutine {
            react()
        }
    }

@JvmSynthetic
fun Message.AsyncR(lifetime: Duration = 1.hours, react: suspend React.() -> Unit) =
    R(lifetime) {
        coroutine {
            react()
        }
    }

@JvmSynthetic
fun CertainMessageEvent.AsyncR(lifetime: Duration = 1.hours, react: suspend React.() -> Unit) =
    R(lifetime) {
        coroutine {
            react()
        }
    }
