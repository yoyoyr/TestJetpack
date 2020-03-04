package com.l.testjetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyMutableLiveData<T> : LiveData<T>() {

    override fun onActive() {
        super.onActive()
        LoggerUtils.LOGV("onActive")
    }

    override fun onInactive() {
        super.onInactive()
        LoggerUtils.LOGV("onInactive")
    }
    public override fun postValue(value: T) {
        super.postValue(value)
    }

    public override fun setValue(value: T) {
        super.setValue(value)
    }
}