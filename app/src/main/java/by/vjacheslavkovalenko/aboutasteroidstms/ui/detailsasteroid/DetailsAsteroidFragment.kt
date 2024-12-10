package by.vjacheslavkovalenko.aboutasteroidstms.ui.detailsasteroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.aboutasteroidstms.R
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentDetailsAsteroidBinding
import by.vjacheslavkovalenko.aboutasteroidstms.model.Asteroid
import by.vjacheslavkovalenko.aboutasteroidstms.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsAsteroidFragment : Fragment() {

    private var binding: FragmentDetailsAsteroidBinding? = null

    private val viewModel: DetailsAsteroidViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsAsteroidBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val asteroidId = arguments?.getLong("ASTEROID_ID") ?: return

        viewModel.loadAsteroidById(asteroidId)

        viewModel.asteroid.observe(viewLifecycleOwner, Observer { asteroid ->
            asteroid?.let {
                displayAsteroidDetails(it)
            }
        })

//        binding?.buttonBackDetails?.setOnClickListener {
////            findNavController().navigate(R.id.action_detailsAsteroidFragment_to_groupOfAsteroidsFragment)
////            findNavController().popBackStack()
//            findNavController().navigateUp()
//        }

//        binding?.buttonHomeDetails?.setOnClickListener {
//            findNavController().navigate(R.id.action_detailsAsteroidFragment_to_mainFragment)
//        }



        // Обработчик для кнопки "Назад"
        binding?.buttonBackDetails?.setOnClickListener {
            (activity as? MainActivity)?.onBackPressed() // Вызов метода для обработки нажатия "Назад"
        }

//        // Обработчик для кнопки "Главная"
//        binding?.buttonHomeDetails?.setOnClickListener {
//            (activity as? MainActivity)?.showHomeFragment() // Вызов метода для перехода на главную страницу
//        }


    }

    private fun displayAsteroidDetails(asteroid: Asteroid) {
        binding?.textViewName?.text = asteroid.name
        binding?.textViewId?.text = "ID: ${asteroid.id}"
        binding?.textViewAbsoluteMagnitude?.text =
            "Absolute Magnitude: ${asteroid.absoluteMagnitude}"
        binding?.textViewEstimatedDiameter?.text =
            "Estimated Diameter: ${asteroid.estimatedDiameter}"
        binding?.textViewRelativeVelocity?.text =
            "Relative Velocity: ${asteroid.relativeVelocity}"
        binding?.textViewDistanceFromEarth?.text =
            "Distance from Earth: ${asteroid.distanceFromEarth}"
        binding?.textViewIsPotentiallyHazardous?.text =
            "Potentially Hazardous: ${if (asteroid.isPotentiallyHazardous) "Yes" else "No"}"

        if (asteroid.isPotentiallyHazardous) {
            binding?.imageHazardous?.setImageResource(R.drawable.asteroid_hazardous)
        } else {
            binding?.imageHazardous?.setImageResource(R.drawable.asteroid_safe)
        }
    }
}