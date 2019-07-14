package alayacare.testapp.Controller.Listener;

import android.content.Context;
import android.view.View;

import alayacare.testapp.Controller.Alert.CreateAlert;
import alayacare.testapp.Persistence.NoteViewModel;

public class OnAddNoteClickListener implements View.OnClickListener {

    private Context context;
    private NoteViewModel noteViewModel;

    public OnAddNoteClickListener(Context context, NoteViewModel noteViewModel) {
        this.context = context;
        this.noteViewModel = noteViewModel;
    }

    @Override
    public void onClick(View view) {
        CreateAlert createAlert = new CreateAlert(context, noteViewModel);
        createAlert.show();
    }
}
