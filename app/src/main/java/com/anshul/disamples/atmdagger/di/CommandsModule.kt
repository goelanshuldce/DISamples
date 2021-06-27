package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.commands.HelloWorldCommand
import com.anshul.disamples.atmdagger.commands.LoginCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
internal interface CommandsModule {

    @IntoMap
    @StringKey("login")
    @Binds
    fun loginCommand(loginCommand: LoginCommand): Command


    @Binds
    @IntoMap
    @StringKey("hello")
    fun helloWorldCommand(helloWorldCommand: HelloWorldCommand): Command
}