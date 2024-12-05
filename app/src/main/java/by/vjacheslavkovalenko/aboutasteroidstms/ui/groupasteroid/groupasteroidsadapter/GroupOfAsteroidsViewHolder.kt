package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidBinding

class GroupOfAsteroidsViewHolder(
    private val binding: ItemAsteroidBinding
) : ViewHolder(binding.root) {

    fun bind(listAsteroid: String) {
        binding.textAsteroid.text = listAsteroid.toString()
    }
}

//class SubBreedViewHolder(
//    private val binding: ItemSubBreedBinding
//) : ViewHolder(binding.root) {
//
//    fun bind(name: String) {
//        binding.name.text = name
//    }
//}
//