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

    private final static String CREATE_TABLE = "CREATE TABLE ";
    private final static String DROP_TABLE = "DROP TABLE IF EXISTS ";
    private final static String PRIMAY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT, ";
    private final static String TIPO_TEXTO = " TEXT";
    private final static String VIRGULA = ",";
    private final static String FIM_SCRIPT = " )";
    private final static String CRIAR_TABELA_TesteCRUD = CREATE_TABLE + Contrato.Entry.NOME_TABELA + " (" + Contrato.Entry._ID +
            PRIMAY_KEY +
            Contrato.Entry.NOME  + TIPO_TEXTO + VIRGULA +
            Contrato.Entry.DESCRICAO + TIPO_TEXTO + VIRGULA +
            Contrato.Entry. IDADE + TIPO_TEXTO + FIM_SCRIPT;

    private final static  String EXCLUIR_TABELA_TesteCRUD = DROP_TABLE + Contrato.Entry.NOME_TABELA;



    /**
     * TODO: = Anáisar o factory e para que serve
     * @param context
     */
    public SqlHelperDb(Context context){
        super(context, NAME_DATABASE, null,VERSION_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        /*
         String TEXT_TYPE = " TEXT";
         String COMMA_SEP = ",";
         String SQL_CREATE_ENTRIES = "CREATE TABLE " + Contrato.Entry.NOME_TABELA + " (" + Contrato.Entry._ID + " INTEGER PRIMARY KEY," +
                Contrato.Entry.NOME + TEXT_TYPE + COMMA_SEP +
                Contrato.Entry.DESCRICAO + TEXT_TYPE + " )";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

*/

        sqLiteDatabase.execSQL(CRIAR_TABELA_TesteCRUD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
