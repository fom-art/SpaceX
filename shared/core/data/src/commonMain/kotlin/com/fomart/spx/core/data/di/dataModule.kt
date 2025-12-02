package com.fomart.spx.core.data.di

import com.fomart.spx.core.data.cache.InMemoryRocketsCacheDataSource
import com.fomart.spx.core.data.cache.RocketsCacheDataSource
import com.fomart.spx.core.data.data.RocketsRepositoryImpl
import com.fomart.spx.core.data.domain.RocketsRepository
import com.fomart.spx.core.network.di.networkModule
import com.fomart.spx.core.data.util.NetworkMonitor
import com.fomart.spx.core.data.util.NetworkMonitorImpl
import com.fomart.spx.core.network.http.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
    )
    single<HttpClient> { httpClient }
    single<NetworkMonitor> { NetworkMonitorImpl(client = get()) }

    single<RocketsCacheDataSource> { InMemoryRocketsCacheDataSource() }
    single<RocketsRepository> {
        RocketsRepositoryImpl(
            rocketsDataSource = get(),
            cacheDataSource = get()
        )
    }
}