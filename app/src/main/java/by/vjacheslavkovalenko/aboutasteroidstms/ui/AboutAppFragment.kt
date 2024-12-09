package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment() {

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

        binding?.buttonBackAbout?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}