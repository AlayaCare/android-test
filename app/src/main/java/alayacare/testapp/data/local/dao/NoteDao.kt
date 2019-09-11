package alayacare.testapp.data.local.dao

import alayacare.testapp.data.model.Note
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(notes: List<Note>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(note: Note)

    @Query("SELECT id, time, text FROM notes ORDER BY id desc")
    abstract fun getAll(): List<Note>
}