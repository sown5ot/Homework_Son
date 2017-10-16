package sonhoang.vn.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class TakeNote extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivCheck;
    private EditText etNoteTitle;
    private EditText etNoteContent;
    private ImageView ivDelete;
    private ImageView ivBack;
    private NoteContent noteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_note);

        setupUI();
        addListeners();
        loadData();
    }

    private void loadData() {
        if (getIntent().getBooleanExtra(MainActivity.MODE_EDIT, false)){
            noteContent = (NoteContent) getIntent().getSerializableExtra(MainActivity.NOTE_KEY);
            etNoteTitle.setText(noteContent.getNoteTitle());
            etNoteContent.setText(noteContent.getNoteContent());
        }
    }

    private void addListeners() {
        ivCheck.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ivDelete.setOnClickListener(this);
    }

    private void deleteNote() {
        DatabaseHandle.getInstance(this).deleteNote(noteContent.getNoteTitle());
        this.finish();
    }

    private void saveNote() {
        String title = etNoteTitle.getText().toString();
        String content = etNoteContent.getText().toString();
        DatabaseHandle.getInstance(this).saveNote(title, content);
    }

    private void setupUI() {
        ivCheck = (ImageView) findViewById(R.id.iv_check);
        etNoteTitle = (EditText) findViewById(R.id.et_note_title);
        etNoteContent = (EditText) findViewById(R.id.et_note_content);
        ivDelete = (ImageView) findViewById(R.id.iv_delete);
        ivBack = (ImageView) findViewById(R.id.iv_back);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_check: {
                if (getIntent().getBooleanExtra(MainActivity.MODE_EDIT, false)){
                    editNote();
                } else {
                    saveNote();
                }
                ivCheck.setClickable(false);

                Intent intent = new Intent(TakeNote.this, MainActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.iv_back: {
                super.onBackPressed();
            }

            case R.id.iv_delete: {
                deleteNote();
            }
        }
    }

    private void editNote(){
        int id = noteContent.getNoteId();
        String title = etNoteTitle.getText().toString();
        String content = etNoteContent.getText().toString();
        DatabaseHandle.getInstance(this).editNote(id, title, content);
    }
}
