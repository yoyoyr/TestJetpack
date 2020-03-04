package com.l.testjetpack.dagger

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppScopeModule {

    @Singleton
    @Provides
    fun getDb(): Db {
        return Db()
    }
}