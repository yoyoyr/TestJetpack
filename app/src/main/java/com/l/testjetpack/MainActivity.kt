package com.l.testjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.l.testjetpack.dagger.*
import com.l.testjetpack.databinding.ActivityMainBinding
import com.l.testjetpack.next.NameViewModel
import com.l.testjetpack.next.NextActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var model: NameViewModel
//    private lateinit var appModel: AppViewModule

    @Inject
    lateinit var present: Presenter

    @Inject
    lateinit var db: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var component = (application as BaseApplication).baseComponent.getMainComponent().inject(this)
//        LoggerUtils.LOGV("component = "+component.toString())
//        component.inject(this)
        // Get the ViewModel.
        model = ViewModelProviders.of(this
            , object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    try {
                        LoggerUtils.LOGV("instance")
                        var c = modelClass.getConstructor(String::class.java)
                        return c.newInstance("MainActivity")
                    } catch (e: InstantiationException) {
                        throw RuntimeException("Cannot create an instance of $modelClass", e)
                    } catch (e: IllegalAccessException) {
                        throw RuntimeException("Cannot create an instance of $modelClass", e)
                    }

                }
            }).get(NameViewModel::class.java)

        var binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModule = model
//        binding.lifecycleOwner = this

//        appModel = AppViewModule.get(application)

        binding.activity = this
        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            tv.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)

//        button.setOnClickListener {
//            val anotherName = "MainActivity"
//            model.currentName.setValue(anotherName)
//        }

        next.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }

        three.setOnClickListener {
            startActivity(Intent(this, ThreeActivity::class.java))
        }


    }

    fun onChangeClick(s: String, i: Int) {
        val anotherName = "MainActivity"
        model.currentName.setValue(anotherName)
    }

    fun onClickFriend(view: View) {
        val anotherName = "MainActivity"
        model.currentName.setValue(anotherName)
    }


}
