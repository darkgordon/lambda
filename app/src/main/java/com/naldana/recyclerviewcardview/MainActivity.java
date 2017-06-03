package com.naldana.recyclerviewcardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.naldana.recyclerviewcardview.Model.Serie;
import com.naldana.recyclerviewcardview.database.DataBaseHelper;
import com.naldana.recyclerviewcardview.database.DatabaseHelperBenji;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button del;
    DataBaseHelper mdb;
    String ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        del= (Button) findViewById(R.id.eliminar2);
        mdb = new DataBaseHelper(this);

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

    //vamos a tratar hacer todo para el boton de agregar un nuevo

    public void agregar (View vie) {

        String nombre = editText.getText().toString();

        //Serie serie =
          //      new Serie(nombre);
        mdb.add(nombre);
        editText.setText("");
        //quantityBox.setText("");
        //recordar que esto servia antes, quizas algo que pusheo la aeriak no iba osea no servia el boto na;adir pero voy a revisar eso exactamente
    }

    public void delete(View view){

        String ed = editText.getText().toString();
        mdb.delete(ed);
        editText.setText("");
    }

}
