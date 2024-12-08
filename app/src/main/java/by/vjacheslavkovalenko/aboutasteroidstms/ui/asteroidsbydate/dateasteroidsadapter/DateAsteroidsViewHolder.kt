package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemDateAsteroidsBinding

class DateAsteroidsViewHolder(
    private val binding: ItemDateAsteroidsBinding
) : ViewHolder(binding.root) {

    fun bind(dateAsteroids: String) {

        binding.dateOfGroupAsteroids.text = dateAsteroids
        Log.d("DateAsteroidsViewHolder", "Binding date: $dateAsteroids")
    }
}