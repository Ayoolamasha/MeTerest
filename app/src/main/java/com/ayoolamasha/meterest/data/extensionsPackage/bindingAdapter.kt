package com.ayoolamasha.meterest.data.extensionsPackage

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ayoolamasha.meterest.R
import com.bumptech.glide.Glide

//@BindingAdapter("app:loadImageFromUrl")
//fun loadingImageFromUrl(imageView: ImageView, imageUrl:String?) {
//    Glide.with(imageView.context)
//        .load(imageUrl)
//        .placeholder(R.drawable.ic_launcher_foreground)
//        .centerCrop()
//        .into(imageView)
//}

@BindingAdapter("app:loadImageFromUrl")
fun loadRemoteImage(imageView: ImageView, imageUrl:String){
    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_launcher_foreground)
        .centerCrop()
        .into(imageView)

}