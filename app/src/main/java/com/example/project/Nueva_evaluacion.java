package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Nueva_evaluacion extends Activity {

  CustomSQLiteHelper gestor = new CustomSQLiteHelper(this, "database",
      null, 1);

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nueva_evaluacion);

    Intent intent = getIntent();

    String nombre_org = intent.getStringExtra("nombre_org");
    String notas_org = intent.getStringExtra("notas_org");

    SQLiteDatabase database = gestor.getWritableDatabase();
    Cursor cursor = database
        .rawQuery("SELECT * FROM Organizaciones WHERE nombre_org = '" + nombre_org + "'", null);
    cursor.moveToFirst();

    notas_org = cursor.getString(2);
    cursor.close();

    final EditText notasOrganizacion = findViewById(R.id.notasOrganizacion);
    notasOrganizacion.setKeyListener(null);
    notasOrganizacion.setFocusable(false);

    notasOrganizacion.setText(notas_org);

    final EditText editTextNombre = findViewById(R.id.nombreOrganizacion);
    editTextNombre.setText(nombre_org);
    editTextNombre.setKeyListener(null);
    editTextNombre.setFocusable(false);

    TextView introduccionEtapas = findViewById(R.id.textView1);
    TextView introduccionContinua = findViewById(R.id.textView2);

    int textoEtapas = R.string.introduccion_evaluacion_etapas;
    int textoContinua = R.string.introduccion_evaluacion_continua;

    introduccionEtapas.setText(Html.fromHtml(getString(textoEtapas)));
    introduccionContinua.setText(Html.fromHtml(getString(textoContinua)));

    Button botonAyudaCMMI = findViewById(R.id.button1);

    botonAyudaCMMI.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Nueva_evaluacion.this,
            HelpActivity.class);
        Nueva_evaluacion.this.startActivity(intent);
      }
    });

		/*botonComenzar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = getIntent();
				String nombre_org = i.getStringExtra("nombre_org");

				EditText editNombre = (EditText) findViewById(R.id.SP11NotasFortalezasEdit);
				EditText editNotas = (EditText) findViewById(R.id.SP11NotasDebilidadesEdit);
				EditText editTextFecha = (EditText) findViewById(R.id.SP11EjemploInputText);

				String nombre = editNombre.getText().toString();
				String notas = editNotas.getText().toString();
				String fecha = editTextFecha.getText().toString();

				// TODO Auto-generated method stub
				SQLiteDatabase database = gestor.getWritableDatabase();

				Cursor cursor = database.rawQuery("SELECT * FROM Evaluaciones",
						null);
				cursor.moveToFirst();
				int indice = cursor.getCount();

				if (nombre.length() == 0 || nombre == "" || nombre.isEmpty()) {
					Toast.makeText(getApplicationContext(),
							"Introduce un nombre para la evaluaci�n",
							Toast.LENGTH_LONG).show();
				} else {

					if (database != null) {
						database.execSQL("INSERT INTO Evaluaciones VALUES ("
								+ null + ",'" + nombre + "','" + fecha + "','"
								+ notas + "'," + null + ",'" + nombre_org
								+ "')");
						database.close();
					}
					Intent intent = new Intent(Nueva_evaluacion.this,
							Gestion_configuracion.class);
					intent.putExtra("indice", indice + 1);
					Nueva_evaluacion.this.startActivity(intent);
				}
			}
		});*/

    Button continua = findViewById(R.id.button3);
    continua.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        final String nombre_ev = editTextNombre.getText().toString();
        final String fecha_ev = notasOrganizacion.getText().toString();
        if (nombre_ev.length() == 0 || nombre_ev == "" || nombre_ev.isEmpty()) {
          Toast.makeText(getApplicationContext(),
              "Introduce un nombre para la evaluaci�n",
              Toast.LENGTH_LONG).show();
        } else {

          Intent i = getIntent();
          String nombre_org = i.getStringExtra("nombre_org");
          SQLiteDatabase database = gestor.getWritableDatabase();
          Cursor cursor = database.rawQuery("SELECT * FROM Evaluaciones",
              null);
          cursor.moveToFirst();
          int indice = cursor.getCount();
          Intent intent = new Intent(Nueva_evaluacion.this,
              Nueva_evaluacion_continua.class);
          intent.putExtra("nombre_org", nombre_org);
          intent.putExtra("indice", indice + 1);
          intent.putExtra("nombre_ev", nombre_ev);
          intent.putExtra("fecha_ev", fecha_ev);
          Nueva_evaluacion.this.startActivity(intent);
        }
      }
    });

    Button etapas = findViewById(R.id.button2);
    etapas.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        String nombre_ev = editTextNombre.getText().toString();
        String fecha_ev = notasOrganizacion.getText().toString();
        if (nombre_ev.length() == 0 || nombre_ev == "" || nombre_ev.isEmpty()) {
          Toast.makeText(getApplicationContext(),
              "Introduce un nombre para la evaluaci�n",
              Toast.LENGTH_LONG).show();
        } else {

          Intent i = getIntent();
          String nombre_org = i.getStringExtra("nombre_org");
          SQLiteDatabase database = gestor.getWritableDatabase();
          Cursor cursor = database.rawQuery("SELECT * FROM Evaluaciones",
              null);
          cursor.moveToFirst();
          int indice = cursor.getCount();
          Intent intent = new Intent(Nueva_evaluacion.this,
              Nueva_evaluacion_etapas.class);
          intent.putExtra("indice", indice + 1);
          intent.putExtra("nombre_org", nombre_org);
          intent.putExtra("nombre_ev", nombre_ev);
          intent.putExtra("fecha_ev", fecha_ev);
          Nueva_evaluacion.this.startActivity(intent);
        }
      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.nueva_evaluacion, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.action_settings:
        Intent intent = new Intent(Nueva_evaluacion.this,
            AboutActivity.class);
        Nueva_evaluacion.this.startActivity(intent);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

}
