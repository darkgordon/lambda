package com.naldana.recyclerviewcardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
