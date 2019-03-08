package fr.giftoforzhova.common.extentions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.load(@DrawableRes drawableResId: Int) {
    Glide.with(context)
        .load(drawableResId)
        .into(this)
}