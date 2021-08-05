package com.example.havadurumukotlin.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class DataResult (
    @SerializedName("date")
    val date : String,
    @SerializedName("day")
    val day : String,
    @SerializedName("icon")
    val icon : String,
    @SerializedName("description")
    val description: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("degree")
    val degree: String,
    @SerializedName("min")
    val min: Float,
    @SerializedName("max")
    val max: String,
    @SerializedName("night")
    val night: Float,
    @SerializedName("humidity")
    val humidity: String,

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

)
