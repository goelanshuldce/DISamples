package com.anshul.disamples.atmdagger.di

import dagger.Subcomponent
import javax.inject.Singleton
import dagger.BindsInstance
import com.anshul.disamples.atmdagger.CommandRouter
import com.anshul.disamples.atmdagger.Database
import dagger.Module


@Subcomponent(modules = [UserCommandsModule::class])
internal interface UserCommandsRouter {
    fun router(): CommandRouter?

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance account: Database.Account): UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule
}