package by.vjacheslavkovalenko.aboutasteroidstms.ui.pictureofday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentPictureOfDayBinding
import by.vjacheslavkovalenko.aboutasteroidstms.ui.MainActivity
import by.vjacheslavkovalenko.aboutasteroidstms.utils.loadUrl
import dagger.hilt.android.AndroidEntryPoint

//

//

//

//}
@AndroidEntryPoint
class PictureOfDayFragment : Fragment() {

    private var binding: FragmentPictureOfDayBinding? = null

    private val viewModel: PictureOfDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureOfDayBinding.inflate(inflater)
        return binding?.root
    }



//
//        binding?.tryAgainButton?.setOnClickListener {
//            viewModel.loadPictureOfDay()
//        }
//        // Пример кнопки для перехода к AsteroidsByDateFragment
//        binding?.buttonShowAsteroidsByDate?.setOnClickListener {
//            (activity as? MainActivity)?.showAsteroidsByDateFragment()
//        }
//
//        viewModel.loadPictureOfDay()
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.picture.observe(viewLifecycleOwner) {
//            Glide.with(requireContext()).load(it.url).into(binding?.imagePictureOfDay)
//            binding?.imagePictureOfDay?.loadUrl(it.message)
            binding?.imagePictureOfDay?.loadUrl(it.url)
            binding?.errorText?.visibility = View.GONE
            binding?.tryAgainButton?.visibility = View.GONE
            binding?.imagePictureOfDay?.visibility = View.VISIBLE
        }
        viewModel.showError = {
            binding?.errorText?.visibility = View.VISIBLE
            binding?.tryAgainButton?.visibility = View.VISIBLE
            binding?.imagePictureOfDay?.visibility = View.GONE
        }
        binding?.tryAgainButton?.setOnClickListener {
            viewModel.loadPictureOfDay()
        }
            // Пример кнопки для перехода к AsteroidsByDateFragment
        binding?.buttonShowAsteroidsByDate?.setOnClickListener {//удалить
            (activity as? MainActivity)?.showAsteroidsByDateFragment()//удалить
        }//удалить

        viewModel.loadPictureOfDay()
    }
}
//
//
//@AndroidEntryPoint
//class DogImageFragment : Fragment() {
//
//    private var binding: FragmentDogImageBinding? = null
//
//    private val viewModel: DogImageViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentDogImageBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.image.observe(viewLifecycleOwner) {
//            binding?.image?.loadUrl(it.message)
//            binding?.errorText?.visibility = View.GONE
//            binding?.tryAgainButton?.visibility = View.GONE
//            binding?.image?.visibility = View.VISIBLE
//        }
//        viewModel.showError = {
//            binding?.errorText?.visibility = View.VISIBLE
//            binding?.tryAgainButton?.visibility = View.VISIBLE
//            binding?.image?.visibility = View.GONE
//        }
//        binding?.tryAgainButton?.setOnClickListener {
//            viewModel.loadDogImage()
//        }
//        viewModel.loadDogImage()
//    }
//}
