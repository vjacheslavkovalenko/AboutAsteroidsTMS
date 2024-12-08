package by.vjacheslavkovalenko.aboutasteroidstms.ui.detailsasteroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toAsteroid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsAsteroidViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {

    val asteroid = MutableLiveData<Asteroid>()

    fun loadAsteroidById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val response =
                allAsteroidsRepository.getListAsteroid(id.toString())
            if (response.isSuccessful) {
                response.body()?.toAsteroid()?.let {
                    asteroid.postValue(it)
                }
            }
        }
    }
}