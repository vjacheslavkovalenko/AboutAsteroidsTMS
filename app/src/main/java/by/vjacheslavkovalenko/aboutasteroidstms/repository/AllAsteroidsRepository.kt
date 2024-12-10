package by.vjacheslavkovalenko.aboutasteroidstms.repository

import by.vjacheslavkovalenko.aboutasteroidstms.network.Api
import by.vjacheslavkovalenko.aboutasteroidstms.utils.Constants.APIKEY
import javax.inject.Inject

class AllAsteroidsRepository @Inject constructor(
    private val api: Api
) {

    suspend fun getPictureOfDay() = api.fetchPictureOfDay()

    suspend fun getListAsteroidsByDate(startDate: String, endDate: String) =
        api.fetchAsteroidsByDate(startDate, endDate, APIKEY)

    suspend fun getListAsteroid(id: String) = api.fetchAsteroid(id)

}