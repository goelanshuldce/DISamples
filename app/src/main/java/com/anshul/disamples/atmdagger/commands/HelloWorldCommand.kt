package com.anshul.disamples.atmdagger.commands

import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.Outputter
import javax.inject.Inject


internal class HelloWorldCommand @Inject constructor(private val outputter : Outputter) : Command {

    override fun handleInput(input: List<String>): Command.Result {
        if (input.isNotEmpty()) {
            return Command.Result.invalid()
        }
        outputter.output("world!")
        return Command.Result.handled()
    }
}