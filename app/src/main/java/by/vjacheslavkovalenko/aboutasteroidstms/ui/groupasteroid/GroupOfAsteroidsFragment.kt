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

        val selectedDate = arguments?.getString("SELECTED_DATE")
        Log.d(
            "GroupOfAsteroidsFragment",
            "Selected date: $selectedDate"
        )

        viewModel.listAsteroidsByDate.observe(viewLifecycleOwner) { list ->
            setList(list)
        }

        selectedDate?.let { viewModel.loadListAsteroidsByDate(it) }
    }

    private fun setList(list: List<AsteroidsByDate>) {

        val firstItem = list.first()
        binding?.selectDateGroupAsteroids?.text = firstItem.dateOfAsteroids

        val asteroids = firstItem.groupOfAsteroids

        binding?.recyclerViewGroupAsteroids?.run {
            if (adapter == null) {
                adapter = GroupOfAsteroidsAdapter { selectedAsteroid ->
                    val detailsFragment = DetailsAsteroidFragment().apply {
                        arguments = Bundle().apply {
                            putLong(
                                "ASTEROID_ID",
                                selectedAsteroid.id
                            )
                        }
                    }

                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, detailsFragment)
                        .addToBackStack(null)
                        .commit()
                }

                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? GroupOfAsteroidsAdapter)?.submitList(asteroids)
        }
    }
}
