package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid

class GroupOfAsteroidsViewHolder(
    private val binding: ItemAsteroidBinding
) : ViewHolder(binding.root) {

    fun bind(asteroid: Asteroid) {
        binding.textAsteroid.text = asteroid.name
    }
}
