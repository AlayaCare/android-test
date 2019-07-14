package alayacare.testapp.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "note_table")
public class NoteModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String text;
    private Date date;

    public NoteModel(@NonNull String text) {
        this.text = text;
        this.date = new Date();
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
