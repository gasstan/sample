package com.sample.dataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class FragmentBindingAdapters() {
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}