package by.vjacheslavkovalenko.aboutasteroidstms.network

import by.vjacheslavkovalenko.aboutasteroidstms.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }
}