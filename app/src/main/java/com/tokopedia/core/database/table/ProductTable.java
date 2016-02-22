package com.tokopedia.core.database.table;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by raditya.gumay on 22/02/2016.
 * @link http://www.vogella.com/tutorials/AndroidSQLite/article.html
 */
public class ProductTable {

    public static final String TAG = ProductTable.class.getSimpleName();

    public static final String NAME = "product";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMAGE_URL = "imageUrl";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";

    // TODO this column, include shop.name or countProduct
    public static final String COLUMN_FOTTER = "fotter";

    public static final String CREATE_DATABASE = "CREATE TABLE "
            + NAME
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_IMAGE_URL + " text, "
            + COLUMN_NAME + " text, "
            + COLUMN_PRICE + " text, "
            + COLUMN_FOTTER + " text"
            + ");";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NAME);
        onCreate(db);
    }
}
