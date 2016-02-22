package com.tokopedia.core.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.tokopedia.core.database.table.ProductTable;

/**
 * Created by raditya.gumay on 22/02/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = DatabaseHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "tokopedia";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ProductTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        ProductTable.onUpgrade(db, oldVersion, newVersion);
    }
}
