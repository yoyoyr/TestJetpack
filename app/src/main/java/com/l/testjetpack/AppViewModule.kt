package com.l.testjetpack

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class AppViewModule private constructor(app: Application) : AndroidViewModel(app) {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val transfer: LiveData<String> = Transformations.map(currentName) {
        return@map currentName.value + "123"
    }

    companion object {
        @Volatile
        var appViewModule: AppViewModule? = null

        fun get(app: Application): AppViewModule {
            if (appViewModule == null)
                synchronized(AppViewModule::class) {
                    if (appViewModule == null)
                        appViewModule = AppViewModule(app)
                }
            return appViewModule!!
        }
    }

}