package sonhoang.vn.notebook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class DatabaseHandle {
    private static final String TAG = DatabaseHandle.class.toString();
    private AssetHelper assetHelper;
    private SQLiteDatabase sqLiteDatabase;

    private DatabaseHandle(Context context) {
        assetHelper = new AssetHelper(context);
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
        sqLiteDatabase = assetHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from tbl_note", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            //get data
            String title = cursor.getString(1);
            String content = cursor.getString(2);

            Log.d(TAG, "getNoteList: " + title.toString());

            NoteContent noteContent = new NoteContent(title, content);
            noteContents.add(noteContent);

            //move next
            cursor.moveToNext();
        }

        Log.d(TAG, "getListStory: " + noteContents.size());
        return noteContents;
    }

    public void saveNote(String title, String content){
        sqLiteDatabase = assetHelper.getWritableDatabase();
        String insertQuery = "insert into tbl_note(title, content) values ('" + title + "', '"+ content + "')";
        sqLiteDatabase.execSQL(insertQuery);
        Log.d(TAG, "saveNote: saved");
    }
}
