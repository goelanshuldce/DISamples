package com.anshul.disamples.atmdagger

import javax.inject.Inject

class CommandRouter @Inject internal constructor(
    private val commands: Map<String, @JvmSuppressWildcards Command>,
    private val outputter: Outputter
) {

    /**
     * Calls [Command.handleInput] on this router's [commands].
     */
    internal fun route(input: String): Command.Result {
        val splitInput: List<String> = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)
        val result: Command.Result = command.handleInput(splitInput.subList(1, splitInput.size))
        if (result.status() == Command.Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return result
    }

    private fun invalidCommand(input: String): Command.Result {
        println("couldn't understand $input. please try again.")
        return Command.Result.invalid()
    }

    companion object {
        private fun split(string: String): List<String> {
            return string.split(" ")
        }
    }
}
