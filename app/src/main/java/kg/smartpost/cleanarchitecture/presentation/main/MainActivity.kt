package kg.smartpost.cleanarchitecture.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kg.smartpost.cleanarchitecture.databinding.ActivityMainBinding
import kg.smartpost.cleanarchitecture.domain.students.model.Students
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeViewModel.getStudents()
        fetchPraySchedules()

    }

    private fun fetchPraySchedules() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.uiState.collect { state ->
                    when (state) {

                        is MainViewModel.PrayUiState.Loaded -> onLoaded(state.students)
                        is MainViewModel.PrayUiState.Error -> showError(state.message)
                        else -> showLoading()
                    }
                }
            }
        }
    }

    private fun onLoaded(state: List<Students>) {
        //Timber.d(state.toString())
        Log.d("students", state.size.toString())
        //Toast.makeText(this, state.toString(), Toast.LENGTH_SHORT).show()
    }


    private fun showLoading() {
        Timber.d("showLoading")
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}