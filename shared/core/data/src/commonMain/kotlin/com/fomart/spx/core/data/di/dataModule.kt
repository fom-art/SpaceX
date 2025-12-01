package com.fomart.spx.core.data.di

import com.fomart.spx.core.data.data.CharactersRepositoryImpl
import com.fomart.spx.core.data.domain.repository.CharactersRepository
import com.fomart.spx.core.database.di.databaseModule
import com.fomart.spx.core.network.di.networkModule
import com.fomart.spx.core.data.util.NetworkMonitor
import com.fomart.spx.core.data.util.NetworkMonitorImpl
import com.fomart.spx.core.data.util.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
        databaseModule
    )
    single<HttpClient> { httpClient }
    single<NetworkMonitor> { NetworkMonitorImpl(client = get()) }
    single<CharactersRepository> { CharactersRepositoryImpl(
        charactersDataSource = get(),
        favoritesDao = get()
    ) }
}