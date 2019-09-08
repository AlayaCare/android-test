package alayacare.testapp.data.local.dao

import alayacare.testapp.data.model.Note
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class NoteDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(notes: List<Note>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(note: Note)

    @Query("SELECT * FROM Note ORDER BY time DESC")
    abstract suspend fun getAll(): List<Note>
}