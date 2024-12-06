package by.vjacheslavkovalenko.aboutasteroidstms.ui.detailsasteroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import by.vjacheslavkovalenko.aboutasteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toAsteroid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//***с обработкой ошибок:
//@HiltViewModel
//class DetailsAsteroidViewModel @Inject constructor(
//    private val allAsteroidsRepository: AllAsteroidsRepository
//) : ViewModel() {
//
//    private val _asteroid = MutableLiveData<Asteroid>()
//    val asteroid: LiveData<Asteroid> get() = _asteroid
//
//    private val _error = MutableLiveData<String>()
//    val error: LiveData<String> get() = _error
//
//    fun loadAsteroidById(id: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                // Получаем астероид по ID из репозитория
//                val response = allAsteroidsRepository.getListAsteroid(id)
//                if (response.isSuccessful) {
//                    response.body()?.toAsteroid()?.let {
//                        _asteroid.postValue(it)
//                    } ?: run {
//                        _error.postValue("Ошибка: Астероид не найден")
//                    }
//                } else {
//                    _error.postValue("Ошибка: ${response.message()}")
//                }
//            } catch (e: Exception) {
//                _error.postValue("Ошибка: ${e.message}")
//            }
//        }
//    }
//}

@HiltViewModel
class DetailsAsteroidViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {
    //    private val asteroidLiveData = MutableLiveData<Asteroid>()
//    val asteroid: LiveData<Asteroid> get() = asteroidLiveData
//    val picture = MutableLiveData<PictureOfDay>()
    val asteroid = MutableLiveData<Asteroid>()

    fun loadAsteroidById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            // Получаем астероид по ID из репозитория
            val response = allAsteroidsRepository.getListAsteroid(id)
            if (response.isSuccessful) {
                response.body()?.toAsteroid()?.let {
                    asteroid.postValue(it)
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