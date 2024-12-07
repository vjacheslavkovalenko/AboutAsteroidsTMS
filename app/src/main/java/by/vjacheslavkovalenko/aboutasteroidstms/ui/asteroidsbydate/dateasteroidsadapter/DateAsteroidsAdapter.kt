package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemDateAsteroidsBinding
import androidx.recyclerview.widget.RecyclerView









//333
//class DateAsteroidsAdapter(
//    private val onDateClick: (String) -> Unit // Обработчик нажатия на дату
//) : ListAdapter<String, DateAsteroidsViewHolder>(
//    object : DiffUtil.ItemCallback<String>() {
//        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem == newItem // Сравнение элементов по значению
//        }
//
//        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem == newItem // Сравнение содержимого элементов
//        }
//    }
//) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAsteroidsViewHolder {
//        return DateAsteroidsViewHolder(
//            ItemDateAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: DateAsteroidsViewHolder, position: Int) {
//        val date = getItem(position)
//        holder.bind(date)
//
//        // Устанавливаем обработчик клика
//        holder.itemView.setOnClickListener {
//            onDateClick(date) // Вызываем обработчик при нажатии
//        }
//    }
//}
//






class DateAsteroidsAdapter(
    private val onDateClick: (String) -> Unit // Обработчик нажатия на дату
) : ListAdapter<String, DateAsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            //return false
            return oldItem == newItem // Сравнение элементов по значению
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return false
            return oldItem == newItem // Сравнение содержимого элементов
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
        Log.d("DateAsteroidsAdapter", "Binding date at position $position: $date") // Логируем дату
        holder.bind(date) // Передаем дату в ViewHolder
//        holder.bind(getItem(position))

        // Устанавливаем обработчик клика
        holder.itemView.setOnClickListener {
            onDateClick(date) // Вызываем обработчик при нажатии
        }
    }
}


