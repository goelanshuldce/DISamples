package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.CommandRouter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserCommandsModule::class, SystemOutModule::class])
internal interface CommandRouterFactory {
    fun router(): CommandRouter
}