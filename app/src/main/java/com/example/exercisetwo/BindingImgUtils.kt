package com.example.exercisetwo

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage( imageView : ImageView, imgUrl: String?){

    if (imgUrl!=null){
        Glide.with(imageView).load(imgUrl).error(R.drawable.newsimgicon).placeholder(R.drawable.newsimgicon).into(imageView)
        //https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg
    }else{
        imageView.setImageResource(R.drawable.newsimgicon)
    }
}