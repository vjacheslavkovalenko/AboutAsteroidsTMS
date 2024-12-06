package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import androidx.recyclerview.widget.RecyclerView


//555
//
//class GroupOfAsteroidsViewHolder(
//    private val binding: ItemAsteroidBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    // Метод для связывания данных с ViewHolder
//    fun bind(asteroid: Asteroid) {
//        // Отображаем имя астероида в TextView
//        binding.textAsteroid.text = asteroid.name
//    }
//}
class GroupOfAsteroidsViewHolder(
    private val binding: ItemAsteroidBinding
) : ViewHolder(binding.root) {

    fun bind(asteroid: Asteroid) {
        // Отображаю имя астероида в TextView
        binding.textAsteroid.text = asteroid.name
    }
}
//}
//        fun bind(asteroid: AsteroidsByDate) {
//        // Предполагаем, что у класса Asteroid есть свойство name
//        binding.textAsteroid.text = asteroid.groupOfAsteroids // Замените на нужное свойство
//    }
//!fun bind(item: AsteroidsByDate) {
//! binding.textAsteroid.text = item.groupOfAsteroids
//        binding.recyclerView.run {
//            if (adapter == null) {
//                adapter = SubBreedAdapter()
//                layoutManager = LinearLayoutManager(binding.root.context)
//            }
//            (adapter as? SubBreedAdapter)?.submitList(item.subBreed)
//        }


//class BreedViewHolder(
//    private val binding: ItemBreedBinding
//) : ViewHolder(binding.root) {
//
//    fun bind(item: Breed) {
//        binding.name.text = item.name
//        binding.recyclerView.run {
//            if (adapter == null) {
//                adapter = SubBreedAdapter()
//                layoutManager = LinearLayoutManager(binding.root.context)
//            }
//            (adapter as? SubBreedAdapter)?.submitList(item.subBreed)
//        }
//    }
//}

//class SubBreedViewHolder(
//    private val binding: ItemSubBreedBinding
//) : ViewHolder(binding.root) {
//
//    fun bind(name: String) {
//        binding.name.text = name
//    }
//}
//