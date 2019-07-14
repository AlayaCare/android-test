package alayacare.testapp.Persistence;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import alayacare.testapp.Model.NoteModel;

public class NoteRepository {

    private LiveData<List<NoteModel>> noteList;

    public NoteRepository() {
        noteList = createMockData();
    }

    public LiveData<List<NoteModel>> getAllNotes() {
        return noteList;
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
}
