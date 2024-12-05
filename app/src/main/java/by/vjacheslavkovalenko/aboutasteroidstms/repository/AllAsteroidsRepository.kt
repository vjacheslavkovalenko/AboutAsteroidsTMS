package by.vjacheslavkovalenko.aboutasteroidstms.repository

import by.vjacheslavkovalenko.aboutasteroidstms.network.Api
import by.vjacheslavkovalenko.aboutasteroidstms.utils.Constants.APIKEY
import javax.inject.Inject

//class DogRepository @Inject constructor(
//    private val api: Api
//) {
//
//    suspend fun getRandomDogImage() = api.fetchRandomDogImage()
//
//    suspend fun getListBreads() = api.fetchListDogBreeds()
//
//    suspend fun getRandomBreedImage(breed: String) = api.fetchRandomBreedImage(breed)
//}

class AllAsteroidsRepository @Inject constructor(
    private val api: Api
) {

    suspend fun getPictureOfDay() = api.fetchPictureOfDay()

    suspend fun getListAsteroidsByDate(startDate: String, endDate: String) =
        api.fetchAsteroidsByDate(startDate, endDate, APIKEY)

  //!!!  suspend fun getListAsteroid() = api.fetchAsteroid()


//    suspend fun getAsteroids(startDate: String, endDate: String): List<Asteroid> {
//        val response = apiService.getAsteroids(startDate, endDate)
//        return parseAsteroidsResponse(response)
//    }
}
