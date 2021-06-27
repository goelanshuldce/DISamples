package com.anshul.disamples.atmdagger

import android.os.Build
import androidx.annotation.RequiresApi
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class Database @Inject constructor() {

    init {
        println("Creating a new $this");
    }

    private val accounts: MutableMap<String, Account> = HashMap()
    @RequiresApi(Build.VERSION_CODES.N)
    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) {uname ->
            Account(uname)
        }
    }

    internal class Account(private val username: String) {
        private var balance: BigDecimal = BigDecimal.ZERO
        fun username(): String {
            return username
        }

        fun balance(): BigDecimal {
            return balance
        }

        fun deposit(bigDecimal: BigDecimal) {
            balance += bigDecimal
        }
    }
}