package by.vjacheslavkovalenko.aboutasteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//import androidx.room.PrimaryKey

data class AsteroidResponse(
    // @PrimaryKey
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitude: Double,
    @SerializedName("estimated_diameter_max")
    val estimatedDiameter: Double,
    @SerializedName("kilometers_per_second")
    val relativeVelocity: Double,
    @SerializedName("astronomical")
    val distanceFromEarth: Double,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardous: Boolean
)// : Parcelable