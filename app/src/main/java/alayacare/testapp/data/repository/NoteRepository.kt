package alayacare.testapp.data.repository

import alayacare.testapp.data.model.Note
import alayacare.testapp.data.local.NoteLocalDataSource
import alayacare.testapp.data.remote.NoteRemoteDataSource

internal class NoteRepository(
        private val noteDataSource: NoteLocalDataSource,
        private val noteRemoteDataSource: NoteRemoteDataSource) {

    fun getAll(filter: String? = null): List<Note> = noteDataSource.getNotes(filter)

    fun addRandomNotes() = noteDataSource.insertNewRandom()

    fun addNote(note:Note) = noteDataSource.insertNote(note)

    fun removeNote(note:Note) = noteDataSource.removeNote(note)

    fun getFromFakeApi(): List<Note> = noteRemoteDataSource.getNotes()
}