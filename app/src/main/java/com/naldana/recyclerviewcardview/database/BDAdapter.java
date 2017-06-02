package com.naldana.recyclerviewcardview.database;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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

import com.naldana.recyclerviewcardview.Adpater.CustomRecyclerViewAdapter;
import com.naldana.recyclerviewcardview.R;

import java.io.IOException;
import java.util.Random;

/**
 * Created by rober on 31/5/2017.
 */

public class BDAdapter extends CustomRecyclerViewAdapter {
    private Activity activity;
    private Cursor series;
    Random random = new Random();

    public BDAdapter(final Activity activity, final Cursor series) {
        this.activity = activity;
        this.series = series;
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                series.moveToPosition(position);
                Toast.makeText(activity,series.getString(1),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.serie_detail_b, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomRecycleViewHolder holder, final int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        series.moveToPosition(position);

        if(random.nextBoolean()) myHolder.poster.setImageResource(R.drawable.hora_de_aventura);
        else myHolder.poster.setImageResource(R.drawable.lost);
        myHolder.title.setText(series.getString(1));

        myHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                series.moveToPosition(position);
                Toast.makeText(myHolder.itemView.getContext(),"LIKE "+ series.getString(1), Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return series.getCount();
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

}
