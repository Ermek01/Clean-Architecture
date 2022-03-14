package kg.smartpost.cleanarchitecture.presentation.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kg.smartpost.cleanarchitecture.data.network.CoroutineDispatcherProvider
import kg.smartpost.cleanarchitecture.domain.students.model.Students
import kg.smartpost.cleanarchitecture.domain.students.usecase.GetStudents
import kg.smartpost.cleanarchitecture.util.ExceptionParser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getStudents: GetStudents,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow<PrayUiState>(PrayUiState.Empty)
    val uiState: StateFlow<PrayUiState> = _uiState

    fun getStudents() {
        _uiState.value = PrayUiState.Loading

        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            try {
//                val city = "Jakarta"
//                val requestParam = PrayScheduleRequest(city, getTodayDate())
                val result = getStudents.execute()
                _uiState.value = PrayUiState.Loaded(result)
            } catch (error: Exception) {
                _uiState.value = PrayUiState.Error(ExceptionParser.getMessage(context, error))
            }
        }
    }

   //private fun getTodayDate() = TimeUtil.getDateFormatted(Date())

    sealed class PrayUiState {
        object Empty : PrayUiState()
        object Loading : PrayUiState()
        class Loaded(val students: List<Students>) : PrayUiState()
        class Error(val message: String) : PrayUiState()
    }
}