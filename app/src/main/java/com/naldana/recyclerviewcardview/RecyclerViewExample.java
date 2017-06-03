package com.naldana.recyclerviewcardview;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.naldana.recyclerviewcardview.Adpater.Adapter;
import com.naldana.recyclerviewcardview.Adpater.StaggeredGridLayoutAdapter;
import com.naldana.recyclerviewcardview.Model.Serie;
import com.naldana.recyclerviewcardview.database.DataBaseHelper;

import java.util.ArrayList;

public class RecyclerViewExample extends AppCompatActivity {
    DataBaseHelper mdb;

    public static final String EXTRA_TYPE_RECYCLER = "com.naladana.EXTRA_TYPE_RECYCLER";

    public final static String LAYOUT_MANAGER = "LayoutManager";
    public final static String STAGGERED_LAYOUT_MANAGER = "StaggeredLayoutManager";
    public final static String GRID_LAYOUT_MANAGER = "GridLayoutManager";
    public final static String LINEAR_LAYOUT_MANAGER = "LinearLayoutManager";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);

        int opcion = getIntent().getIntExtra(EXTRA_TYPE_RECYCLER, 1);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //Cursor c = database.rawQuery(selectQuery, null);
        //Cursor c= mdb.cr
        ArrayList<Serie> series = new ArrayList<>(2);

        series.add(new Serie("Lost", R.drawable.lost));
        series.add(new Serie("Adeventure Time", R.drawable.hora_de_aventura));
        series.add(new Serie("Lost 1", R.drawable.lost));
        series.add(new Serie("Adeve1nture Time", R.drawable.hora_de_aventura));
        series.add(new Serie("Lost 2", R.drawable.lost));
        series.add(new Serie("Adeventure Time2", R.drawable.hora_de_aventura));
        series.add(new Serie("Lost3", R.drawable.lost));
        series.add(new Serie("Adeventure Time3", R.drawable.hora_de_aventura));
        series.add(new Serie("Lost4", R.drawable.lost));
        series.add(new Serie("Adeventure Time4", R.drawable.hora_de_aventura));


        switch (opcion) {
            case 1:
                recyclerView.setHasFixedSize(true);
                StaggeredGridLayoutManager straggLayoutManager = new StaggeredGridLayoutManager(3, GridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(straggLayoutManager);
                recyclerView.setAdapter(new StaggeredGridLayoutAdapter(this, series));
                break;
            case 2:
                recyclerView.setHasFixedSize(true);
                GridLayoutManager gLayoutManager = new GridLayoutManager(this, 3);
                recyclerView.setLayoutManager(gLayoutManager);
                recyclerView.setAdapter(new Adapter(this, series));
                break;
            case 3:
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager lLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(lLayoutManager);
                recyclerView.setAdapter(new Adapter(this, series));
                break;

        }
    }
}
