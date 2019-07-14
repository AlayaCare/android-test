package alayacare.testapp.Persistence.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.Database.Task.DeleteAsyncTask;
import alayacare.testapp.Persistence.Database.Task.EditAsyncTask;
import alayacare.testapp.Persistence.Database.Task.InsertAsyncTask;

public class NoteRepository {

    private NoteDAO noteDAO;
    private LiveData<List<NoteModel>> noteList;

    public NoteRepository(Application application) {
        NoteDatabase db = NoteDatabase.getDatabase(application);
        noteDAO = db.noteDAO();
        noteList = noteDAO.getAllNotes();
    }

    public LiveData<List<NoteModel>> getAllNotes() {
        return noteList;
    }

    /**
     * Given a new note, insert it asynchronously to note database
     * @param note to be inserted
     */
    public void insert(NoteModel note) {
        new InsertAsyncTask(noteDAO).execute(note);
    }

    /**
     * Given an already existing note, edit it asynchronously
     * @param note to be edited
     */
    public void update(NoteModel note) {
        new EditAsyncTask(noteDAO).execute(note);
    }

    /**
     * Given an already existing note, delete it asynchronously
     * @param note to be edited
     */
    public void delete(NoteModel note) {
        new DeleteAsyncTask(noteDAO).execute(note);
    }



}
