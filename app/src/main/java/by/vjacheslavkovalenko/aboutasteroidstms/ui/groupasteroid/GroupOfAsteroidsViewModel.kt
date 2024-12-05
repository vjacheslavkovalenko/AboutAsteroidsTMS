package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid

import by.vjacheslavkovalenko.aboutasteroidstms.repository.AllAsteroidsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel

@HiltViewModel
class GroupOfAsteroidsViewModel @Inject constructor(
    private val allAsteroidsRepository : AllAsteroidsRepository
) : ViewModel() {

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