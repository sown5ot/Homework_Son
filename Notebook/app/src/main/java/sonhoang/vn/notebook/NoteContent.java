package sonhoang.vn.notebook;

import java.io.Serializable;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class NoteContent implements Serializable {
    private String noteTitle;
    private String noteContent;
    private int noteId;

    public NoteContent(int id, String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteId = id;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @Override
    public String toString() {
        return "NoteContent{" +
                "noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                '}';
    }
}
