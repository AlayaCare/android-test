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

    fun loadNotes() = viewModelScope.launch(Dispatchers.IO) {
        val items = repository.getAll()
        when {
            (items.isEmpty()) -> {
                // add some fake rows in case the db is empty
                repository.addRandomNotes()
                notes.postValue(repository.getAll())
            }
            else -> notes.postValue(items)
        }
    }

    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNote(note)
        loadNotes()
    }

    fun removeNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.removeNote(note)
        loadNotes()
    }

    fun search(string: String) = viewModelScope.launch(Dispatchers.IO) {
        notes.postValue(repository.getAll(string))
    }

}