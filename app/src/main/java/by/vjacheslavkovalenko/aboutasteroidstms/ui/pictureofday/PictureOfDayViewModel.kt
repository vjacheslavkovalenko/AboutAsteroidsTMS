package by.vjacheslavkovalenko.aboutasteroidstms.ui.pictureofday

import android.annotation.SuppressLint
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.aboutasteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import by.vjacheslavkovalenko.aboutasteroidstms.utils.toPictureOfDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler

private const val LOG_TAG = "thisPictureOfDayViewModel"

@HiltViewModel
class PictureOfDayViewModel @Inject constructor(
    private val repository: AllAsteroidsRepository
) : ViewModel() {

    val picture = MutableLiveData<PictureOfDay>()

    var showError: ((throwable: Throwable) -> Unit)? = null

    @SuppressLint("RestrictedApi")
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            showError?.invoke(throwable)
            Log.e(LOG_TAG, throwable.localizedMessage)
//            Log.e("ThisPictureOfDayViewModel", throwable.localizedMessage)
        }

    fun loadPictureOfDay() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val response: Response<PictureOfDayResponse> = repository.getPictureOfDay()
            if (response.isSuccessful) {
                response.body()?.let { pictureOfDayResponse ->
                    picture.postValue(pictureOfDayResponse.toPictureOfDay())
                }
            } else {
                response.errorBody()
                response.code()
            }
        }
    }
}
