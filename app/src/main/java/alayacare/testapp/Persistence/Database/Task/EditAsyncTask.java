package alayacare.testapp.Persistence.Database.Task;

import android.os.AsyncTask;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.Database.NoteDAO;

public class EditAsyncTask extends AsyncTask<NoteModel, Void, Void> {

    private NoteDAO dao;

    public EditAsyncTask(NoteDAO dao) {
        this.dao = dao;
    }

    @Override
    protected Void doInBackground(final NoteModel... params) {
        dao.update(params[0]);
        return null;
    }
}