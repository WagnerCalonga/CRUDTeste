package com.calonga.wagner.crudteste.control.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Wagner on 11/09/2017.
 */

public class ProvedorContent extends ContentProvider {


    private static final String LOG_TAG = ProvedorContent.class.getSimpleName();

    private static final int TESTECRUD = 10;
    private static final int TESTECRUD_ID = 20;

    private static UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(Contrato.CONTENT_AUTHOTITY,Contrato.PATCH_TESTECRUD,TESTECRUD);
        sURIMatcher.addURI(Contrato.CONTENT_AUTHOTITY,Contrato.PATCH_TESTECRUD_ID,TESTECRUD_ID);
    }

    private SqlHelperDb db;

    @Override
    public boolean onCreate() {
        db = new SqlHelperDb(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = null;
        final int match = sURIMatcher.match(uri);

        switch (match){
            case TESTECRUD:
                cursor = database.query(Contrato.Entry.NOME_TABELA,projection,selection,selectionArgs,null,null,sortOrder );
                break;
            case TESTECRUD_ID:
                projection = new String[]{Contrato.Entry._ID,Contrato.Entry.NOME,Contrato.Entry.DESCRICAO,Contrato.Entry.IDADE};
                selection = Contrato.Entry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(Contrato.Entry.NOME_TABELA,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                Toast.makeText(getContext(), "UriMatcher nao encontrado", Toast.LENGTH_SHORT).show();
                break;

        }

        return cursor ;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sURIMatcher.match(uri);

        switch (match){
            case TESTECRUD:
                return inserir(uri,contentValues);

            default:
                throw new IllegalArgumentException("Erro na inserção" + uri);
        }

    }

    private Uri inserir(Uri uri, ContentValues values){
        SQLiteDatabase database = db.getWritableDatabase();

        long id = database.insert(Contrato.Entry.NOME_TABELA, null, values);
        if(id == -1){
            throw new IllegalArgumentException();
        }

        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
