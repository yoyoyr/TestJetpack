package com.l.testjetpack.dagger

import java.lang.annotation.RetentionPolicy
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
