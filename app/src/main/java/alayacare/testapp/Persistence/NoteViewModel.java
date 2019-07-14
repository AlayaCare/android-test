package alayacare.testapp.Persistence;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import alayacare.testapp.Model.NoteModel;

public class NoteViewModel extends ViewModel {

    private NoteRepository repository;
    private LiveData<List<NoteModel>> noteList;

    public NoteViewModel() {
        repository = new NoteRepository();
        noteList = repository.getAllNotes();
    }

    public LiveData<List<NoteModel>> getAllNotes() {
        return noteList;
    }
}
