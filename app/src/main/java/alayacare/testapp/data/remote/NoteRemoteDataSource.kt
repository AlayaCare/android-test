package alayacare.testapp.data.remote

import alayacare.testapp.data.model.Note

internal class NoteRemoteDataSource(private val api: FakeApi) {
    fun getNotes(): List<Note> {
        return api.getAll()
    }
}