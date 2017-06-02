package com.naldana.recyclerviewcardview.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.naldana.recyclerviewcardview.R;
import java.util.Random;

/**
 * Created by rober on 31/5/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String createTable = "CREATE TABLE series(" +
            "ID INT, titulo TEXT)";

    Random mRandom = new Random();

    public DataBaseHelper(Context context){
        super(context, "seriesdb", null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        db.execSQL("INSERT INTO series (ID, titulo) VALUES ("+ R.drawable.hora_de_aventura + ", 'Gravity Falls')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getCursor(){
        return getReadableDatabase().query("series", null, null, null, null, null, null);
    }

    public void add(String title){
        getWritableDatabase().execSQL("INSERT INTO series (ID, titulo) VALUES ("+ mRandom.nextInt(2) +", '"+ title +"')");
    }

    public void delete(String title){
        getWritableDatabase().execSQL("DELETE * FROM series WHERE titulo = '" + title+ "'");
    }

    public void edit(String title, String newTitle){
        getWritableDatabase().execSQL("Update series SET titulo  = '" + newTitle + "' WHERE titulo = '" + title+"'");
    }
}


