package sonhoang.vn.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class TakeNote extends AppCompatActivity {
    private ImageView ivCheck;
    private EditText etNoteTitle;
    private EditText etNoteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_note);

        setupUI();
        addListeners();
    }

    private void addListeners() {
        ivCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
                ivCheck.setClickable(false);

                Intent intent = new Intent(TakeNote.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
    }
}
