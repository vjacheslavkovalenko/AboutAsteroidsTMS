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


//
//class WhatAsteroidFragment : Fragment() {
//
//    private var binding: FragmentWhatAsteroidBinding? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentWhatAsteroidBinding.inflate(inflater, container, false)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Установите WebViewClient для обработки загрузки страниц
//        binding?.webViewWhatAsteroid?.webViewClient = WebViewClient()
//
//        // Запускаем корутину для получения данных с использованием Flow
//        lifecycleScope.launch {
//            getHtmlContentFlow().collect { htmlContent ->
//                // Загружаем HTML-контент в WebView
//                binding?.webViewWhatAsteroid?.loadData(htmlContent, "text/html; charset=utf-8", "UTF-8")
//            }
//        }
//    }
//
//    private fun getHtmlContentFlow(): Flow<String> {
//        return flow {
//            // Здесь вы можете загружать данные из сети или локального источника.
//            // Например, просто возвращаем статический HTML-контент.
//            val htmlContent = """
//                <!DOCTYPE html>
//                <html lang="ru">
//                <head>
//                    <meta charset="UTF-8">
//                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
//                    <title>Что такое астероиды</title>
//                    <style>
//                        body { background-color: black; color: white; }
//                    </style>
//                </head>
//                <body>
//                    <h2>Что такое астероиды</h2>
//                    <p>Астероиды — это твердые каменистые тела...</p>
//                </body>
//                </html>
//            """.trimIndent()
//            emit(htmlContent) // Отправляем HTML-контент через Flow
//        }
//    }
//}
@AndroidEntryPoint
class WhatAsteroidFragment : Fragment() {

    private var binding: FragmentWhatAsteroidBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentWhatAsteroidBinding.inflate(inflater)
        binding = FragmentWhatAsteroidBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Устанавливаю WebViewClient для обработки загрузки страниц
        binding?.webViewWhatAsteroid?.webViewClient = WebViewClient()

       // val url = "file:///android_asset/html/whatisanasteroid.html"

        // Запускаем корутину для получения данных с использованием Flow
        lifecycleScope.launch {
            getHtmlContentFlow().collect { htmlContent ->
                // Загружаем HTML-контент в WebView
                binding?.webViewWhatAsteroid?.loadData(htmlContent, "text/html; charset=utf-8", "UTF-8")

                binding?.webViewWhatAsteroid?.apply {
                    settings.allowFileAccess = true
//                    settings.allowFileAccessFromFileURLs = true
//                    settings.allowUniversalAccessFromFileURLs = true
                    settings.javaScriptEnabled = true
//            loadUrl(url)
                }


            }
        }


////        binding?.webViewWhatAsteroid?.loadUrl(url)
//        binding?.webViewWhatAsteroid?.apply {
//            settings.javaScriptEnabled = true
//            loadUrl(url)
//        }


        binding?.buttonBackWhatAsteroid?.setOnClickListener {
            findNavController().popBackStack()
        }
    }



    //    private fun getHtmlContentFlow(): Flow<String> {
//        return flow {
//            // Читаем HTML-файл из папки assets и возвращаем его содержимое как строку
//            val htmlFileName = "whatisanasteroid.html"
//            val inputStream = requireActivity().assets.open("html/$htmlFileName")
//            val htmlContent = inputStream.bufferedReader().use { it.readText() }
//            emit(htmlContent) // Отправляем HTML-контент через Flow
//        }
//    }
        private fun getHtmlContentFlow(): Flow<String> {
        return flow {
            // Читаем HTML-файл из папки assets и возвращаем его содержимое как строку
            val htmlFileName = "whatisanasteroid.html"
            val inputStream = requireActivity().assets.open("html/$htmlFileName")
            val htmlContent = inputStream.bufferedReader().use { it.readText() }
            emit(htmlContent) // Отправляем HTML-контент через Flow


            // Здесь просто статический HTML-контент.
//            val htmlContent = """
//                <!DOCTYPE html>
//                <html lang="ru">
//                <head>
//                    <meta charset="UTF-8">
//                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
//                    <title>Что такое астероиды</title>
//                    <style>
//                        body { background-color: black; color: white; }
//                    </style>
//                </head>
//                <body>
//                    <h2>Что такое астероиды</h2>
//                    <p>Астероиды — это твердые каменистые тела...</p>
//                </body>
//                </html>
//            """.trimIndent()
//            emit(htmlContent) // Отправляем HTML-контент через Flow
        }
    }
}



//

//

//

//

