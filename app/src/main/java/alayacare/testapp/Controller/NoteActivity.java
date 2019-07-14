package alayacare.testapp.Controller;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import alayacare.testapp.Controller.Adapter.NoteItemAdapter;
import alayacare.testapp.Controller.Listener.OnAddNoteClickListener;
import alayacare.testapp.Controller.Listener.OnNoteItemClickListener;
import alayacare.testapp.Controller.Listener.OnNoteQueryListener;
import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;
import alayacare.testapp.R;

public class NoteActivity extends AppCompatActivity {

    private NoteItemAdapter noteListAdapter;

    private Observer<List<NoteModel>> observer = new Observer<List<NoteModel>>() {
        @Override
        public void onChanged(List<NoteModel> noteModels) {
            noteListAdapter.setNotes(noteModels);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        // Observe live data change and update adapter
        NoteViewModel noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, observer);

        //When user clicks the add button, open create popup
        FloatingActionButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new OnAddNoteClickListener(this, noteViewModel));

        // Setup list view, its adapter and the click events for each item
        final ListView noteListView = findViewById(R.id.note_list);
        noteListAdapter = new NoteItemAdapter(this, R.layout.note_list_item);
        noteListView.setAdapter(noteListAdapter);
        noteListView.setOnItemClickListener(new OnNoteItemClickListener(this, noteListAdapter, noteViewModel));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Inflate search menu when opening NoteActivity
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // Setup search view and query when search button is clicked
        SearchView mSearchView = (SearchView) menu.findItem(R.id.search).getActionView();
        mSearchView.setQueryHint(getString(R.string.search_hint));
        mSearchView.setOnQueryTextListener(new OnNoteQueryListener(noteListAdapter));
        return true;
    }


}
