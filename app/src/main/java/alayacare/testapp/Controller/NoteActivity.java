package alayacare.testapp.Controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;
import alayacare.testapp.R;

public class NoteActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    private NoteItemAdapter noteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //Setup button click
        FloatingActionButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddNotePopup();
            }
        });

        // Setup list view and its adapter
        ListView noteListView = findViewById(R.id.note_list);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Inflate search menu when opening NoteActivity
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // Setup search view and query when search button is clicked
        SearchView mSearchView = (SearchView) menu.findItem(R.id.search).getActionView();
        mSearchView.setQueryHint("Search notes...");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // Filter for results as text is inputted
                noteListAdapter.getFilter().filter(s);
                return true;
            }
        });
        return true;
    }

    /**
     * Open popup with a text field in order to add new notes when button is clicked
     */
    private void openAddNotePopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create New Note");
        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String noteText =  input.getText().toString();
                if (!noteText.equals("")) {
                    NoteModel note = new NoteModel(noteText);
                    noteViewModel.insert(note);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
