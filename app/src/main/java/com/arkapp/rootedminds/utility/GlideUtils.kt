package com.arkapp.rootedminds.utility

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Abdul Rehman on 29-03-2020.
 * Contact email - abdulrehman0796@gmail.com
 */


fun ImageView.loadImage(url: String?) {
    try {
        Glide.with(this.context)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun ImageView.loadImage(bitmap: Bitmap?) {
    try {
        Glide.with(this.context)
            .load(bitmap)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun ImageView.loadImage(resId: Int) {
    try {
        Glide.with(this.context)
            .load(resId)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}