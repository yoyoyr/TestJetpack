package com.l.testjetpack.dagger

import com.l.testjetpack.MainActivity
import com.l.testjetpack.next.NextActivity
import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton

@ModuleScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppScopeComponent::class))
interface MainComponent {

    fun inject(a: MainActivity)

    fun inject(a: NextActivity)
}