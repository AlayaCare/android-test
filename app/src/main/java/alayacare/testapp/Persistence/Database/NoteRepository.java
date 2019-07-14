package alayacare.testapp.Persistence.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import alayacare.testapp.Model.NoteModel;

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
     * Creates a list of mock note list and sets it as the repository live data list
     * @return list of note model as a live data
     */
    private LiveData<List<NoteModel>> createMockData() {
        List<NoteModel> categories = new ArrayList<>();
        categories.add(new NoteModel("This is my first note."));
        categories.add(new NoteModel("This is my second note."));
        categories.add(new NoteModel("This is my third and final note."));
        MutableLiveData<List<NoteModel>> liveData = new MutableLiveData<>();
        liveData.setValue(categories);
        return liveData;
    }

    /**
     * Asynchronous task to insert new notes on the note list without locking the main thread
     */
    private static class InsertAsyncTask extends AsyncTask<NoteModel, Void, Void> {

        private NoteDAO mAsyncTaskDao;

        InsertAsyncTask(NoteDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final NoteModel... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
