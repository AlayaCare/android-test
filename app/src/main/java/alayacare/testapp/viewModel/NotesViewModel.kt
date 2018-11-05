package alayacare.testapp.viewModel

import alayacare.testapp.Model.NoteModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NotesViewModel : ViewModel() {

    private var notesList: MutableLiveData<List<NoteModel>> = MutableLiveData()

    fun getNotesList() : LiveData<List<NoteModel>>{
        loadNotes()
        return notesList
    }
    fun loadNotes() {
        val notes = arrayListOf<NoteModel>()
        notes.add(NoteModel("This is the first note"))
        notes.add(NoteModel("This is the second note"))
        notes.add(NoteModel("This is the third note"))
        notes.add(NoteModel("Thsi is the fourth note"))
        notes.add(NoteModel("This is the fifth note"))

        notesList.postValue(notes)
    }
}
