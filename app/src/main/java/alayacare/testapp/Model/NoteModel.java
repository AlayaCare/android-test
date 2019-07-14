package alayacare.testapp.Model;

import java.util.Date;

public class NoteModel {

    private String text;
    private Date date;

    public NoteModel(String text) {
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }
}
