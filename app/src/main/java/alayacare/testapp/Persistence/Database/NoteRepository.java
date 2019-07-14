package alayacare.testapp.Persistence.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

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

    /**
     * Given an already existing note, edit it asynchronously
     * @param note to be edited
     */
    public void update(NoteModel note) {
        new EditAsyncTask(noteDAO).execute(note);
    }

    private static class EditAsyncTask extends AsyncTask<NoteModel, Void, Void> {
        private NoteDAO mAsyncTaskDao;
        EditAsyncTask(NoteDAO dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final NoteModel... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }

    /**
     * Given an already existing note, delete it asynchronously
     * @param note to be edited
     */
    public void delete(NoteModel note) {
        new DeleteAsyncTask(noteDAO).execute(note);
    }

    private static class DeleteAsyncTask extends AsyncTask<NoteModel, Void, Void> {
        private NoteDAO mAsyncTaskDao;
        DeleteAsyncTask(NoteDAO dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final NoteModel... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }

}
