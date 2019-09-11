package alayacare.testapp.data.repository

import alayacare.testapp.data.model.Note
import alayacare.testapp.data.local.NoteLocalDataSource
import alayacare.testapp.data.remote.NoteRemoteDataSource

internal class NoteRepository(
        private val noteDataSource: NoteLocalDataSource,
        private val noteRemoteDataSource: NoteRemoteDataSource) {
    fun getAll(): List<Note> = noteDataSource.getNotes()
    fun addRandomNotes() = noteDataSource.insertNewRandom()
    fun getFromFakeApi(): List<Note> = noteRemoteDataSource.getNotes()
}