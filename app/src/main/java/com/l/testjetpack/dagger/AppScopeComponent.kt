package com.l.testjetpack.dagger

import dagger.Component
import javax.inject.Singleton

//@Singleton
//@Component(modules = arrayOf(AppScopeModule::class))
//interface AppScopeComponent {
//
//    fun getDb(): Db
//}


@Singleton
@Component(modules = arrayOf(AppScopeModule::class))
interface AppScopeComponent {

    fun getMainComponent(): MainComponent
}