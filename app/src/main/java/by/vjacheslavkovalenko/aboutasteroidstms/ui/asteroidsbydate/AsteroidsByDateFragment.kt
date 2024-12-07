package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentAsteroidsByDateBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.AsteroidsByDate
import by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter.DateAsteroidsAdapter
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import by.vjacheslavkovalenko.aboutasteroidstms.R
import by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.GroupOfAsteroidsFragment

//ИИ написал:
//@AndroidEntryPoint
//class AsteroidsByDateFragment : Fragment() {
//
//    private var binding: FragmentAsteroidsByDateBinding? = null
//    private val viewModel: AsteroidsByDateViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentAsteroidsByDateBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Наблюдаем за изменениями в списке астероидов по датам
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { dates ->
//            setList(dates)
//        }
//
//        // Загружаем данные о астероидах по датам
//        viewModel.loadListAsteroidsByDate()
//    }
//
//    private fun setList(list: List<String>) {
//        binding?.recyclerViewDate?.run {
//            if (adapter == null) {
//                adapter = DateAsteroidsAdapter { selectedDate ->
//                    // Переход к GroupOfAsteroidsFragment при нажатии на дату
//                    val groupOfAsteroidsFragment = GroupOfAsteroidsFragment().apply {
//                        arguments = Bundle().apply {
//                            putString("SELECTED_DATE", selectedDate) // Передаем выбранную дату во фрагмент
//                        }
//                    }
//                    requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.container, groupOfAsteroidsFragment)
//                        .addToBackStack(null)
//                        .commit()
//                } // Инициализация адаптера с обработчиком нажатия на дату
//
//                layoutManager = LinearLayoutManager(requireContext()) // Установка LayoutManager
//            }
//            (adapter as? DateAsteroidsAdapter)?.submitList(list) // Обновление данных в адаптере
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождаем ресурсы
//    }
//}

//333333
//@AndroidEntryPoint
//class AsteroidsByDateFragment : Fragment() {
//
//    private var binding: FragmentAsteroidsByDateBinding? = null
//    private val viewModel: AsteroidsByDateViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentAsteroidsByDateBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Инициализация адаптера и RecyclerView
//        val adapter = DateAsteroidsAdapter { selectedDate ->
//            // Здесь можно добавить логику обработки нажатия на дату
//            val groupOfAsteroidsFragment = GroupOfAsteroidsFragment().apply {
//                arguments = Bundle().apply {
//                    putString("SELECTED_DATE", selectedDate) // Передаем выбранную дату во фрагмент
//                }
//            }
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.container, groupOfAsteroidsFragment)
//                .addToBackStack(null)
//                .commit()
//        }
//
//        binding?.recyclerViewDate?.layoutManager = LinearLayoutManager(requireContext())
//        binding?.recyclerViewDate?.adapter = adapter // Установка адаптера
//
//        // Наблюдаем за изменениями в списке астероидов по датам
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { dates ->
//            setList(dates)
//        }
//
//        // Загружаем данные о астероидах по датам
//        viewModel.loadListAsteroidsByDate()
//    }
//
//    private fun setList(list: List<String>) {
//        binding?.recyclerViewDate?.adapter?.let { adapter ->
//            (adapter as? DateAsteroidsAdapter)?.submitList(list) // Обновление данных в адаптере
//        }
//    }
//
//}

//у меня было:
@AndroidEntryPoint
class AsteroidsByDateFragment : Fragment() {

    private var binding: FragmentAsteroidsByDateBinding? = null

    private val viewModel: AsteroidsByDateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAsteroidsByDateBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { dates ->
            Log.d("AsteroidsByDateFragment", "Observing dates: $dates")
            setList(dates) //  Передаем список дат в адаптер. Убедитесь, что setList() обрабатывает все даты
        }

// Загружаем данные о астероидах по датам
        viewModel.loadListAsteroidsByDate()
    }

    private fun setList(list: List<String>) {
        Log.d("AsteroidsByDateFragment", "Setting list: $list") // Логируем список дат
        binding?.recyclerViewDate?.run {
            if (adapter == null) {
                adapter = DateAsteroidsAdapter { selectedDate ->
                    // Переход к GroupOfAsteroidsFragment при нажатии на дату
                    val groupOfAsteroidsFragment = GroupOfAsteroidsFragment().apply {
                        arguments = Bundle().apply {
                            putString(
                                "SELECTED_DATE",
                                selectedDate
                            ) // Передаем выбранную дату во фрагмент
                        }
                    }

                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, groupOfAsteroidsFragment)
                        .addToBackStack(null)
                        .commit()
                } // Инициализация адаптера с обработчиком нажатия на дату

                // Инициализация адаптера
                layoutManager = LinearLayoutManager(requireContext()) // Установка LayoutManager
            }
            (adapter as? DateAsteroidsAdapter)?.submitList(list)// Обновление данных в адаптере
            Log.d(
                "AsteroidsByDateFragment",
                "Submitting list to adapter: $list"
            )// Логируем отправленный список
        }
    }
}


//@AndroidEntryPoint
//class AsteroidsByDateFragment : Fragment(){
//
//    private var binding: FragmentAsteroidsByDateBinding? = null
//
//    private val viewModel: AsteroidsByDateViewModel  by viewModels()
//
//        override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentAsteroidsByDateBinding.inflate(inflater)
//        return binding?.root
//    }
//    //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////
////        // Инициализация адаптера и RecyclerView
////        adapter = DateAsteroidsAdapter()
////        binding?.recyclerViewDate?.layoutManager = LinearLayoutManager(requireContext())
////        binding?.recyclerViewDate?.adapter = adapter
////
////        // Наблюдение за данными из ViewModel
////        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { list ->
////            setList(list)
////        }
////
////        // Загрузка данных из ViewModel
////        viewModel.loadListAsteroidsByDate()
////    }
//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) {
//            setList(it)
//        }
//            //это для фотки собаки
////        viewModel.image.observe(viewLifecycleOwner) {
////            binding?.image?.loadUrl(it)
////        }
////        viewModel.loadListAsteroidsByDate().toString()
//        viewModel.loadListAsteroidsByDate()
//    }
//
////        private fun setList(list: List<AsteroidsByDate>) {
//        private fun setList(list: List<String>) {
//        binding?.recyclerViewDate?.run {
//            if (adapter == null) {
////                adapter = DateAsteroidsAdapter {
////                    viewModel.loadBreedImage(it)
////                }
//                layoutManager = LinearLayoutManager(requireContext())
//            }
//            (adapter as? DateAsteroidsAdapter)?.submitList(list)
//        }
//    }
//}

