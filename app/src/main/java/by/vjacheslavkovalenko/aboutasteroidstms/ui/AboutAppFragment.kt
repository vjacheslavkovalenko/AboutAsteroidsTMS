package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentAboutAppBinding

class AboutAppFragment  : Fragment() {

        private var binding: FragmentAboutAppBinding? = null

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentAboutAppBinding.inflate(inflater)
            return binding?.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
    //
    //        if (savedInstanceState == null) {
    //            val pictureOfDayFragment = PictureOfDayFragment()
    //            childFragmentManager.beginTransaction()
    //                .replace(R.id.picture_of_day_container, pictureOfDayFragment) // Замените на ваш ID контейнера
    //                .commit()
    //        }
    //
    //        binding?.buttonAboutApp?.setOnClickListener {
    //            findNavController().navigate(R.id.action_mainFragment_to_aboutAppFragment)
    //        }
    //    }
    }
}