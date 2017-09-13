package com.calonga.wagner.crudteste.control.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wagner on 11/09/2017.
 */

public class SqlHelperDb extends SQLiteOpenHelper {
    private static final String NAME_DATABASE = "TesteCrud";
    private static final int VERSION_DATABASE = 1;

    /**
     * TODO: = Anáisar o factory e para que serve
     * @param context
     */
    public SqlHelperDb(Context context){
        super(context, NAME_DATABASE, null,VERSION_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
