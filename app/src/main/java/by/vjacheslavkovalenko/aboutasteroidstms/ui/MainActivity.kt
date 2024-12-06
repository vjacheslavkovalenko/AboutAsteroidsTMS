package by.vjacheslavkovalenko.aboutasteroidstms.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import by.vjacheslavkovalenko.aboutasteroidstms.R
import by.vjacheslavkovalenko.aboutasteroidstms.ui.asteroidsbydate.AsteroidsByDateFragment
import by.vjacheslavkovalenko.aboutasteroidstms.ui.pictureofday.PictureOfDayFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, AsteroidsByDateFragment())
//            .commit()
        //для запуска другого фрагмента
        if (savedInstanceState == null) {//удалить
            supportFragmentManager.beginTransaction()//удалить
                .replace(R.id.container, PictureOfDayFragment())//удалить
                .commit()//удалить
        }//удалить

    }//удалить

        // Метод для перехода к AsteroidsByDateFragment
    fun showAsteroidsByDateFragment() {//удалить
        supportFragmentManager.beginTransaction()//удалить
            .replace(R.id.container, AsteroidsByDateFragment())//удалить
            .addToBackStack(null) // Добавляем в стек для возврата назад//удалить
            .commit()//удалить
    }
}



//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    private var binding: ActivityMainBinding? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding?.root)
//
//        // Настройка NavHostFragment для навигации между фрагментами.
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
//        navHostFragment?.navController?.setGraph(R.navigation.main_nav_graph)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null
//    }
//}