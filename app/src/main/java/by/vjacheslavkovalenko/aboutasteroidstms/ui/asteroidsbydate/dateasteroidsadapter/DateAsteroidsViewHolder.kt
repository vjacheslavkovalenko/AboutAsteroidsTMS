package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter

import androidx.recyclerview.widget.LinearLayoutManager
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidsByDateBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DateAsteroidsViewHolder(
    private val binding: ItemAsteroidsByDateBinding
) : ViewHolder(binding.root) {
    fun bind(item: AsteroidsByDate) {
        binding.dateOfGroupAsteroids.text = item.dateOfAsteroids
        binding.recyclerView.run {
            if (adapter == null) {
                adapter = SubBreedAdapter()
                layoutManager = LinearLayoutManager(binding.root.context)
            }
            (adapter as? SubBreedAdapter)?.submitList(item.subBreed)
        }
    }
}
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