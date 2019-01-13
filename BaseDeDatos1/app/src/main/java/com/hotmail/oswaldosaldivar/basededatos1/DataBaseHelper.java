package com.hotmail.oswaldosaldivar.basededatos1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by oswaldosaldivar on 06/04/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Estudiante.db";
    public static final String TABLE_NAME = "estudiante_table";
    public static final String COLUMNA_1 = "ID";
    public static final String COLUMNA_2 = "NOMBRE";
    public static final String COLUMNA_3 = "APELLIDOS";
    public static final String COLUMNA_4 = "MATERIAS";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY, NOMBRE TEXT,APELLIDOS TEXT, MATERIAS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String nombre,String apellidos, String materias){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNA_2,nombre);
        contentValues.put(COLUMNA_3,apellidos);
        contentValues.put(COLUMNA_4, materias);
        long resultado = db.insert(TABLE_NAME,null,contentValues);

        if(resultado == -1)
            return false;
        else
            return true;
    }

    public  Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
    public boolean updateDates(String id,String nombre,String apellidos,String materias){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNA_1,id);
        contentValues.put(COLUMNA_2,nombre);
        contentValues.put(COLUMNA_3,apellidos);
        contentValues.put(COLUMNA_4,materias);

        long resultado = db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteDates(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[]{id});
    }
}
