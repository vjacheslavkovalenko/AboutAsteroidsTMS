package by.vjacheslavkovalenko.aboutasteroidstms.ui.detailsasteroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentDetailsAsteroidBinding
import dagger.hilt.android.AndroidEntryPoint

//***
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
//import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentDetailsAsteroidBinding
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class DetailsAsteroidFragment : Fragment() {
//
//    private var binding: FragmentDetailsAsteroidBinding? = null
//
//    private val viewModel: DetailsAsteroidViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentDetailsAsteroidBinding.inflate(inflater, container, false)
//        return binding!!.root // Используем !! для явного указания, что binding не null
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Получаем ID астероида из аргументов фрагмента
//        val asteroidId = arguments?.getLong("ASTEROID_ID") ?: return
//
//        // Загружаем данные о астероиде по ID
//        viewModel.loadAsteroidById(asteroidId)
//
//        // Наблюдаем за изменениями в объекте астероида
//        viewModel.asteroid.observe(viewLifecycleOwner, Observer { asteroid ->
//            asteroid?.let {
//                displayAsteroidDetails(it)
//            }
//        })
//    }
//
//    private fun displayAsteroidDetails(asteroid: Asteroid) {
//        binding?.textViewName?.text = asteroid.name
//        binding?.textViewId?.text = "ID: ${asteroid.id}"
//        binding?.textViewCloseApproachDate?.text = "Close Approach Date: ${asteroid.closeApproachDate}"
//        binding?.textViewAbsoluteMagnitude?.text = "Absolute Magnitude: ${asteroid.absoluteMagnitude}"
//        binding?.textViewEstimatedDiameter?.text = "Estimated Diameter: ${asteroid.estimatedDiameter}"
//        binding?.textViewRelativeVelocity?.text = "Relative Velocity: ${asteroid.relativeVelocity}"
//        binding?.textViewDistanceFromEarth?.text = "Distance from Earth: ${asteroid.distanceFromEarth}"
//        binding?.textViewIsPotentiallyHazardous?.text = "Potentially Hazardous: ${if (asteroid.isPotentiallyHazardous) "Yes" else "No"}"
//
//        // Загрузка изображения для hazardous (если требуется)
//        if (asteroid.isPotentiallyHazardous) {
//            binding?.imageHazardous?.setImageResource(R.drawable.ic_hazardous) // Замените на ваше изображение опасного астероида
//        } else {
//            binding?.imageHazardous?.setImageResource(R.drawable.ic_not_hazardous) // Замените на ваше изображение безопасного астероида
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождаем ресурсы
//    }
//}

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
    //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.listBreed.observe(viewLifecycleOwner) {
//            setList(it)
//        }
//        viewModel.loadListBreed()
//    }
    //из picture моего:
    //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //        super.onViewCreated(view, savedInstanceState)
    //        viewModel.picture.observe(viewLifecycleOwner) {
    //            binding?.imagePictureOfDay?.loadUrl(it.url)
    //            binding?.errorText?.visibility = View.GONE
    //            binding?.tryAgainButton?.visibility = View.GONE
    //            binding?.imagePictureOfDay?.visibility = View.VISIBLE
    //        }
    //        viewModel.showError = {
    //            binding?.errorText?.visibility = View.VISIBLE
    //            binding?.tryAgainButton?.visibility = View.VISIBLE
    //            binding?.imagePictureOfDay?.visibility = View.GONE
    //        }
    //        binding?.tryAgainButton?.setOnClickListener {
    //            viewModel.loadPictureOfDay()
    //        }
    //        viewModel.loadPictureOfDay()
    //    }
    //}
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.asteroid.observe(viewLifecycleOwner, Observer { asteroid ->
            asteroid?.let {
                displayAsteroidDetails(it)
            }
        })

        //---
        // Получаем ID астероида из аргументов фрагмента
        val asteroidId = arguments?.getLong("ASTEROID_ID") ?: return

        // Загружаем данные о астероиде по ID
        viewModel.loadAsteroidById(asteroidId)

        // Наблюдаем за изменениями в объекте астероида
        viewModel.asteroid.observe(viewLifecycleOwner, Observer { asteroid ->
            asteroid?.let {
                displayAsteroidDetails(it)
            }
        })
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