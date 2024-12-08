package by.vjacheslavkovalenko.aboutasteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class PictureOfDayResponse(

    @SerializedName("url")
    val url: String
)
