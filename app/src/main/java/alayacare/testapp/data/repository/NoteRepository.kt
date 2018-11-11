package alayacare.testapp.data.repository

import alayacare.testapp.data.database.NoteDao
import alayacare.testapp.data.database.NoteDatabase
import alayacare.testapp.data.model.Note
import android.app.Application
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NoteRepository(application: Application) {

    private val noteDao: NoteDao

    init {
        val noteDatabase = NoteDatabase.getInstance(application)
        noteDao = noteDatabase.noteDao()
    }

    fun addNote(note: Note): Observable<Long> {
        return Observable.fromCallable<Long> { noteDao.insert(note) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getNotes(): Observable<List<Note>> {
        return Observable.fromCallable<List<Note>> { noteDao.getAll() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun searchNote(text: String): Observable<List<Note>> {
        return Observable.fromCallable<List<Note>> { noteDao.find(text) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}