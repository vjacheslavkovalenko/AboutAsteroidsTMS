package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid

//***
//class GroupOfAsteroidsAdapter : ListAdapter<Asteroid, GroupOfAsteroidsViewHolder>(
//    object : DiffUtil.ItemCallback<Asteroid>() {
//        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
//            return oldItem.id == newItem.id // Сравнение по уникальному идентификатору
//        }
//
//        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
//            return oldItem == newItem // Сравнение объектов по содержимому
//        }
//    }
//) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupOfAsteroidsViewHolder {
//        return GroupOfAsteroidsViewHolder(
//            ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: GroupOfAsteroidsViewHolder, position: Int) {
//        holder.bind(getItem(position)) // Передаем объект Asteroid в метод bind()
//    }
//}


//class GroupOfAsteroidsAdapter : ListAdapter<String, GroupOfAsteroidsViewHolder>(
class GroupOfAsteroidsAdapter : ListAdapter<Asteroid, GroupOfAsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return false
//            return oldItem.id == newItem.id // Сравнение по уникальному идентификатору
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return false
//            return oldItem == newItem // Сравнение объектов по содержимому
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupOfAsteroidsViewHolder {
        return GroupOfAsteroidsViewHolder(
            ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GroupOfAsteroidsViewHolder, position: Int) {
        // Передаем объект Asteroid в метод bind()
        holder.bind(getItem(position))
    }
}

