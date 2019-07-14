package alayacare.testapp.Controller.Alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;
import alayacare.testapp.R;

public class EditAlert extends AlertDialog.Builder {

    public EditAlert(final Context context, final NoteModel note, final NoteViewModel noteViewModel) {
        super(context);

        // Setup popup view
        setTitle(context.getString(R.string.update_note_title));
        final EditText input = new EditText(context);
        input.setText(note.getText());
        setView(input);

        // Save note when user finish editing
        setPositiveButton(context.getString(R.string.edit), new DialogInterface.OnClickListener() {
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
        setNeutralButton(context.getString(R.string.delete), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DeleteAlert deleteAlert = new DeleteAlert(context, note, noteViewModel);
                deleteAlert.show();
            }
        });

        // Cancel operation and close popup
        setNegativeButton(context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

    }
}
