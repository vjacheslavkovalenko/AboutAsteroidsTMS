package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.aboutasteroidstms.R
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentMainBinding
import by.vjacheslavkovalenko.aboutasteroidstms.ui.pictureofday.PictureOfDayFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            val pictureOfDayFragment = PictureOfDayFragment()
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.picture_of_day_container,
                    pictureOfDayFragment
                )
                .commit()
        }

        binding?.buttonAsteroidsByDate?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_asteroidsByDateFragment)
        }

        binding?.buttonWhatAsteroid?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_whatAsteroidFragment)
        }

        binding?.buttonDiscovery?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_discoveryAsteroidsFragment)
        }

        binding?.buttonAboutApp?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_aboutAppFragment)
        }
    }
}