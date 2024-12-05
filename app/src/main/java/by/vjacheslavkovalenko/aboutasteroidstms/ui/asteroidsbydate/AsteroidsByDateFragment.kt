package by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate

import android.os.Bundle
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

//ИИ написал:
//@AndroidEntryPoint
//class AsteroidsByDateFragment : Fragment() {
//
//    private var binding: FragmentAsteroidsByDateBinding? = null
//    private val viewModel: AsteroidsByDateViewModel by viewModels()
//    private lateinit var adapter: DateAsteroidsAdapter
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
//        adapter = DateAsteroidsAdapter()
//        binding?.recyclerViewDate?.layoutManager = LinearLayoutManager(requireContext())
//        binding?.recyclerViewDate?.adapter = adapter
//
//        // Наблюдение за данными из ViewModel
//        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { list ->
//            setList(list)
//        }
//
//        // Загрузка данных из ViewModel
//        viewModel.loadListAsteroidsByDate()
//    }
//
//    private fun setList(list: List<String>) {
//        adapter.submitList(list)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождаем привязку при уничтожении представления
//    }
//}


@AndroidEntryPoint
class AsteroidsByDateFragment : Fragment(){

    private var binding: FragmentAsteroidsByDateBinding? = null

    private val viewModel: AsteroidsByDateViewModel  by viewModels()
//        private lateinit var adapter: DateAsteroidsAdapter

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
        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) {
            setList(it)
        }

        viewModel.loadListAsteroidsByDate()
    }

    private fun setList(list: List<String>) {
        binding?.recyclerViewDate?.run {
            if (adapter == null) {

                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? DateAsteroidsAdapter)?.submitList(list)
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

//import com.example.lesson26.util.loadUrl
//
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
