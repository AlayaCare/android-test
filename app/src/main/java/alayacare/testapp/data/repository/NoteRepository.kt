package alayacare.testapp.data.repository

import alayacare.testapp.data.mock.MockNotes
import alayacare.testapp.data.model.Note
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object NoteRepository {

    fun addNote(note: Note) {
        MockNotes.addNote(note)
    }

    // The delay is to create an asynchronous effect
    fun getNotes(): Observable<ArrayList<Note>> = Observable.just(MockNotes.notesList).delay(1, TimeUnit.SECONDS)
}