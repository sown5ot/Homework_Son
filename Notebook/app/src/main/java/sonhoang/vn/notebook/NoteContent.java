package sonhoang.vn.notebook;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class NoteContent {
    private String noteTitle;
    private String noteContent;

    public NoteContent(String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
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
