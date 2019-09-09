package alayacare.testapp.data.repository

import alayacare.testapp.data.model.Note
import alayacare.testapp.data.remote.NoteRemoteDataSource

class NoteRepository(private val noteDataSource: NoteRemoteDataSource) {
    fun getAll(): List<Note> = noteDataSource.fetchNotesAsync()
}