package com.l.testjetpack.dagger

import com.l.testjetpack.LoggerUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MainModule {

    @ModuleScope
    @Provides
    fun getWebService(): WebService {
        LoggerUtils.LOGV("new service")
        return WebService()
    }
}