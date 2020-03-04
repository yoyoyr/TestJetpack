package com.l.testjetpack.next

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.l.testjetpack.LoggerUtils
import com.l.testjetpack.MyMutableLiveData

class NameViewModel(name: String) : ViewModel() {

    val name: String

    init {
        this.name = name
    }

    // Create a LiveData with a String
    val currentName: MyMutableLiveData<String> by lazy {
        var m = MyMutableLiveData<String>()
        m.setValue(name)
        m
    }


    val transfer: LiveData<String> = Transformations.map(currentName) {
        return@map currentName.value + "123"
    }

    override fun onCleared() {
        super.onCleared()
        LoggerUtils.LOGV("onCleared")
    }

}
    