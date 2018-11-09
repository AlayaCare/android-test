package alayacare.testapp.data.mock

import alayacare.testapp.data.model.Note
import java.util.Date

/**
 * Singleton MockNotes to hold Notes data in memory
 * (purely for task 1 and prepare the structure of the app,
 * should not be use for more than testing purpose)
 */
object MockNotes {

    var notesList = ArrayList<Note>()

    init {
        notesList.add(Note("Note 1", Date().time))
        notesList.add(Note("Note 2", Date().time))
        notesList.add(Note("Note 3", Date().time))
        notesList.add(Note("Note 4", Date().time))
        notesList.add(Note("Note 5", Date().time))
        notesList.add(Note("Note 6", Date().time))
    }

}