package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.ItemDateAsteroidsBinding

class DateAsteroidsViewHolder(
    private val binding: ItemDateAsteroidsBinding
) : ViewHolder(binding.root) {

    fun bind(dateAsteroids: String) {
        binding.dateOfGroupAsteroids.text = dateAsteroids
    }

//    fun bind(item: String) {
//       // binding.dateOfGroupAsteroids.text = item.dateOfAsteroids
//        binding.recyclerView.run {
//            if (adapter == null) {
//                adapter = DateAsteroidsAdapter()
//                layoutManager = LinearLayoutManager(binding.root.context)
//            }
//            (adapter as? DateAsteroidsAdapter)?.submitList(item.dateOfGroupAsteroids)
//        }
//    }
//}
}

//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.example.lesson26.databinding.ItemSubBreedBinding
//
//class SubBreedViewHolder(
//    private val binding: ItemSubBreedBinding
//) : ViewHolder(binding.root) {
//
//    fun bind(name: String) {
//        binding.name.text = name
//    }
//}