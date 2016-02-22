package com.tokopedia.core.table;

/**
 * Created by raditya.gumay on 22/02/2016.
 * @link http://www.vogella.com/tutorials/AndroidSQLite/article.html
 */
public class ProductTable {

    public static final String NAME = "product";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMAGE_URL = "imageUrl";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";

    // TODO this column, include shop.name or countProduct
    public static final String COLUMN_FOTTER = "fotter";

    public static void onCreate(){

    }
}
