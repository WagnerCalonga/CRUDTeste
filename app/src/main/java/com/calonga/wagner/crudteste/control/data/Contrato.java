package com.calonga.wagner.crudteste.control.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Wagner on 11/09/2017.
 */

public final class Contrato {
    private Contrato(){}

    public static final String CONTENT_AUTHOTITY = "com.testecrud";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHOTITY);
    public static final String PATCH_TESTECRUD = Entry.NOME_TABELA;
    public static final String PATCH_TESTECRUD_ID = PATCH_TESTECRUD + "/#";


    public static class Entry implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath( BASE_CONTENT_URI,PATCH_TESTECRUD);

        public static final String _ID = BaseColumns._ID;
        public static final String NOME_TABELA = "testeCRUD";
        public static final String NOME = "nome";
        public static final String DESCRICAO = "descricao";
        public static final String IDADE = "idade";

    }
}
