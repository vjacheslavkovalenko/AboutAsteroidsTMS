package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentWhatAsteroidBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WhatAsteroidFragment : Fragment() {

    private var binding: FragmentWhatAsteroidBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWhatAsteroidBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.webViewWhatAsteroid?.webViewClient = WebViewClient()

        lifecycleScope.launch {
            getHtmlContentFlow().collect { htmlContent ->
                binding?.webViewWhatAsteroid?.loadData(
                    htmlContent,
                    "text/html; charset=utf-8",
                    "UTF-8"
                )

                binding?.webViewWhatAsteroid?.apply {
                    settings.allowFileAccess = true
                    settings.javaScriptEnabled = true
                }
            }
        }

        binding?.buttonBackWhatAsteroid?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getHtmlContentFlow(): Flow<String> {
        return flow {
            val htmlFileName = "whatisanasteroid.html"
            val inputStream = requireActivity().assets.open("html/$htmlFileName")
            val htmlContent = inputStream.bufferedReader().use { it.readText() }
            emit(htmlContent)
        }
    }
}