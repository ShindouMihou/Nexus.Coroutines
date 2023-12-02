package pw.mihou.nexus.coroutines.features.express

import org.javacord.api.DiscordApi
import pw.mihou.nexus.coroutines.utils.coroutine
import pw.mihou.nexus.express.request.NexusExpressRequest

fun interface AsyncNexusExpressRequest: NexusExpressRequest {
    override fun onEvent(shard: DiscordApi) {
        coroutine {
            on(shard)
        }
    }
    fun on(shard: DiscordApi)
}