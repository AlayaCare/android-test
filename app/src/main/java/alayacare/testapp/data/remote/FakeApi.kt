package alayacare.testapp.data.remote

import alayacare.testapp.data.model.Note
import java.util.*

internal class FakeApi{
    fun getAll(): List<Note> {
        val fakeNotes = ArrayList<Note>()
        (1..5).map {
            fakeNotes.add(
                    Note(
                            time =  Calendar.getInstance().time,
                            text = Note.randomText
                    )
            )
        }
        return fakeNotes
    }
}