package by.vjacheslavkovalenko.aboutasteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class PictureOfDayResponse(

//    val title: String,
    @SerializedName("url")
    val url: String
//    val message: String
)
