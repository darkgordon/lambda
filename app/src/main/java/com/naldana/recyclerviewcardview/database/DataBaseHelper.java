package com.naldana.recyclerviewcardview.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.naldana.recyclerviewcardview.Model.Serie;
import com.naldana.recyclerviewcardview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rober on 31/5/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase mDb;


    private static final String createTable = "CREATE TABLE series(" +
            "ID INT, titulo TEXT)";

    Random mRandom = new Random();

    public DataBaseHelper(Context context) {
        super(context, "seriesdb", null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        db.execSQL("INSERT INTO series (ID, titulo) VALUES (" + R.drawable.hora_de_aventura + ", 'Gravity Falls')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getCursor() {
        return getReadableDatabase().query("series", null, null, null, null, null, null);
    }

    public void add(String title) {
        try {
            getWritableDatabase().execSQL("INSERT INTO series (ID, titulo) VALUES (" + mRandom.nextInt(2) + ", '" + title + "')");
            Log.d("ASD", "ANADIDO CON EXITO");
        } catch (Exception e) {
            Log.d("DSA", "Query incorrecta");
        }
    }

    public void delete(String title) {
        try {
            getWritableDatabase().execSQL("DELETE FROM series WHERE titulo = '" + title + "'");
            //CHECKING IF THE QUERY EXECUTED SUCCESFULLY
            Log.d("ASD", "Query correcta");
        } catch (Exception e) {
            //QUERY DID NOT EXECUTE SUCCESFULLY
            Log.d("DSA", "Query incorrecta");
        }

    }

    public void edit(String title, String newTitle) {
        getWritableDatabase().execSQL("Update series SET titulo  = '" + newTitle + "' WHERE titulo = '" + title + "'");
    }

    //siguiendo lo dicho ahora el huevo esta pasar otdas mis cosas a adapador en el otro entonves vamos a hacer un metood para que de las
    //series por alguna forma posible en la humidad

//este es el lsit para agarrar

    public List obtenerdatos() {
        List<Serie> lista = null;
        String llenado = "SELECT * FROM series";
        Cursor cursor = mDb.rawQuery(llenado, null);
        lista = new ArrayList<Serie>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    lista.add(new Serie(cursor.getInt(0), cursor.getString(1)));
                } while (cursor.moveToNext());


            }
        }
        return lista;
    }

}





