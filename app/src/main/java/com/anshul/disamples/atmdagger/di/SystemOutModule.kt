package com.anshul.disamples.atmdagger.di

import dagger.Provides
import com.anshul.disamples.atmdagger.Outputter
import dagger.Module

@Module
internal object SystemOutModule {

    @JvmStatic
    @Provides
    fun textOutputter(): Outputter {
        return Outputter{ x: String -> println(x) }
    }
}