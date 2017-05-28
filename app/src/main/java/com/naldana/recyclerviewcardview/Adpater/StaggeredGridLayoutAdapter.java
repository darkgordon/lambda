package com.naldana.recyclerviewcardview.Adpater;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.naldana.recyclerviewcardview.Model.Serie;
import com.naldana.recyclerviewcardview.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nestor on 15/5/2017.
 */

public class StaggeredGridLayoutAdapter extends CustomRecyclerViewAdapter {

    private Activity activity;
    private ArrayList<Serie> series;
    private int screenWidth;

    public StaggeredGridLayoutAdapter(Activity activity, ArrayList<Serie> series) {
        this.activity = activity;
        this.series = series;
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.serie_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.poster.setImageResource(series.get(position).getImgId());
        myHolder.title.setText(series.get(position).getTitulo());

        Random mRandom = new Random();
        int max= 600 , min = 200;
      //  myHolder.itemView.getLayoutParams().height = mRandom.nextInt((max-min)+min)+min;
        /*int height;
        *if (position == 1 || position == (series.size() - 1)) {
            height = 600;
        } else {
            height = 800;
        }

        myHolder.cardView.setLayoutParams(new RecyclerView.LayoutParams(screenWidth/2,height));*/

    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private ImageView poster;
        private TextView title;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.serie_poster_image_view);
            title = (TextView) itemView.findViewById(R.id.serie_titulo_text_view);
            cardView = (CardView) itemView.findViewById(R.id.cardViewSerie);
        }
    }

}
