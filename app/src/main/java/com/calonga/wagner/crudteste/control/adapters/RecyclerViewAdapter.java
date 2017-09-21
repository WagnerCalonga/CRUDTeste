package com.calonga.wagner.crudteste.control.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.calonga.wagner.crudteste.R;
import com.calonga.wagner.crudteste.control.data.Contrato;

/**
 * Created by Wagner on 20/09/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private final CursorAdapter mCursorAdapter;
    private final Context context;
    private RecyclerOnClickListener recyclerOnClickListener;

    public interface RecyclerOnClickListener {
        public void recyclerOnclick(View v, int position);
    }

    public RecyclerViewAdapter(Context context, Cursor cursor, RecyclerOnClickListener recyclerOnClickListener) {
        this.context = context;
        this.recyclerOnClickListener = recyclerOnClickListener;
        mCursorAdapter = new CursorAdapter(context, cursor, 0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                View view = LayoutInflater.from(context).inflate(R.layout.recycler_main_adapter, parent, false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

               // RecyclerViewHolder holder = (RecyclerViewHolder) view.getTag();

         //       holder.nome.setText("teste");



         /*   try{
                int columnIndexId = cursor.getColumnIndex(Contrato.Entry._ID);
                int columnIndexNome = cursor.getColumnIndex(Contrato.Entry.NOME);
                int columnIndexDescricao = cursor.getColumnIndex(Contrato.Entry.DESCRICAO);
                int columnIndexIdade = cursor.getColumnIndex(Contrato.Entry.IDADE);

                while (cursor.moveToNext()){
                    int correntId = cursor.getInt(columnIndexId);
                    String correntName = cursor.getString(columnIndexNome);
                    String correntDescricao = cursor.getString(columnIndexDescricao);
                    String correntIdade = cursor.getString(columnIndexIdade);
                }

            } finally {
                cursor.close();
            }*/
            }
        };

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mCursorAdapter.newView(context, mCursorAdapter.getCursor(), parent);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        mCursorAdapter.getCursor().moveToPosition(position);
        mCursorAdapter.bindView(holder.itemView, context, mCursorAdapter.getCursor());


        int columnIndexNome = mCursorAdapter.getCursor().getColumnIndex(Contrato.Entry.NOME);
        holder.nome.setText(mCursorAdapter.getCursor().getString(columnIndexNome));

        int columnIndexDescricao = mCursorAdapter.getCursor().getColumnIndex(Contrato.Entry.DESCRICAO);
        holder.descricao.setText(mCursorAdapter.getCursor().getString(columnIndexDescricao));

    }



    @Override
    public int getItemCount() {
        return mCursorAdapter.getCount();
    }

    public static class  RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView descricao;
        ImageView img;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNomeCRUD);
            descricao = itemView.findViewById(R.id.txtDescricaoCRUD);
            img = itemView.findViewById(R.id.imgCRUD);

        }
    }
}
