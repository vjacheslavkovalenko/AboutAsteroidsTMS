package by.vjacheslavkovalenko.aboutasteroidstms.utils

import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.NearEarthObjectsResponse
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.PictureOfDayResponse

// это неправильный файл, т.к. потоки надо засовывать во flow (или репозиторий или Use Case)
//fun PictureOfDayResponse.toPictureOfDay() = PictureOfDay(message)
fun PictureOfDayResponse.toPictureOfDay() = PictureOfDay(url)

//тут преобразую HashMap в List, чтобы система могла дальше работать с данными:
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
    closeApproachDate,
    absoluteMagnitude,
    estimatedDiameter,
    relativeVelocity,
    distanceFromEarth,
    isPotentiallyHazardous
)


//fun ListBreedsResponse.toListBreed(): List<Breed> {
//    val list = arrayListOf<Breed>()
//    this.message.forEach { (name, listSubBread) ->
//        list.add(
//            Breed(
//                name = name,
//                subBreed = listSubBread
//            )
//        )
//    }
//    return list
//}