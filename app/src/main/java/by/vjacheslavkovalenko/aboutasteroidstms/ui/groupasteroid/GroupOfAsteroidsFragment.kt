package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.vjacheslavkovalenko.aboutasteroidstms.R
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentGroupOfAsteroidsBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.ui.detailsasteroid.DetailsAsteroidFragment
import by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.groupasteroidsadapter.GroupOfAsteroidsAdapter
import dagger.hilt.android.AndroidEntryPoint

//***
//@AndroidEntryPoint
//class GroupOfAsteroidsFragment : Fragment() {
//
//    private var binding: FragmentGroupOfAsteroidsBinding? = null
//
//    private val viewModel: GroupOfAsteroidsViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentGroupOfAsteroidsBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Получаем дату из аргументов
//        val selectedDate = arguments?.getString("SELECTED_DATE")
//        Log.d("GroupOfAsteroidsFragment", "Selected date: $selectedDate") // Логируем полученную дату
//
//        // Наблюдаем за изменениями в списке астероидов
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { list ->
//            setList(list)
//        }
//
//        // Загружаем данные о астероидах для выбранной даты
//        selectedDate?.let { viewModel.loadListAsteroidsByDate(it) }
//    }
//
//    private fun setList(list: List<AsteroidsByDate>) {
//        // Беру первый элемент списка AsteroidsByDate:
//        val firstItem = list.first()
//
//        // Устанавливаю дату в TextView
//        binding?.selectDateGroupAsteroids?.text = firstItem.dateOfAsteroids
//
//        // Получаю список астероидов
//        val asteroids = firstItem.groupOfAsteroids
//
//        binding?.recyclerViewGroupAsteroids?.run {
//            if (adapter == null) {
//                adapter = GroupOfAsteroidsAdapter { selectedAsteroid ->
//                    // Переход к DetailsAsteroidFragment при нажатии на астероид
//                    val detailsFragment = DetailsAsteroidFragment().apply {
//                        arguments = Bundle().apply {
//                            putLong("ASTEROID_ID", selectedAsteroid.id) // Передаем ID астероида во фрагмент как Long
//                        }
//                    }
//
//                    requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.container, detailsFragment)
//                        .addToBackStack(null)
//                        .commit()
//                }
//
//                layoutManager = LinearLayoutManager(requireContext())
//            }
//            // Передаю список астероидов в адаптер
//            (adapter as? GroupOfAsteroidsAdapter)?.submitList(asteroids)
//        }
//    }
//}

@AndroidEntryPoint
class GroupOfAsteroidsFragment : Fragment() {

    private var binding: FragmentGroupOfAsteroidsBinding? = null

    private val viewModel: GroupOfAsteroidsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ***       binding = FragmentGroupOfAsteroidsBinding.inflate(inflater, container, false)
        binding = FragmentGroupOfAsteroidsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем дату из аргументов
        val selectedDate = arguments?.getString("SELECTED_DATE")
        Log.d(
            "GroupOfAsteroidsFragment",
            "Selected date: $selectedDate"
        ) // Логируем полученную дату


        // Наблюдаем за изменениями в списке астероидов
        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { list ->
            setList(list)
        }

        // Загружаем данные о астероидах для выбранной даты
        selectedDate?.let { viewModel.loadListAsteroidsByDate(it) }
    }


    private fun setList(list: List<AsteroidsByDate>) {

        // Беру первый элемент списка AsteroidsByDate:
        val firstItem = list.first()
        // Устанавливаю дату в TextView
        binding?.selectDateGroupAsteroids?.text = firstItem.dateOfAsteroids

// Получаю список астероидов
        val asteroids = firstItem.groupOfAsteroids

        binding?.recyclerViewGroupAsteroids?.run {
            if (adapter == null) {
                adapter = GroupOfAsteroidsAdapter { selectedAsteroid ->
                    // Переход к DetailsAsteroidFragment при нажатии на астероид
                    val detailsFragment = DetailsAsteroidFragment().apply {
                        arguments = Bundle().apply {
                            putLong(//Изменить метод putString на putLong
                                "ASTEROID_ID",
                                selectedAsteroid.id
                            ) // Передаем ID астероида во фрагмент как Long
                        }
                    }

                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, detailsFragment)
                        .addToBackStack(null)
                        .commit()
                }

                layoutManager = LinearLayoutManager(requireContext())
            }
            // Передаю список астероидов
            (adapter as? GroupOfAsteroidsAdapter)?.submitList(asteroids)
        }
    }
}
//@AndroidEntryPoint
//class BreedListFragment : Fragment() {
//
//    private var binding: FragmentBreedListBinding? = null
//
//    private val viewModel: BreedListViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentBreedListBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.listBreed.observe(viewLifecycleOwner) {
//            setList(it)
//        }
//        viewModel.image.observe(viewLifecycleOwner) {
//            binding?.image?.loadUrl(it)
//        }
//        viewModel.loadListBreed()
//    }
//
//    private fun setList(list: List<Breed>) {
//        binding?.recyclerView?.run {
//            if (adapter == null) {
//                adapter = BreedAdapter {
//                    viewModel.loadBreedImage(it)
//                }
//                layoutManager = LinearLayoutManager(requireContext())
//            }
//            (adapter as? BreedAdapter)?.submitList(list)
//        }
//    }
//}