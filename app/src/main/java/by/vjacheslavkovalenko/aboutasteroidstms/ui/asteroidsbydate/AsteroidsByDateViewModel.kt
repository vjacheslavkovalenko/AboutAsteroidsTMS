package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toListAsteroidsByDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.LiveData
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.NearEarthObjectsResponse
import retrofit2.Response
import by.vjacheslavkovalenko.aboutasteroidstms.utils.DateUtils

//ИИ написал:

@HiltViewModel
class AsteroidsByDateViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {

    // Список строк для отображения дат
    private val listAsteroidsByDateMutable = MutableLiveData<List<String>>()
    val listAsteroidsByDate: LiveData<List<String>> get() = listAsteroidsByDateMutable

    fun loadListAsteroidsByDate() {
        viewModelScope.launch(Dispatchers.IO) {
            // Получаю стартовую и конечную даты из утилиты
            val (startDate, endDate) = DateUtils.getStartAndEndDate()

            // Получаю ответ от репозитория с использованием стартовой и конечной дат
//            val response = allAsteroidsRepository.getListAsteroidsByDate()
            val response: Response<NearEarthObjectsResponse> =
                allAsteroidsRepository.getListAsteroidsByDate(startDate, endDate)

            if (response.isSuccessful) {
                response.body()?.let { nearEarthObjectsResponse ->
                    Log.d(
                        "AsteroidsByDateViewModel",
                        "Received response: $nearEarthObjectsResponse"
                    )

                    // Проверяем на null перед доступом к ключам
                    val nearEarthObjects = nearEarthObjectsResponse.nearEarthObjects
                    if (nearEarthObjects != null && nearEarthObjects.isNotEmpty()) {
                        val datesList = nearEarthObjects.keys.toList() // Извлекаем все даты
                        Log.d("AsteroidsByDateViewModel", "Dates list: $datesList")
                        listAsteroidsByDateMutable.postValue(datesList) // Обновляем LiveData со всеми датами
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


//@HiltViewModel
//class AsteroidsByDateViewModel @Inject constructor(
//    private val allAsteroidsRepository: AllAsteroidsRepository
//) : ViewModel() {
//    //может так?
//   val listAsteroidsByDate = MutableLiveData<List<String>>()
////    val listAsteroidsByDate = MutableLiveData<List<AsteroidsByDate>>()
//
//    fun loadListAsteroidsByDate() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = allAsteroidsRepository.getListAsteroidsByDate()
//            if (response.isSuccessful) {
//                response.body()?.toListAsteroidsByDate()?.let {
//                    listAsteroidsByDate.postValue(it)
//                }
//            }
//        }
//    }
//}

//
//@HiltViewModel
//class BreedListViewModel @Inject constructor(
//    private val dogRepository: DogRepository
//) : ViewModel() {
//
//    val listBreed = MutableLiveData<List<Breed>>()
//
//    val image = MutableLiveData<String>()
//
//    fun loadListBreed() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = dogRepository.getListBreads()
//            if (response.isSuccessful) {
//                response.body()?.toListBreed()?.let {
//                    listBreed.postValue(it)
//                }
//            }
//        }
//    }
//
//    fun loadBreedImage(breed: String) {
//        viewModelScope.launch {
//            val response = dogRepository.getRandomBreedImage(breed)
//            if (response.isSuccessful) {
//                response.body()?.message?.let {
//                    image.postValue(it)
//                }
//            }
//        }
//    }
//}