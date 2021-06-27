package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.Command
import com.anshul.disamples.atmdagger.commands.DepositCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
internal interface UserCommandsModule {


    @Binds
    @IntoMap
    @StringKey("deposit")
    fun depositCommand(command: DepositCommand): Command
}