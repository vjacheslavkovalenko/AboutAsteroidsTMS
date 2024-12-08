package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid

class GroupOfAsteroidsAdapter(
    private val onAsteroidClick: (Asteroid) -> Unit
) : ListAdapter<Asteroid, GroupOfAsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<Asteroid>() {

        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupOfAsteroidsViewHolder {
        return GroupOfAsteroidsViewHolder(
            ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GroupOfAsteroidsViewHolder, position: Int) {
        val asteroid = getItem(position)
        holder.bind(asteroid)

        holder.itemView.setOnClickListener {
            Log.d(
                "GroupOfAsteroidsAdapter",
                "Asteroid clicked: ${asteroid.name}"
            )
            onAsteroidClick(asteroid)
        }

    }
}