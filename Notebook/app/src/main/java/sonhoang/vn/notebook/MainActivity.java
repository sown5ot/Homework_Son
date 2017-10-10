package sonhoang.vn.notebook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fbAddButton;
    private ListView lvNoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        addListeners();
    }

    private void addListeners() {
        fbAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TakeNote.class);
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        fbAddButton = (FloatingActionButton) findViewById(R.id.fb_add_button);
        lvNoteList = (ListView) findViewById(R.id.lv_note_list);
        NoteAdapter noteAdapter = new NoteAdapter(
                this,
                R.layout.note_view,
                DatabaseHandle.getInstance(this).getNoteList()
        );
        lvNoteList.setAdapter(noteAdapter);
    }
}
