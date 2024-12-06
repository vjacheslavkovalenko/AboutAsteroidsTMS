package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid

import androidx.lifecycle.MutableLiveData
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.NearEarthObjectsResponse
import by.vjacheslavkovalenko.aboutasteroidstms.utils.DateUtils
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toListAsteroidsByDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toListAsteroidsByDate
import retrofit2.Response

//***
//@HiltViewModel
//class GroupOfAsteroidsViewModel @Inject constructor(
//    private val allAsteroidsRepository: AllAsteroidsRepository
//) : ViewModel() {
//
//    val listAsteroidsByDate = MutableLiveData<List<AsteroidsByDate>>()
//
//    fun loadListAsteroidsByDate() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                // Получаем список астероидов из репозитория
//                val response: Response<List<AsteroidsByDate>> = allAsteroidsRepository.getListAsteroidsByDate()
//
//                // Проверяем успешность ответа и обрабатываем данные
//                if (response.isSuccessful) {
//                    response.body()?.toListAsteroidsByDate()?.let { asteroidsList ->
//                        listAsteroidsByDate.postValue(asteroidsList)
//                    } ?: run {
//                        // Обработка случая, когда тело ответа null
//                        listAsteroidsByDate.postValue(emptyList())
//                    }
//                } else {
//                    // Обработка ошибки (например, логирование)
//                    // Можно использовать LiveData для передачи ошибки в UI, если это необходимо
//                    listAsteroidsByDate.postValue(emptyList()) // Или другое поведение при ошибке
//                }
//            } catch (e: Exception) {
//                // Обработка исключений (например, сетевые ошибки)
//                e.printStackTrace() // Логирование ошибки
//                listAsteroidsByDate.postValue(emptyList()) // Или другое поведение при ошибке
//            }
//        }
//    }
//}

@HiltViewModel
class GroupOfAsteroidsViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {

    val listAsteroidsByDate = MutableLiveData<List<AsteroidsByDate>>()

    fun loadListAsteroidsByDate() {
        viewModelScope.launch(Dispatchers.IO) {

            // Получаю стартовую и конечную даты из утилиты
            val (startDate, endDate) = DateUtils.getStartAndEndDate()
// Получаю ответ от репозитория с использованием стартовой и конечной дат
            val response: Response<NearEarthObjectsResponse> =
                allAsteroidsRepository.getListAsteroidsByDate(startDate, endDate)

            if (response.isSuccessful) {

                response.body()?.toListAsteroidsByDate()?.let {
                    listAsteroidsByDate.postValue(it)
                }

            }
        }
    }
}
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