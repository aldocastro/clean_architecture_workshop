package com.grappfruit.cleanworkshoppart1

import android.app.Application
import com.grappfruit.cleanworkshoppart1.feature.product.detail.productDetailModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import timber.log.Timber

class CleanApp : Application() {

    private val appModule = module {
        single { Application() }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin(this, listOf(appModule, productDetailModule))
    }
}
