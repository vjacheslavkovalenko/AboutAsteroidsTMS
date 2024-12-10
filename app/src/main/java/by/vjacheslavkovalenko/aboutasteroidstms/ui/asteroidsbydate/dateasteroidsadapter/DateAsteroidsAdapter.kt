package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemDateAsteroidsBinding

class DateAsteroidsAdapter(
    private val onDateClick: (String) -> Unit
) : ListAdapter<String, DateAsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAsteroidsViewHolder {
        return DateAsteroidsViewHolder(
            ItemDateAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DateAsteroidsViewHolder, position: Int) {
        val date = getItem(position)
        Log.d("DateAsteroidsAdapter", "Binding date at position $position: $date")
        holder.bind(date)

        holder.itemView.setOnClickListener {
            onDateClick(date)
        }
    }
}