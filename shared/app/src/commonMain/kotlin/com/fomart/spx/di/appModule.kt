package com.fomart.spx.di

import com.fomart.spx.core.data.di.dataModule
import org.koin.dsl.module

val appModule = module {
    includes(
        dataModule,
        featureModule
    )
}