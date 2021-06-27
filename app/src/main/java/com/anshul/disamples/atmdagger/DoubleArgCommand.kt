package com.anshul.disamples.atmdagger

internal abstract class DoubleArgCommand: Command {

    /** Process the rest of the command's words and do something.  */
    override fun handleInput(input: List<String>): Command.Result {
        return if (input.size == 2) handleArgs(input[0],input[1]) else Command.Result.invalid()
    }

    /** Handles the double argument to the command.  */
    abstract fun handleArgs(arg1: String, arg2: String): Command.Result
}