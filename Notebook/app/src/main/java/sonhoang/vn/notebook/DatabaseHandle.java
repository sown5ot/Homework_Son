package sonhoang.vn.notebook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class DatabaseHandle {
    private static final String TAG = DatabaseHandle.class.toString();
    private OpenHelper openHelper;
    private SQLiteDatabase sqLiteDatabase;

    private DatabaseHandle(Context context) {
        openHelper = new OpenHelper(context);
    }

    private static DatabaseHandle databaseHandle;

    public static DatabaseHandle getInstance(Context context){
        if (databaseHandle == null) {
            return databaseHandle = new DatabaseHandle(context);
        } else {
            return databaseHandle;
        }
    }

    public List<NoteContent> getNoteList(){
        List<NoteContent> noteContents = new ArrayList<>();
        sqLiteDatabase = openHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from tbl_note order by id desc", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            //get data
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String content = cursor.getString(2);

            Log.d(TAG, "getNoteList: " + title.toString());

            NoteContent noteContent = new NoteContent(id, title, content);
            noteContents.add(noteContent);

            //move next
            cursor.moveToNext();
        }

        Log.d(TAG, "getListStory: " + noteContents.size());
        return noteContents;
    }

    public void saveNote(String title, String content){
        sqLiteDatabase = openHelper.getWritableDatabase();
        String insertQuery = "insert into tbl_note(title, content) values ('" + title + "', '"+ content + "')";
        sqLiteDatabase.execSQL(insertQuery);
        Log.d(TAG, "saveNote: saved");
    }

    public void deleteNote(String title){
        sqLiteDatabase = openHelper.getWritableDatabase();
        String deleteQuery = "delete from tbl_note where title = '" + title + "'";
        sqLiteDatabase.execSQL(deleteQuery);
        Log.d(TAG, "deleteNote: deleted");
    }


    public void editNote(int id, String title, String content) {
        sqLiteDatabase = openHelper.getWritableDatabase();
        String editQuery = "update tbl_note set title = '" + title + "', content = '" + content +"' where id = " + id;
        sqLiteDatabase.execSQL(editQuery);
        Log.d(TAG, "editNote: edited");
    }
}
