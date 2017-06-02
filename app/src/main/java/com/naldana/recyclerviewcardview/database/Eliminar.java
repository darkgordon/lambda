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
    EditText editText;
DataBaseHelper mdb;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        del= (Button) findViewById(R.id.delete);
    }

    public void del(View v){
        String ed;
        ed = editText.toString();
        mdb.delete(ed);
    }

}
