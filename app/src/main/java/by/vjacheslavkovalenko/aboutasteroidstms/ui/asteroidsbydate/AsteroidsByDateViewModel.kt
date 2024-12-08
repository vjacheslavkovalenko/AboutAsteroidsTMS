package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.LiveData
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.NearEarthObjectsResponse
import retrofit2.Response
import by.vjacheslavkovalenko.aboutasteroidstms.utils.DateUtils

@HiltViewModel
class AsteroidsByDateViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {

    private val listAsteroidsByDateMutable = MutableLiveData<List<String>>()
    val listAsteroidsByDate: LiveData<List<String>> get() = listAsteroidsByDateMutable

    fun loadListAsteroidsByDate() {
        viewModelScope.launch(Dispatchers.IO) {
            val (startDate, endDate) = DateUtils.getStartAndEndDate()
            val response: Response<NearEarthObjectsResponse> =
                allAsteroidsRepository.getListAsteroidsByDate(startDate, endDate)

            if (response.isSuccessful) {
                response.body()?.let { nearEarthObjectsResponse ->
                    Log.d(
                        "AsteroidsByDateViewModel",
                        "Received response: $nearEarthObjectsResponse"
                    )

                    val nearEarthObjects = nearEarthObjectsResponse.nearEarthObjects
                    if (nearEarthObjects != null && nearEarthObjects.isNotEmpty()) {
                        val datesList = nearEarthObjects.keys.toList()
                        Log.d("AsteroidsByDateViewModel", "Dates list: $datesList")
                        listAsteroidsByDateMutable.postValue(datesList)
                    } else {
                        Log.e(
                            "AsteroidsByDateViewModel",
                            "No near Earth objects found or nearEarthObjects is null."
                        )
                        listAsteroidsByDateMutable.postValue(emptyList())
                    }
                } ?: run {
                    Log.e("AsteroidsByDateViewModel", "Response body is null")
                    listAsteroidsByDateMutable.postValue(emptyList())
                }
            } else {
                Log.e("AsteroidsByDateViewModel", "Error fetching data: ${response.message()}")
            }
        }
    }
}