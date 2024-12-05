package by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid

import android.os.Bundle
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

//class GroupOfAsteroidsFragment : Fragment() {
//
//    private var binding: FragmentGroupOfAsteroidsBinding? = null
//    private val viewModel: GroupOfAsteroidsViewModel by viewModels()
//    private lateinit var adapter: GroupOfAsteroidsAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentGroupOfAsteroidsBinding.inflate(inflater, container, false)
//        return binding!!.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Инициализация адаптера и RecyclerView
//        adapter = GroupOfAsteroidsAdapter()
//        binding?.recyclerView?.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = this@GroupOfAsteroidsFragment.adapter
//        }
//
//        // Наблюдение за данными из ViewModel
//        viewModel.groupsOfAsteroids.observe(viewLifecycleOwner) { groups ->
//            adapter.submitList(groups)
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
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
        binding = FragmentGroupOfAsteroidsBinding.inflate(inflater)
        return binding?.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) {
            setList(it)
        }
            //это для фотки собаки
//        viewModel.image.observe(viewLifecycleOwner) {
//            binding?.image?.loadUrl(it)
//        }
        viewModel.loadListAsteroidsByDate()
    }

        private fun setList(list: List<AsteroidsByDate>) {
        binding?.recyclerViewGroupAsteroids?.run {
            if (adapter == null) {
                adapter = GroupOfAsteroidsAdapter {
                   // viewModel.loadBreedImage(it)
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? GroupOfAsteroidsAdapter)?.submitList(list)
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