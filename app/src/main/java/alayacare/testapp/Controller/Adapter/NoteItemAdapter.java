package alayacare.testapp.Controller.Adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;
import java.util.List;

import alayacare.testapp.Model.NoteModel;
import alayacare.testapp.R;

public class NoteItemAdapter extends ArrayAdapter<NoteModel> {

    private Context context;
    private List<NoteModel> originalNoteList;
    private List<NoteModel> noteList;

    public NoteItemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_list_item, parent, false);
            holder.noteText = convertView.findViewById(R.id.note_text);
            holder.noteDate = convertView.findViewById(R.id.note_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NoteModel note = noteList.get(position);
        holder.noteText.setText(note.getText());

        Date date = note.getDate();
        DateFormat format = new DateFormat();
        String formatDate = format.format(context.getString(R.string.date_format), date).toString();
        holder.noteDate.setText(formatDate);

        return convertView;
    }

    @Override
    public int getCount() {
        if (noteList != null)
            return noteList.size();
        else return 0;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new NoteAdapterFilter(this);
    }

    /**
     * Updates adapter note list to a new one
     * @param noteList new note list
     */
    public void setNotes(List<NoteModel> noteList) {
        this.noteList = noteList;
        this.originalNoteList = noteList;
        notifyDataSetChanged();
    }

    public List<NoteModel> getOriginalNoteList() {
        return originalNoteList;
    }

    public List<NoteModel> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<NoteModel> noteList) {
        this.noteList = noteList;
    }

    private class ViewHolder {
        TextView noteText;
        TextView noteDate;
    }
}
