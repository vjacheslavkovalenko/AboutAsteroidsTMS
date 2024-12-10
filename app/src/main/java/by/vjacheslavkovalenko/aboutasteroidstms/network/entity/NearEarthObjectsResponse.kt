package by.vjacheslavkovalenko.aboutasteroidstms.network.entity

import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import com.google.gson.annotations.SerializedName

data class NearEarthObjectsResponse(
    @SerializedName("near_earth_objects")
    val nearEarthObjects: HashMap<String, List<Asteroid>>
)