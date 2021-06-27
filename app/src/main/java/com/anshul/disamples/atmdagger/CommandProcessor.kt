package com.anshul.disamples.atmdagger

import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Processes successive commands by delegating to a [CommandRouter].
 *
 * <p>Whereas [CommandRouter] routes an input string to a particular [Command], this
 * class maintains inter-command state to determine which [CommandRouter] should route
 * successive commands.
 *
 * <p>This class is [Singleton] scoped because it has mutable state [commandRouterStack],
 * and all users of [CommandProcessor] must use the same instance.
 *
 */
@Singleton
internal class CommandProcessor @Inject internal constructor(firstCommandRouter: CommandRouter) {
    private val commandRouterStack: Deque<CommandRouter> = LinkedList()
    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Command.Status {
        val commandRouter = commandRouterStack.peek()
        commandRouter?.let {
            val result = it.route(input)
            when (result.status()) {
                Command.Status.HANDLED -> {
                    result.nestedCommandRouter()?.let { nestedCommandRouter ->
                        commandRouterStack.push(nestedCommandRouter)
                    }
                }
                Command.Status.INPUT_COMPLETED -> {
                    commandRouterStack.pop()
                    return if (commandRouterStack.isEmpty()) Command.Status.INPUT_COMPLETED else Command.Status.HANDLED
                }
                Command.Status.INVALID -> {
                    result.status()
                }
            }
            throw AssertionError(result.status())
        }
        throw IllegalStateException("No command router is available!")
    }
}