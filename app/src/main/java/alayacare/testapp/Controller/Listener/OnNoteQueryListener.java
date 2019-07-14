package alayacare.testapp.Controller.Listener;

import android.widget.SearchView;

import alayacare.testapp.Controller.Adapter.NoteItemAdapter;

public class OnNoteQueryListener implements SearchView.OnQueryTextListener {

    private NoteItemAdapter adapter;

    public OnNoteQueryListener(NoteItemAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        // Filter for results as text is inputted
        adapter.getFilter().filter(s);
        return true;
    }
}
