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
import retrofit2.Response

@HiltViewModel
class GroupOfAsteroidsViewModel @Inject constructor(
    private val allAsteroidsRepository: AllAsteroidsRepository
) : ViewModel() {

    val listAsteroidsByDate = MutableLiveData<List<AsteroidsByDate>>()

    fun loadListAsteroidsByDate(selectedDate: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val (startDate, endDate) = DateUtils.getStartAndEndDate()
            val response: Response<NearEarthObjectsResponse> =
                allAsteroidsRepository.getListAsteroidsByDate(selectedDate, selectedDate)

            if (response.isSuccessful) {

                response.body()?.toListAsteroidsByDate()?.let {
                    listAsteroidsByDate.postValue(it)
                }
            }
        }
    }
}