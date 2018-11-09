package alayacare.testapp.data.repository

import alayacare.testapp.data.mock.MockNotes
import alayacare.testapp.data.model.Note
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object NoteRepository {

    // The delay is to create an asynchronous effect
    fun getNotes(): Observable<ArrayList<Note>> = Observable.just(MockNotes.notesList).delay(10, TimeUnit.SECONDS)
}