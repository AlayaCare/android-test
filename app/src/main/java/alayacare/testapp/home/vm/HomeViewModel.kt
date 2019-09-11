package alayacare.testapp.home.vm

import alayacare.testapp.base.BaseViewModel
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class HomeViewModel(private val repository: NoteRepository) : BaseViewModel() {

    val notes = MutableLiveData<List<Note>>()

    fun loadNotes(addMore: Boolean = false) = viewModelScope.launch(Dispatchers.IO) {
        if (notes.value.isNullOrEmpty() || addMore)
            repository.addRandomNotes()

        notes.postValue(repository.getAll())
    }
}