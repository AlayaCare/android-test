package alayacare.testapp.Controller;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;
import alayacare.testapp.R;

public class NoteActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    
    private ListView noteListView;
    private NoteItemAdapter noteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        // Setup list view and its adapter
        noteListView = findViewById(R.id.note_list);
        noteListAdapter = new NoteItemAdapter(this, R.layout.note_list_item);
        noteListView.setAdapter(noteListAdapter);

        // Observe live data change and update adapter
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<NoteModel>>() {
            @Override
            public void onChanged(List<NoteModel> noteModels) {
                noteListAdapter.setNotes(noteModels);
            }
        });
    }
}
