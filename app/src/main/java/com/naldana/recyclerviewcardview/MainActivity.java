package com.naldana.recyclerviewcardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    /* RAFA ESTO LO HICE YO PARA EL MENU DEL TOOLBAR*/
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if(res_id==R.id.action_card1){
            /*AQUI IRIA EL INTENT QUE ME LLEVA A LA ACTIVIDAD QUE TIENE EL LINEAR LAYOUT DE LA CARD VIEW*/
        }

        else if(res_id==R.id.action_card2){
            /*AQUI IRIA EL INTENT QUE ME LLEVA A LA ACTIVIDAD QUE TIENE LAS PELICULAS MEDIO DESORDENADAS */
        }

        return super.onOptionsItemSelected(item);
    }

    /******************************************/

    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(this, RecyclerViewExample.class);

        switch (id) {
            case R.id.staggered_manager_button:
                intent.putExtra(RecyclerViewExample.EXTRA_TYPE_RECYCLER, 1);
                break;
            case R.id.grid_manager_button:
                intent.putExtra(RecyclerViewExample.EXTRA_TYPE_RECYCLER, 2);
                break;
            case R.id.linear_manager_button:
                intent.putExtra(RecyclerViewExample.EXTRA_TYPE_RECYCLER, 3);
                break;

        }

        startActivity(intent);


    }
}
