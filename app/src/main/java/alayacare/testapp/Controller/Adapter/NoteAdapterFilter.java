package alayacare.testapp.Controller.Adapter;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import alayacare.testapp.Model.NoteModel;

public class NoteAdapterFilter extends Filter {

    private NoteItemAdapter adapter;

    public NoteAdapterFilter(NoteItemAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        // If search term is empty, return the original full list
        if (charSequence.equals("")) {
            results.values = adapter.getOriginalNoteList();
            results.count = adapter.getOriginalNoteList().size();
        }
        // Look in text for a match to the search term
        else {
            List<NoteModel> resultNotes = new ArrayList<>();
            for (NoteModel note : adapter.getOriginalNoteList()) {
                // Return all notes that contain searched term
                if(note.getText().contains(charSequence)) {
                    resultNotes.add(note);
                }
            }
            results.values = resultNotes;
            results.count = resultNotes.size();
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        // Return found values and notify adapter
        adapter.setNoteList((List<NoteModel>) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}
