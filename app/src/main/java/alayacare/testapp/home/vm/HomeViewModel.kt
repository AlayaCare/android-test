package alayacare.testapp.home.vm

import alayacare.testapp.base.BaseViewModel
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class HomeViewModel(private val repository: NoteRepository): BaseViewModel(){

    val notes = MutableLiveData<List<Note>>()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    fun getNotesAsync() = viewModelScope.async(Dispatchers.Main) {
        loadingVisibility.value = GONE
        Thread.sleep(1000)
        notes.postValue(repository.getAll())
        loadingVisibility.value = VISIBLE
    }
}