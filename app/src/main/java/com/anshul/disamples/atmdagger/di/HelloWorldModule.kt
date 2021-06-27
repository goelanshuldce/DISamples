package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.commands.HelloWorldCommand

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
internal interface HelloWorldModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    fun helloWorldCommand(helloWorldCommand: HelloWorldCommand): Command
}