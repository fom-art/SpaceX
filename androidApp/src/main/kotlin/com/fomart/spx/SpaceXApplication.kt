package com.fomart.spx

import android.app.Application
import com.fomart.spx.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.DEBUG

class SpaceXApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            initKoin(applicationContext)
            androidContext(this@SpaceXApplication)
            androidLogger(DEBUG)
            modules(appModule)
            printLogger()
        }
    }
}