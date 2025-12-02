package com.fomart.spx.core.network.di

import com.fomart.spx.core.network.data.KtorRocketsDataSource
import com.fomart.spx.core.network.domain.RocketsDataSource
import org.koin.dsl.module

val networkModule = module {
    single<RocketsDataSource> { KtorRocketsDataSource(get()) }
}