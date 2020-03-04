package com.l.testjetpack.next

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.ViewModelProviders
import com.l.testjetpack.BaseApplication
import com.l.testjetpack.LoggerUtils
import com.l.testjetpack.MainActivity
import com.l.testjetpack.R
import com.l.testjetpack.dagger.DaggerMainComponent
import com.l.testjetpack.dagger.Db
import com.l.testjetpack.dagger.Presenter
import com.l.testjetpack.databinding.ActivityNextBinding
import kotlinx.android.synthetic.main.activity_next.*
import java.lang.reflect.Constructor
import javax.inject.Inject
import kotlin.random.Random

class NextActivity : AppCompatActivity() {

    private lateinit var model: NameViewModel
    var i: Int = 0

    @Inject
    lateinit var present: Presenter

    @Inject
    lateinit var db: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var component = DaggerMainComponent.builder()
            .appScopeComponent((application as BaseApplication).baseComponent).build()
        LoggerUtils.LOGV("component = " + component.toString())
        component.inject(this)
        var binding =
            DataBindingUtil.setContentView<ActivityNextBinding>(this, R.layout.activity_next)

        // 先检查对应Acitivy/fragment的viewmodelstore是否有存储viewmodule，有则返回
        // 否则，如果有factory，则调用用factory初始化。如果没有，系统调用无参构造函数初始化
        model = ViewModelProviders.of(this, object : Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                try {
                    LoggerUtils.LOGV("instance NameViewModel")
                    val c = modelClass.getConstructor(String::class.java)
                    return c.newInstance("NextActivity")
                } catch (e: InstantiationException) {
                    throw RuntimeException("Cannot create an instance of $modelClass", e)
                } catch (e: IllegalAccessException) {
                    throw RuntimeException("Cannot create an instance of $modelClass", e)
                }

            }
        }).get(NameViewModel::class.java)

        binding.viewModule = model
        binding.lifecycleOwner = this
//        model.currentName.observe(this, Observer<String> { newName ->
//            // Update the UI, in this case, a TextView.
//            tv.text = newName
//        })

        button.setOnClickListener {
            val anotherName = "NextActivity-" + i++
            model.currentName.setValue(anotherName)
        }


        next.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}