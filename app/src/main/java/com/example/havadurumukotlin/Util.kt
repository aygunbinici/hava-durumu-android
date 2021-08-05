package com.example.havadurumukotlin

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.downloadFromUrl(url:String?, progressDrawable: CircularProgressDrawable){
    val options= RequestOptions()
        .placeholder(progressDrawable) //görsel indirilene kadar ne göstericez
        .error(R.mipmap.ic_launcher_round) //hata olursa ne gösterelim
    Glide
        .with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}

fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}