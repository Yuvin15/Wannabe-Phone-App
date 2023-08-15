package com.example.newsweatherexchangeapp.Models.WeatherModel

import com.google.gson.annotations.SerializedName

data class Day (

    @SerializedName("Icon"             ) var Icon             : Int?     = null,
    @SerializedName("IconPhrase"       ) var IconPhrase       : String?  = null,
    @SerializedName("HasPrecipitation" ) var HasPrecipitation : Boolean? = null

)
