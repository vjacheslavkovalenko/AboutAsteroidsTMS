package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentDiscoveryAsteroidsBinding
import android.webkit.WebView
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.aboutasteroidstms.repository.FirebaseRepository
import dagger.hilt.android.AndroidEntryPoint
import android.webkit.WebViewClient

@AndroidEntryPoint
class DiscoveryAsteroidsFragment : Fragment() {

    private var binding: FragmentDiscoveryAsteroidsBinding? = null

    private val firebaseRepository = FirebaseRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoveryAsteroidsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.webViewDiscovery?.webViewClient = WebViewClient()

        firebaseRepository.getHtmlContent { htmlContent ->
            htmlContent?.let {
                binding?.webViewDiscovery?.loadData(it, "text/html", "UTF-8")
            } ?: run {
                binding?.webViewDiscovery?.loadData(
                    "<h1>Error</h1><p>HTML content not found.</p>",
                    "text/html",
                    "UTF-8"
                )
            }
        }

        binding?.buttonBackDiscoveryAsteroids?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}