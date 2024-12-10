package by.vjacheslavkovalenko.aboutasteroidstms.network

import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.NearEarthObjectsResponse
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.aboutasteroidstms.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("planetary/apod")
    suspend fun fetchPictureOfDay(
        @Query("api_key") apiKey: String = Constants.APIKEY
    ): Response<PictureOfDayResponse>

    @GET("neo/rest/v1/feed")
    suspend fun fetchAsteroidsByDate(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = Constants.APIKEY
    ): Response<NearEarthObjectsResponse>

    @GET("neo/rest/v1/neo/{id}")
    suspend fun fetchAsteroid(
        @Path("id") id: String,
        @Query("api_key") apiKey: String = Constants.APIKEY
    ): Response<AsteroidResponse>
}