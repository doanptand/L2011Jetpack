package com.ddona.l2011jetpack.extension

import android.os.Build
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ddona.l2011jetpack.R


@BindingAdapter("src_link")
fun bindImageWithLink(img: ImageView, link: String?) {
    link?.let {
        Glide.with(img)
            .load(link)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(img)
    }
}


@BindingAdapter("text_html")
@RequiresApi(Build.VERSION_CODES.N)
fun setHtmlText(tv: TextView, content: String) {
    tv.text = Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT)
}

