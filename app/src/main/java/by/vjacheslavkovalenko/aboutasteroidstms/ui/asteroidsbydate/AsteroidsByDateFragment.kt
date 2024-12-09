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
import by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.dateasteroidsadapter.DateAsteroidsAdapter
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import by.vjacheslavkovalenko.aboutasteroidstms.R
import by.vjacheslavkovalenko.aboutasteroidstms.ui.groupasteroid.GroupOfAsteroidsFragment

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
            setList(dates)
        }

        viewModel.loadListAsteroidsByDate()
    }

    private fun setList(list: List<String>) {
        Log.d("AsteroidsByDateFragment", "Setting list: $list")
        binding?.recyclerViewDate?.run {
            if (adapter == null) {
                adapter = DateAsteroidsAdapter { selectedDate ->
                    val groupOfAsteroidsFragment = GroupOfAsteroidsFragment().apply {
                        arguments = Bundle().apply {
                            putString(
                                "SELECTED_DATE",
                                selectedDate
                            )
                        }
                    }

                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, groupOfAsteroidsFragment)
                        .addToBackStack(null)
                        .commit()
                }

                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? DateAsteroidsAdapter)?.submitList(list)
            Log.d(
                "AsteroidsByDateFragment",
                "Submitting list to adapter: $list"
            )
        }
    }
}
