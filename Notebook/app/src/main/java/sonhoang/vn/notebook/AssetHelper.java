package sonhoang.vn.notebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Son Hoang on 10/10/2017.
 */

public class AssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "note_list.db";
    private static final int DATABASE_VERSION = 1;

    public AssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
