package by.vjacheslavkovalenko.aboutasteroidstms.network

import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.aboutasteroidstms.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    //потом расскоментировать
//    @GET("neo/rest/v1/feed")
//    suspend fun getAsteroids(
//        @Query("start_date") startDate: String,
//        @Query("end_date") endDate: String,
//        @Query("api_key") apiKey: String = Constants.APIKEY
//    ): Response<NearEarthObjectsResponse>

//    @GET("planetary/apod?api_key=gM0Ze05VWVs9uAcahDClWEvapDNv7m5MNiuO3TLl")
    @GET("planetary/apod")
//    @GET("breeds/image/random")
//    suspend fun fetchPictureOfDay(): Response<PictureOfDayResponse>
    suspend fun fetchPictureOfDay(
        @Query("api_key") apiKey: String = Constants.APIKEY
    ): Response<PictureOfDayResponse>
}

//interface Api {
//
//    @GET("breeds/image/random")
//    suspend fun fetchRandomDogImage(): Response<DogImageResponse>
//
//    @GET("breeds/list/all")
//    suspend fun fetchListDogBreeds(): Response<ListBreedsResponse>
//
//    @GET("breed/{breed}/images/random")
//    suspend fun fetchRandomBreedImage(
//        @Path("breed") breedName: String
//    ): Response<DogImageResponse>
//}