package com.anshul.disamples.atmdagger.commands

import android.os.Build
import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.Database
import com.anshul.disamples.atmdagger.DoubleArgCommand
import com.anshul.disamples.atmdagger.Outputter
import java.math.BigDecimal
import javax.inject.Inject

internal class DepositCommand @Inject internal constructor(
    private val database: Database,
    private val outputter: Outputter): DoubleArgCommand() {

    init {
        println("Creating a new $this");
    }

    /** Handles the double argument to the command.  */
    override fun handleArgs(arg1: String, arg2: String): Command.Result {
        val account: Database.Account = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            database.getAccount(arg1)
        } else {
            return Command.Result.invalid()
        }
        account.deposit(BigDecimal(arg2))
        outputter.output(account.username() + " now has: " + account.balance())
        return Command.Result.handled()
    }
}