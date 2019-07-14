package alayacare.testapp.Controller.Alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;

public class DeleteAlert extends AlertDialog.Builder {

    public DeleteAlert(Context context, final NoteModel note, final NoteViewModel noteViewModel) {
        super(context);

        // Setup popup view
        setTitle("Delete Note");
        setMessage("Are you sure you want to delete this note? This operation is irreversible.");

        // Open confirmation popup to delete note
        setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                noteViewModel.delete(note);
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
