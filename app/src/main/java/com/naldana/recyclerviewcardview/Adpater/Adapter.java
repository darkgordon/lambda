package com.naldana.recyclerviewcardview.Adpater;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.naldana.recyclerviewcardview.Model.Serie;
import com.naldana.recyclerviewcardview.R;
import com.naldana.recyclerviewcardview.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nestor on 15/5/2017.
 */

public class Adapter extends CustomRecyclerViewAdapter {
    DataBaseHelper mdb;
    private Activity activity;
    private ArrayList<Serie> series;
    Context mcontext;
    private SQLiteDatabase mDb;
    public static final String TAG="RIPIO";





    //SQLiteDatabase database= hpb.getReadableDatabase();

    public Adapter(final Activity activity, final ArrayList<Serie> series) {
        this.activity = activity;
        this.series = series;
        //este lo trate para que la base abriera alli con un contexto pero nada suele sucerer


       //tratando
        //mdb.obtenerdatos();
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity,series.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.serie_detail_b, parent, false);
        Log.d(TAG, "onBindViewHolder:");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomRecycleViewHolder holder, final int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.poster.setImageResource(R.drawable.hora_de_aventura);
        myHolder.title.setText(series.get(position).getTitulo());
        Log.d(TAG, "onBindViewHolder:"+position);

        myHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myHolder.itemView.getContext(),"LIKE "+ series.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private ImageView poster;
        private TextView title;
        private LinearLayout linearLayout;
        private Button like;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.serie_poster_image_viewb);
            title = (TextView) itemView.findViewById(R.id.serie_titulo_text_viewb);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.cardViewSerieb);
            like = (Button) itemView.findViewById(R.id.buttonb);
        }
    }
    //meotodo para obtener datos de la base revisar posiblemente algo de aqui este malo, [refero dekjarlo aqui para que sea llamado por el
    //adapater
   /* public List obtenerdatos() {
        List<Serie> lista = null;
        Serie serie=null;
        String llenado = "SELECT titulo FROM series";
        Cursor cursor = mDb.rawQuery(llenado, null);
        lista = new ArrayList<Serie>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    lista.add(new Serie(cursor.getString(1)));

                } while (cursor.moveToNext());
            }
        }
        return lista;
    }
*/

        }



