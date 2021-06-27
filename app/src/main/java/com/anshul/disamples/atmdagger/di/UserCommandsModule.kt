package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.commands.LoginCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import com.anshul.disamples.atmdagger.commands.DepositCommand
import com.anshul.disamples.atmdagger.commands.HelloWorldCommand


@Module
internal interface UserCommandsModule {

    @IntoMap
    @StringKey("login")
    @Binds
    fun loginCommand(loginCommand: LoginCommand): Command

    @Binds
    @IntoMap
    @StringKey("deposit")
    fun depositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey("hello")
    fun helloWorldCommand(helloWorldCommand: HelloWorldCommand): Command
}