package alayacare.testapp.data.database

import alayacare.testapp.data.model.Note
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAll(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note): Long

    @Query("SELECT * FROM notes WHERE note LIKE '%' || :text || '%'")
    fun find(text: String): List<Note>

}