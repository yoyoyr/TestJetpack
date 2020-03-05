package com.l.testjetpack

import android.app.Application

import com.l.testjetpack.dagger.AppScopeComponent
import com.l.testjetpack.dagger.AppScopeModule
import com.l.testjetpack.dagger.DaggerAppScopeComponent
import com.l.testjetpack.dagger.Db

class BaseApplication : Application() {
    lateinit var baseComponent: AppScopeComponent

//    override fun onCreate() {
//        super.onCreate()
//        baseComponent = DaggerAppScopeComponent.create()
//    }


    override fun onCreate() {
        super.onCreate()
        baseComponent = DaggerAppScopeComponent.create()
    }
}