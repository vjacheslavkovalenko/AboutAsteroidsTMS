package by.vjacheslavkovalenko.aboutasteroidstms.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}