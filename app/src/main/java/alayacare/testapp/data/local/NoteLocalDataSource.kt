package alayacare.testapp.data.local

import alayacare.testapp.data.local.dao.NoteDao
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.model.Note.Companion.randomText
import android.util.Log
import java.util.*

class NoteLocalDataSource(private val dao: NoteDao) {

    fun getNotes(): List<Note> {
        return dao.getAll()
    }

    fun insertNewRandom() {
        try {
            (1..5).map {
                dao.insert(Note(
                        time =  Calendar.getInstance().time,
                        text = randomText))
            }
        } catch (e: Exception) {
            Log.e("Error", e.message)
        }
    }
}