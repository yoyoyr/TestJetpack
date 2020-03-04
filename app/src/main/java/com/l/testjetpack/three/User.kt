package com.l.testjetpack

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User(name: String, age: Int) : BaseObservable() {


    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            //触发ViewDataBinding.requestRebind() --触发>ViewDataBinding.mRebindRunnable运行
            // -->触发ActivityThreeBinding.executeBindings()刷新视图
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var age: Int = 30
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }

    init {
        this.name = name
        this.age = age
    }
}