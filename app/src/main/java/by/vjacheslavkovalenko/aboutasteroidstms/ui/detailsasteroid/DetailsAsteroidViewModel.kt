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

//***
//

@HiltViewModel
class DetailsAsteroidViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {
    //    private val asteroidLiveData = MutableLiveData<Asteroid>()
//    val asteroid: LiveData<Asteroid> get() = asteroidLiveData
//    val picture = MutableLiveData<PictureOfDay>()
    val asteroid = MutableLiveData<Asteroid>()

    fun loadAsteroidById(id: Long) { // Изменил тип id на Long
        viewModelScope.launch(Dispatchers.IO) {
            // Получаем астероид по ID из репозитория, преобразуем Long в String для запроса.
            val response =
                allAsteroidsRepository.getListAsteroid(id.toString())// Преобразуем Long в String для запроса
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