package alayacare.testapp.ui.home

import alayacare.testapp.base.BaseViewModel
import alayacare.testapp.data.repository.NoteRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: NoteRepository): BaseViewModel(){

    private fun getNotesAsync() = viewModelScope.async(Dispatchers.Main) {
        Thread.sleep(1000)
        repository.getAll()
    }
}