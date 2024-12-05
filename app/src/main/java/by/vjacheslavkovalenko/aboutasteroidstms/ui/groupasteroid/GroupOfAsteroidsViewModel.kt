package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid

import androidx.lifecycle.MutableLiveData
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toListAsteroidsByDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//
//class GroupOfAsteroidsViewModel @Inject constructor(
//    private val repository: AllAsteroidsRepository
//) : ViewModel() {
//
//    private val groupsOfAsteroidsMutable = MutableLiveData<List<String>>()
//    val groupsOfAsteroids: LiveData<List<String>> get() = groupsOfAsteroidsMutable
//
//    init {
//        loadGroupsOfAsteroids()
//    }
//
//    private fun loadGroupsOfAsteroids() {
//        viewModelScope.launch {
//            try {
//                // Здесь вы можете указать нужные параметры для получения групп астероидов.
//                // Например, можно получить данные по определенной дате или другим критериям.
//
//                // Загружаем данные из репозитория (предположим, что метод возвращает список строк)
//                val groups = repository.getListAsteroid() // Замените на нужный метод репозитория
//                groupsOfAsteroidsMutable.value = groups // Обновляем LiveData
//            } catch (e: Exception) {
//                // Обработка ошибок (например, логирование или уведомление пользователя)
//                e.printStackTrace()
//            }
//        }
//    }
//}
@HiltViewModel
class GroupOfAsteroidsViewModel @Inject constructor(
    private val allAsteroidsRepository : AllAsteroidsRepository
) : ViewModel() {

    val listAsteroidsByDate= MutableLiveData<List<AsteroidsByDate>>()

        fun loadListAsteroidsByDate() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = allAsteroidsRepository.getListAsteroidsByDate()
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