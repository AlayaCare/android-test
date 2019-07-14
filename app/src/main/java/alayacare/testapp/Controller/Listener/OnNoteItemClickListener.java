package alayacare.testapp.Controller.Listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import alayacare.testapp.Controller.Adapter.NoteItemAdapter;
import alayacare.testapp.Controller.Alert.EditAlert;
import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;

public class OnNoteItemClickListener implements AdapterView.OnItemClickListener {

    private Context context;
    private NoteItemAdapter adapter;
    private NoteViewModel noteViewModel;

    public OnNoteItemClickListener(Context context, NoteItemAdapter adapter, NoteViewModel noteViewModel) {
        this.context = context;
        this.adapter = adapter;
        this.noteViewModel = noteViewModel;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        NoteModel note = adapter.getNoteList().get(i);
        if(note != null) {
            EditAlert editAlert = new EditAlert(context, note, noteViewModel);
            editAlert.show();
        }
    }
}
