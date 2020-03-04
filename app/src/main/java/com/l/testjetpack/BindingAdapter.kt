package com.l.testjetpack

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import org.w3c.dom.Text


@BindingAdapter("app:imageUrl")
fun setImageUrl(view: View, url: String?) {
    LoggerUtils.LOGV("setImageUrl")
    url?.run {
        LoggerUtils.LOGV("url = ${url}")
    }
}

@BindingConversion
fun convertColorToDrawable(color: Int): ColorDrawable {
    LoggerUtils.LOGV("convertColorToDrawable ${color}")
    return ColorDrawable(Color.WHITE)
}