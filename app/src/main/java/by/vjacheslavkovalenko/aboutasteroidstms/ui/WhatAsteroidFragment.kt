package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.webkit.WebView
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.aboutasteroidstms.databinding.FragmentWhatAsteroidBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WhatAsteroidFragment : Fragment() {

    private var binding: FragmentWhatAsteroidBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWhatAsteroidBinding.inflate(inflater)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "file:///android_asset/html/whatisanasteroid.html"

        //binding?.webViewWhatAsteroid?.loadUrl(url)
        binding?.webViewWhatAsteroid?.apply {
            settings.javaScriptEnabled = true
            loadUrl(url)
        }

        binding?.buttonBackWhatAsteroid?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}