package sonhoang.vn.notebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class OpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "note_list.db";
    private static final int DATABASE_VERSION = 1;

    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
