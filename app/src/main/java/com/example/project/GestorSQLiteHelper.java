package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GestorSQLiteHelper extends SQLiteOpenHelper {

	//String sqlCreateOrganizacion = "CREATE TABLE Organizaciones (cod_org INTEGER, logotipo_org BLOB, nombre_org TEXT, notas_org TEXT, nombre_per TEXT, cargo_per TEXT, correo_per TEXT, telefono_per TEXT)";
	//String sqlCreateEvaluacion = "CREATE TABLE Evaluaciones (cod_ev INTEGER, nombre_ev TEXT, fecha_inicio_ev TEXT, notas_ev TEXT, areas_ev TEXT)";
	
	String sqlCreateOrganizacion = "CREATE TABLE Organizaciones (logotipo_org TEXT, nombre_org TEXT PRIMARY KEY, notas_org TEXT, nombre_per TEXT, cargo_per TEXT, correo_per TEXT, telefono_per TEXT)";
	String sqlCreateEvaluacion = "CREATE TABLE Evaluaciones (cod_ev INTEGER PRIMARY KEY AUTOINCREMENT, nombre_ev TEXT, fecha_inicio_ev TEXT, notas_ev TEXT, areas_ev TEXT, ref_org TEXT REFERENCES Organizaciones(nombre_org) ON DELETE CASCADE)";
	//String sqlCreateGestionConfiguracion = "CREATE TABLE GestionConfiguracion (cod INTEGER PRIMARY KEY AUTOINCREMENT, seekbar11_1 NUMBER, edittext11_1 TEXT, edittext11_2 TEXT, edittext11_3 TEXT, spinner11_1 NUMBER, edittext11_4 TEXT, )";
	
	
	public GestorSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("PRAGMA foreign_keys=ON;");
		arg0.execSQL(sqlCreateOrganizacion);
		arg0.execSQL(sqlCreateEvaluacion);
		arg0.execSQL("INSERT INTO Evaluaciones VALUES ("
				+ null
				+ ",'"
				+ null
				+ "','"
				+ null
				+ "','"
				+ null
				+ "','"
				+ null + "','" + null + "')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("DROP TABLE IF EXISTS Organizaciones");
		arg0.execSQL("DROP TABLE IF EXISTS Evaluaciones");
		arg0.execSQL(sqlCreateOrganizacion);
		arg0.execSQL(sqlCreateEvaluacion);
	}
}
