package alayacare.testapp.Model

import java.text.SimpleDateFormat
import java.util.*

class NoteModel(var noteText: String?) {
    var date: String? = null

    init {
        val noteCreationDate = Date()
        val dateFormat = "hh:mm:ss a"
        val dateFormat1 = SimpleDateFormat(dateFormat)

        date = dateFormat1.format(noteCreationDate)
    }
}
