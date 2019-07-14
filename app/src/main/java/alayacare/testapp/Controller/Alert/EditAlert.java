package alayacare.testapp.Controller.Alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;

public class EditAlert extends AlertDialog.Builder {

    public EditAlert(final Context context, final NoteModel note, final NoteViewModel noteViewModel) {
        super(context);

        // Setup popup view
        setTitle("Update Note");
        final EditText input = new EditText(context);
        input.setText(note.getText());
        setView(input);

        // Save note when user finish editing
        setPositiveButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String noteText =  input.getText().toString();
                if (!noteText.equals("")) {
                    note.setText(noteText);
                    noteViewModel.update(note);
                }
            }
        });

        // Open confirmation popup to delete note
        setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DeleteAlert deleteAlert = new DeleteAlert(context, note, noteViewModel);
                deleteAlert.show();
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
