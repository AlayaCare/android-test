package alayacare.testapp.data.local.dao

import alayacare.testapp.data.model.Note
import androidx.room.*

@Dao
abstract class NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(notes: List<Note>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(note: Note)

    @Query("SELECT id, time, text FROM notes ORDER BY id desc")
    abstract fun getAll(): List<Note>

    @Query("SELECT id, time, text FROM notes WHERE text like :str ORDER BY id desc")
    abstract fun search(str:String): List<Note>

    @Delete
    abstract fun delete(note:Note)
}