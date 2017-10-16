package sonhoang.vn.notebook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String NOTE_KEY = "note_key";
    public static final String MODE_EDIT = "mode_edit";
    private FloatingActionButton fbAddButton;
    private ListView lvNoteList;
    private List<NoteContent> noteContentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void addListeners() {
        fbAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TakeNote.class);
                startActivity(intent);
            }
        });

        lvNoteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TakeNote.class);
                intent.putExtra(NOTE_KEY, noteContentList.get(position));
                intent.putExtra(MODE_EDIT, true);
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        fbAddButton = (FloatingActionButton) findViewById(R.id.fb_add_button);
        lvNoteList = (ListView) findViewById(R.id.lv_note_list);
        noteContentList = DatabaseHandle.getInstance(this).getNoteList();
        NoteAdapter noteAdapter = new NoteAdapter(
                this,
                R.layout.note_view,
                noteContentList
        );
        lvNoteList.setAdapter(noteAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupUI();
        addListeners();
    }
}
