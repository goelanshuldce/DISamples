package com.anshul.disamples.atmdagger.commands

import android.os.Build
import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.Database
import com.anshul.disamples.atmdagger.Outputter
import com.anshul.disamples.atmdagger.SingleArgCommand
import javax.inject.Inject

internal class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database): SingleArgCommand() {

    init {
        println("Creating a new $this");
    }

    /** Handles the single argument to the command.  */
    override fun handleArg(arg: String): Command.Result {
        val account: Database.Account = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            database.getAccount(arg)
        } else {
            return Command.Result.invalid()
        }
        outputter.output("$arg is logged in with balance: ${account.balance()}")
        return Command.Result.handled()
    }

}