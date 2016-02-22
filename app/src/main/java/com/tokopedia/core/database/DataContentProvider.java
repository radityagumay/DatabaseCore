package com.tokopedia.core.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.tokopedia.core.database.table.ProductTable;

/**
 * Created by raditya.gumay on 22/02/2016.
 */
public class DataContentProvider extends ContentProvider {

    private DatabaseHelper helper;

    /**
     * URI_MATCHER
     */
    private static final int PRODUCT = 1;
    private static final int PRODUCT_ITEM = 10;

    private static final String AUTHORITY = "com.tokopedia.core.database";

    private static final String BASE_PATH = DatabaseHelper.DATABASE_NAME + "/";

    private static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final Uri PRODUCT_URI = Uri.withAppendedPath(CONTENT_URI, BASE_PATH + ProductTable.NAME);

    public static final String PRODUCT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + BASE_PATH;
    public static final String PRODUCT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + ProductTable.NAME;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, BASE_PATH, PRODUCT);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", PRODUCT_ITEM);
    }

    @Override
    public boolean onCreate() {
        helper = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = helper.getWritableDatabase();
        long id = 0;
        switch (uriType) {
            case PRODUCT:
                id = sqlDB.insert(ProductTable.NAME, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
