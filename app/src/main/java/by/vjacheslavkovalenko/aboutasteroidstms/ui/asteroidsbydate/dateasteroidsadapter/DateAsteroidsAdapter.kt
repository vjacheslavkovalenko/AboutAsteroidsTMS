package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemDateAsteroidsBinding

class DateAsteroidsAdapter : ListAdapter<String, DateAsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAsteroidsViewHolder {
        return DateAsteroidsViewHolder(
            ItemDateAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DateAsteroidsViewHolder, position: Int) {
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