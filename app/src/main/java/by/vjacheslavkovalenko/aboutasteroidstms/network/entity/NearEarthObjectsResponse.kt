package by.vjacheslavkovalenko.aboutasteroidstms.network.entity

import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid

data class NearEarthObjectsResponse(
    val nearEarthObjects: HashMap<String, List<Asteroid>>
)
