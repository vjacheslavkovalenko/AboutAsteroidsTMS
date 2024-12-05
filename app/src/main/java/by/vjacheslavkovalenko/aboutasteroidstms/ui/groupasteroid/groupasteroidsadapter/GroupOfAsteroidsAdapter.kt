package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemAsteroidBinding

class GroupOfAsteroidsAdapter : ListAdapter<String, GroupOfAsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupOfAsteroidsViewHolder {
        return GroupOfAsteroidsViewHolder(
            ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

        override fun onBindViewHolder(holder: GroupOfAsteroidsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
//class SubBreedAdapter : ListAdapter<String, SubBreedViewHolder>(
//    object : DiffUtil.ItemCallback<String>() {
//        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//            return false
//        }
//
//        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return false
//        }
//    }
//) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubBreedViewHolder {
//        return SubBreedViewHolder(
//            ItemSubBreedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: SubBreedViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//}
