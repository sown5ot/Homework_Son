package sonhoang.vn.notebook;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class NoteAdapter extends ArrayAdapter<NoteContent> {
    private Context context;
    private int resource;
    private List<NoteContent> noteContents;

    public NoteAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<NoteContent> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.noteContents = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        TextView tvNoteTitle = (TextView) convertView.findViewById(R.id.tv_note_title);
        TextView tvNoteContent = (TextView) convertView.findViewById(R.id.tv_note_content);

        tvNoteTitle.setText(noteContents.get(position).getNoteTitle());
        tvNoteContent.setText(noteContents.get(position).getNoteContent());
        return convertView;
    }
}
