package by.vjacheslavkovalenko.aboutasteroidstms.utils

import by.vjacheslavkovalenko.aboutasteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.aboutasteroidstms.network.entity.PictureOfDayResponse

// это неправильный файл, т.к. потоки надо засовывать во flow (или репозиторий или Use Case)
//fun PictureOfDayResponse.toPictureOfDay() = PictureOfDay(message)
fun PictureOfDayResponse.toPictureOfDay() = PictureOfDay(url)

//fun ListBreedsResponse.toListBreed(): List<Breed> {
//    val list = arrayListOf<Breed>()
//    this.message.forEach { (name, listSubBread) ->
//        list.add(
//            Breed(
//                name = name,
//                subBreed = listSubBread
//            )
//        )
//    }
//    return list
//}