package com.l.testjetpack.dagger

import com.l.testjetpack.LoggerUtils
import javax.inject.Inject

class Presenter @Inject constructor() {

    @Inject
    lateinit var webService: WebService

    init {
        LoggerUtils.LOGV("init presenter")
    }
}