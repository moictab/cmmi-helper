package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CustomSQLiteHelper extends SQLiteOpenHelper {

  private static final String sqlCreateOrganizacion = "CREATE TABLE Organizaciones (logotipo_org TEXT, nombre_org TEXT PRIMARY KEY, notas_org TEXT, nombre_per TEXT, cargo_per TEXT, correo_per TEXT, telefono_per TEXT)";
  private static final String sqlCreateEvaluacion = "CREATE TABLE Evaluaciones (cod_ev INTEGER PRIMARY KEY AUTOINCREMENT, nombre_ev TEXT, fecha_inicio_ev TEXT, notas_ev TEXT, areas_ev TEXT, ref_org TEXT REFERENCES Organizaciones(nombre_org) ON DELETE CASCADE)";

  public CustomSQLiteHelper(Context context, String name, CursorFactory factory, int version) {
    super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL("PRAGMA foreign_keys=ON;");
    database.execSQL(sqlCreateOrganizacion);
    database.execSQL(sqlCreateEvaluacion);
    database.execSQL(
        "INSERT INTO Evaluaciones VALUES (" + null + ",'" + null + "','" + null + "','" + null
            + "','" + null + "','" + null + "')");
  }

  @Override
  public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
    arg0.execSQL("DROP TABLE IF EXISTS Organizaciones");
    arg0.execSQL("DROP TABLE IF EXISTS Evaluaciones");
    arg0.execSQL(sqlCreateOrganizacion);
    arg0.execSQL(sqlCreateEvaluacion);
  }
}
