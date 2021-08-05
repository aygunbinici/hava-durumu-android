package com.example.havadurumukotlin.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class HavaDurumu (

    @SerializedName("result")
    val result:List<DataResult>,

     @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0


)