package com.anshul.disamples.atmdagger.di

import com.anshul.disamples.atmdagger.Outputter
import dagger.Module
import dagger.Provides

@Module
internal object SystemOutModule {

    @JvmStatic
    @Provides
    fun textOutputter(): Outputter {
        return Outputter { x: String -> println(x) }
    }
}