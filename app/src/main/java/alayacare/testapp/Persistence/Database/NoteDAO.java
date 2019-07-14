package alayacare.testapp.Persistence.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import alayacare.testapp.Model.NoteModel;

@Dao
public interface NoteDAO {

    @Insert
    void insert(NoteModel note);

    @Update
    void update(NoteModel note);

    @Delete
    void delete(NoteModel note);

    @Query("SELECT * from note_table ORDER BY date DESC")
    LiveData<List<NoteModel>> getAllNotes();
}
