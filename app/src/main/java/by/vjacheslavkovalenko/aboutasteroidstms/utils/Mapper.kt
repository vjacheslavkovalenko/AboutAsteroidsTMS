package by.vjacheslavkovalenko.aboutasteroidstms.utils

import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.NearEarthObjectsResponse
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.PictureOfDayResponse

fun PictureOfDayResponse.toPictureOfDay() = PictureOfDay(url)

fun NearEarthObjectsResponse.toListAsteroidsByDate(): List<AsteroidsByDate> {
    val list = arrayListOf<AsteroidsByDate>()
    this.nearEarthObjects.forEach { (dateOfAsteroids, listGroupOfAsteroids) ->
        list.add(
            AsteroidsByDate(
                dateOfAsteroids = dateOfAsteroids,
                groupOfAsteroids = listGroupOfAsteroids
            )
        )
    }
    return list
}

fun AsteroidResponse.toAsteroid() = Asteroid(
    id,
    name,
    absoluteMagnitude,
    estimatedDiameter,
    relativeVelocity,
    distanceFromEarth,
    isPotentiallyHazardous
)