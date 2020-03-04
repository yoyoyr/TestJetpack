package com.l.testjetpack

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.l.testjetpack.databinding.ActivityThreeBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_three.*

class ThreeActivity : AppCompatActivity() {

    lateinit var user: User
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取相应的databinding对像
        // 初始化databinding的时候会插入一个任务，该任务会调用executeBindings，构建视图和user的映射
        var binding =
            DataBindingUtil.setContentView<ActivityThreeBinding>(this, R.layout.activity_three)
        user = User("yoyo", 30)
        handler = Handler()

        binding.user = user

        change.setOnClickListener {
            Thread {
                LoggerUtils.LOGV("start task")
                Thread.sleep(1000 * 5)
                handler.post {
                    //并不会导致异常，在activity关闭的时候mRebindRunnable会提前退出
                    user.name = "yoyoqwe"
                    LoggerUtils.LOGV("end task ${user.name}")
                }
            }.start()
        }

    }

}