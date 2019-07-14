package alayacare.testapp.Controller.Alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;

public class CreateAlert extends AlertDialog.Builder {

    public CreateAlert(Context context, final NoteViewModel noteViewModel) {
        super(context);

        // Setup popup view
        setTitle("Create New Note");
        final EditText input = new EditText(context);
        setView(input);

        // Create new note when user finishes editing
        setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String noteText =  input.getText().toString();
                if (!noteText.equals("")) {
                    NoteModel note = new NoteModel(noteText);
                    noteViewModel.insert(note);
                }
            }
        });

        // Cancel operation and close popup
        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
}
