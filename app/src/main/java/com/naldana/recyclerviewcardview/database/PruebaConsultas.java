package com.naldana.recyclerviewcardview.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.naldana.recyclerviewcardview.Model.Serie;

import java.util.ArrayList;

/**
 * Created by darkg on 6/5/2017.
 */

public class PruebaConsultas {
    DataBaseHelper mdbh;
    SQLiteDatabase db;

    public PruebaConsultas(Context algo){
        mdbh=new DataBaseHelper(algo);
        db=mdbh.getWritableDatabase();
    }
    public ArrayList<Serie> obtenerdatos() {
        ArrayList<Serie> series = new ArrayList<>();
        String llenado = "SELECT ID,titulo FROM series";
        Cursor cursor = db.rawQuery(llenado, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                series.add(new Serie(cursor.getInt(0), cursor.getString(1)));
                while (cursor.moveToNext()) {
                    series.add(new Serie(cursor.getInt(0), cursor.getString(1)));
                }
            }
        }
        return series;
    }
    public void add(String title) {
        try {
            db.execSQL("INSERT INTO series (titulo) VALUES ( '" + title + "');");
            Log.d("ASD", "ANADIDO CON EXITO");
        } catch (Exception e) {
            Log.d("DSA", "Query incorrecta");
        }
    }
    public void delete(String title) {
        try {
            db.execSQL("DELETE FROM series WHERE titulo = '" + title + "'");
            //CHECKING IF THE QUERY EXECUTED SUCCESFULLY
            Log.d("ASD", "Query correcta");
        } catch (Exception e) {
            //QUERY DID NOT EXECUTE SUCCESFULLY
            Log.d("DSA", "Query incorrecta");
        }

    }

}
