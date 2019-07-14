package alayacare.testapp.Persistence;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.Database.NoteRepository;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<NoteModel>> noteList;

    public NoteViewModel(Application application) {
        super(application);
        repository = new NoteRepository(application);
        noteList = repository.getAllNotes();
    }

    public LiveData<List<NoteModel>> getAllNotes() {
        return noteList;
    }

    public void insert(NoteModel note) {
        repository.insert(note);
    }

    public void update(NoteModel note) {
        repository.update(note);
    }

    public void delete(NoteModel note) {
        repository.delete(note);
    }
}
