package alayacare.testapp.Persistence.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Util.DateConverter;

@Database(entities = {NoteModel.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDAO noteDAO();
    private static NoteDatabase INSTANCE;

    static NoteDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDatabase.class, "note_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
