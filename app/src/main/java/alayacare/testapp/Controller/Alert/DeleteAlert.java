package alayacare.testapp.Controller.Alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.Persistence.NoteViewModel;
import alayacare.testapp.R;

public class DeleteAlert extends AlertDialog.Builder {

    public DeleteAlert(Context context, final NoteModel note, final NoteViewModel noteViewModel) {
        super(context);

        // Setup popup view
        setTitle(context.getString(R.string.delete_note_title));
        setMessage(context.getString(R.string.delete_note_message));

        // Open confirmation popup to delete note
        setPositiveButton(context.getString(R.string.delete), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                noteViewModel.delete(note);
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
