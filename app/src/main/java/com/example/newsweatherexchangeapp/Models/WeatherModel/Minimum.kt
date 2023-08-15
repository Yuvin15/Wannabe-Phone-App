package com.example.newsweatherexchangeapp.Models.WeatherModel

import com.google.gson.annotations.SerializedName

data class Minimum (

    @SerializedName("Value"    ) var Value    : Int?    = null,
    @SerializedName("Unit"     ) var Unit     : String? = null,
    @SerializedName("UnitType" ) var UnitType : Int?    = null

)