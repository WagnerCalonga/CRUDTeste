package com.calonga.wagner.crudteste.control.activitys;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.calonga.wagner.crudteste.R;
import com.calonga.wagner.crudteste.control.adapters.RecyclerViewAdapter;
import com.calonga.wagner.crudteste.control.data.Contrato;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.lista);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        String[] projecao = new String[]{Contrato.Entry._ID,Contrato.Entry.NOME,Contrato.Entry.DESCRICAO,Contrato.Entry.IDADE};
        Cursor cursor = getContentResolver().query(Contrato.Entry.CONTENT_URI,projecao,null,null,null);

        recyclerViewAdapter = new RecyclerViewAdapter(this, cursor, recyclerOnClickListener());
        recyclerView.setAdapter(recyclerViewAdapter);



        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
                Toast.makeText(MainActivity.this, " BtnInsert Clicacado", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnQuery = findViewById(R.id.btnQuery);
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
                Toast.makeText(MainActivity.this, "Btn Consulta Clicado", Toast.LENGTH_SHORT).show();
            }
        });


    }

    RecyclerViewAdapter.RecyclerOnClickListener recyclerOnClickListener() {
        return new RecyclerViewAdapter.RecyclerOnClickListener() {
            @Override
            public void recyclerOnclick(View v, int position) {

            }
        };
    }


    private void insert() {

        ContentValues values = new ContentValues();
        values.put(Contrato.Entry.NOME, "TesteContentProvider");
        values.put(Contrato.Entry.DESCRICAO, "Sera?");
        values.put(Contrato.Entry.IDADE, "01");

        getContentResolver().insert(Contrato.Entry.CONTENT_URI, values);

        // insert(Contrato.Entry.NOME_TABELA, null, values);


    }

    private void query(){
        //SQLiteDatabase db = dataBase.getReadableDatabase();

        String[] projecao = new String[]{Contrato.Entry._ID,Contrato.Entry.NOME,Contrato.Entry.DESCRICAO,Contrato.Entry.IDADE};
        String selection = Contrato.Entry.NOME + "=?";
        String[] selectionArgs = new String[] {"Rafael"};

        Cursor cursor = getContentResolver().query(Contrato.Entry.CONTENT_URI,projecao,null,null,null);
        try {
/*
            TextView displayView = findViewById(R.id.textMain);
            displayView.setText("Cursor: " + cursor.getCount() + " Mascotes: \n\n");
            displayView.append(Contrato.Entry._ID + " - " +
                    Contrato.Entry.NOME + " - " +
                    Contrato.Entry.DESCRICAO + " - " +
                    Contrato.Entry.IDADE + " - " );
*/
            int columnIndexId = cursor.getColumnIndex(Contrato.Entry._ID);
            int columnIndexNome = cursor.getColumnIndex(Contrato.Entry.NOME);
            int columnIndexDescricao = cursor.getColumnIndex(Contrato.Entry.DESCRICAO);
            int columnIndexIdade = cursor.getColumnIndex(Contrato.Entry.IDADE);

            while (cursor.moveToNext()){
                int correntId = cursor.getInt(columnIndexId);
                String correntName = cursor.getString(columnIndexNome);
                String correntDescricao = cursor.getString(columnIndexDescricao);
                String correntIdade = cursor.getString(columnIndexIdade);


  //              displayView.append( "\n" + correntId + " - " + correntName + " - " + " - " +
  //                      correntDescricao + " - " + correntIdade );

            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }

    }

}
