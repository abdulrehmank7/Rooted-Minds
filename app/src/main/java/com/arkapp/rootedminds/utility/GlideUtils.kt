package com.arkapp.rootedminds.utility

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

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
            .apply(RequestOptions()
                .fitCenter()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .override(SIZE_ORIGINAL))
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}