package com.naldana.recyclerviewcardview.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.naldana.recyclerviewcardview.Model.Serie;
import com.naldana.recyclerviewcardview.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rober on 31/5/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase mDB;
    DataBaseHelper mdb;
    String direccion="";
    Context contexto;

    /*
    TODAS TUS CONSULTAS EN SI PASALAS A PUREBACONSULTA PORQUE PORQUE DESDE ALLI TRABAJA PARA ESCRIBIR DE ALLI L ODEMAS LO TENEMOS BUENO

     */

    private static final String createTable = "CREATE TABLE series(ID INT PRIMARY KEY, titulo TEXT);";
    private static final String DATABASE_NAME="series";

    Random mRandom = new Random();

    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
        if(android.os.Build.VERSION.SDK_INT >= 17){
            direccion = context.getApplicationInfo().dataDir;
        }
        else
        {
            direccion = "/data/data/" + context.getPackageName();
        }
        this.contexto = context;

    }
    public boolean checkExistance(){
        File backup = new File(direccion + "series");
        boolean flag = backup.exists();
        return flag;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

   // public Cursor getCursor() {
    //    return getReadableDatabase().query("series", null, null, null, null, null, null);
   // }





    public void edit(String title, String newTitle) {
        getWritableDatabase().execSQL("Update series SET titulo  = '" + newTitle + "' WHERE titulo = '" + title + "'");
    }
    public void copyDB() throws IOException {
        InputStream s = contexto.getAssets().open("series");
        String output = direccion + "series";
        OutputStream o = new FileOutputStream(output);
        byte[] buff = new byte[1024];
        int length;
        while((length = s.read(buff)) > 0){
            o.write(buff, 0, length);
        }
        o.flush();
        o.close();
        s.close();
    }

    //siguiendo lo dicho ahora el huevo esta pasar otdas mis cosas a adapador en el otro entonves vamos a hacer un metood para que de las
    //series por alguna forma posible en la humidad

//este es el lsit para agarrar
    //modifaquermos a arreglo


}





