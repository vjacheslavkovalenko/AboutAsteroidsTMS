package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate

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

//ИИ написал:
//@HiltViewModel
//class AsteroidsByDateViewModel @Inject constructor(
//    private val allAsteroidsRepository: AllAsteroidsRepository
//) : ViewModel() {
//
//    private val listAsteroidsByDateMutable = MutableLiveData<List<String>>() // Список строк для отображения дат
//    val listAsteroidsByDate: LiveData<List<String>> get() = listAsteroidsByDateMutable
//
//    fun loadListAsteroidsByDate() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                // Получаем ответ от репозитория
//                val response: Response<NearEarthObjectsResponse> = allAsteroidsRepository.getListAsteroidsByDate()
//                if (response.isSuccessful) {
//                    // Проверяем, что тело ответа не null и извлекаем данные
//                    response.body()?.let { nearEarthObjectsResponse ->
//                        // Извлекаем ключи (даты) из HashMap и создаем список строк
//                        val datesList = nearEarthObjectsResponse.nearEarthObjects.keys.toList()
//                        listAsteroidsByDateMutable.postValue(datesList) // Обновляем LiveData
//                    }
//                } else {
//                    // Обработка ошибки (например, логирование)
//                }
//            } catch (e: Exception) {
//                // Обработка исключений (например, логирование)
//                e.printStackTrace()
//            }
//        }
//    }
//}
@HiltViewModel
class AsteroidsByDateViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {

    // Список строк для отображения дат
    private val listAsteroidsByDateMutable = MutableLiveData<List<String>>()
    val listAsteroidsByDate: LiveData<List<String>> get() = listAsteroidsByDateMutable

    fun loadListAsteroidsByDate() {
        viewModelScope.launch(Dispatchers.IO) {
//            val response = allAsteroidsRepository.getListAsteroidsByDate()
            val response: Response<NearEarthObjectsResponse> =
                allAsteroidsRepository.getListAsteroidsByDate()
            if (response.isSuccessful) {
                response.body()?.let { nearEarthObjectsResponse ->
                    // Извлекаю ключи (даты) из HashMap и создаю список строк
                    val datesList = nearEarthObjectsResponse.nearEarthObjects.keys.toList()
                    listAsteroidsByDateMutable.postValue(datesList)
                }
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