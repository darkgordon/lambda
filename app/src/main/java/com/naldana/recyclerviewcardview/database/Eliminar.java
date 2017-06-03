package com.naldana.recyclerviewcardview.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.naldana.recyclerviewcardview.R;

/**
 * Created by rober on 31/5/2017.
 */

public class Eliminar extends AppCompatActivity {
    Button del;
    DataBaseHelper mdb;
    String ed;
    EditText editText;


    //EditText editText;


    //Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        del= (Button) findViewById(R.id.eliminar2);

    }
    public void dele(View v){

       String ed = editText.getText().toString();

        mdb.delete(ed);
    }



}
