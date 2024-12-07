package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentGroupOfAsteroidsBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
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
//    ): View {
//        binding = FragmentGroupOfAsteroidsBinding.inflate(inflater, container, false)
//        return binding!!.root // Используем !! для явного указания, что binding не null
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Наблюдаем за изменениями в списке астероидов
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { asteroidsByDateList ->
//            setList(asteroidsByDateList)
//        }
//
//        // Загружаем данные
//        viewModel.loadListAsteroidsByDate()
//    }
//
//    private fun setList(list: List<AsteroidsByDate>) {
//        // Проверяем, есть ли данные в списке
//        if (list.isNotEmpty()) {
//            val firstItem = list.first() // Берем первый элемент списка AsteroidsByDate
//            binding?.selectDateGroupAsteroids?.text = firstItem.dateOfAsteroids // Устанавливаем дату в TextView
//
//            val asteroids = firstItem.groupOfAsteroids // Получаем список астероидов
//
//            binding?.recyclerViewGroupAsteroids?.run {
//                if (adapter == null) {
//                    adapter = GroupOfAsteroidsAdapter()
//                    layoutManager = LinearLayoutManager(requireContext())
//                }
//                (adapter as? GroupOfAsteroidsAdapter)?.submitList(asteroids) // Передаем список астероидов
//            }
//        } else {
//            // Обработка случая, когда список пустой (например, очистка TextView)
//            binding?.selectDateGroupAsteroids?.text = "Нет доступных данных"
//            (binding?.recyclerViewGroupAsteroids?.adapter as? GroupOfAsteroidsAdapter)?.submitList(emptyList())
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождаем ресурсы
//    }
//}

//*******************
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
//        viewModel.loadListAsteroidsByDate(selectedDate) // Загружаем данные для выбранной даты (если это необходимо)
//    }
//
//    private fun setList(list: List<AsteroidsByDate>) {
//        // Здесь ваша логика для отображения списка астероидов
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
//        viewModel.loadListAsteroidsByDate(selectedDate) // Загружаем данные для выбранной даты (если это необходимо)
//    }
//
//    private fun setList(list: List<AsteroidsByDate>) {
//        // Здесь ваша логика для отображения списка астероидов
//    }
//}



    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //    super.onViewCreated(view, savedInstanceState)
    //
    //    // Получаем дату из аргументов
    //    val selectedDate = arguments?.getString("SELECTED_DATE")
    //    Log.d("GroupOfAsteroidsFragment", "Selected date: $selectedDate") // Логируем полученную дату
    //
    //    // Наблюдаем за изменениями в списке астероидов
    //    viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { list ->
    //        setList(list)
    //    }
    //
    //    // Загружаем данные о астероидах для выбранной даты
    //    selectedDate?.let { viewModel.loadListAsteroidsByDate(it) }
    //}

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
        // Наблюдаем за изменениями в списке астероидов
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) {
            //            Log.d("GroupOfAsteroidsFragment", "Observing dates: $dates")
//            setList(it)
//        }

//        viewModel.loadListAsteroidsByDate()
//                viewModel.loadListAsteroidsByDate(selectedDate) // Загружаем данные для выбранной даты (если это необходимо)
//    }

    private fun setList(list: List<AsteroidsByDate>) {

        // Беру первый элемент списка AsteroidsByDate:
        val firstItem = list.first()
        // Устанавливаю дату в TextView
        binding?.selectDateGroupAsteroids?.text = firstItem.dateOfAsteroids

// Получаю список астероидов
        val asteroids = firstItem.groupOfAsteroids

        binding?.recyclerViewGroupAsteroids?.run {
            if (adapter == null) {
                adapter = GroupOfAsteroidsAdapter()
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