package com.example.app_sqlite_alumnos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AlumnosBD extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="directorio.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ALUMNOS="CREATE TABLE ALUMNOS(MATRICULA TEXT PRIMARY KEY, NOMBRE TEXT, TELEFONO TEXT)";

    public AlumnosBD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_ALUMNOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLA_ALUMNOS);
        sqLiteDatabase.execSQL(TABLA_ALUMNOS);
    }
    public void agregarAlumnos(String matricula, String nombre, String telefono){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO ALUMNOS VALUES('"+matricula+"','"+nombre+"','"+telefono+"')");
            bd.close();
        }
    }



}
