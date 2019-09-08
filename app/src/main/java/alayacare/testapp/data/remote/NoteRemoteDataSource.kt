package alayacare.testapp.data.remote

import alayacare.testapp.data.model.Note
import alayacare.testapp.ext.randomSecondsFromNow

class NoteRemoteDataSource{

    fun fetchNotesAsync(): List<Note> {
        val list = ArrayList<Note>()
        (1..50).map {list.add(Note(1000L.randomSecondsFromNow(), randomText(it))) }
        return list
    }

    private fun randomText(i:Int): String = "Note sample text. number $i"
}