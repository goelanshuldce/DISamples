package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.CommandProcessor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CommandsModule::class, SystemOutModule::class, UserCommandsRouter.InstallationModule::class])
internal interface CommandProcessorFactory {
    fun commandProcessor(): CommandProcessor

    companion object {
        fun create(): CommandProcessorFactory {
            return DaggerCommandProcessorFactory.create()
        }
    }
}