package com.example.project;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Nueva_evaluacion_etapas extends Activity {

	GestorSQLiteHelper gestor = new GestorSQLiteHelper(this, "databasefile",
			null, 1);

	boolean go = false;

	String areas = "CM,MA,PMC,PP,PPQA,REQM,SAM,";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueva_evaluacion_etapas);

		final RadioButton ml2 = (RadioButton) findViewById(R.id.radioButton1);
		RadioButton ml3 = (RadioButton) findViewById(R.id.radioButton2);
		RadioButton ml4 = (RadioButton) findViewById(R.id.radioButton3);
		RadioButton ml5 = (RadioButton) findViewById(R.id.radioButton4);
		
		Button botonAyuda = (Button) findViewById(R.id.button1);
		botonAyuda.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(
						Nueva_evaluacion_etapas.this,
						Ayuda_CMMI.class);
				Nueva_evaluacion_etapas.this
						.startActivity(intent);
			}
		});

		EditText editFecha = (EditText) findViewById(R.id.editText2);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = df.format(c.getTime());
		editFecha.setText(formattedDate);
		editFecha.setKeyListener(null);
		editFecha.setFocusable(false);

		ml3.setEnabled(false);
		ml4.setEnabled(false);
		ml5.setEnabled(false);

		ml2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				go = true;
			}
		});

		Button botonComenzar = (Button) findViewById(R.id.button2);

		botonComenzar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!ml2.isChecked()) {
					Toast.makeText(getApplicationContext(),
							"Selecciona un nivel de madurez", Toast.LENGTH_LONG)
							.show();
				} else {

					Intent i = getIntent();
					String nombre_org = i.getStringExtra("nombre_org");
					
					EditText editNombre = (EditText) findViewById(R.id.editText1);
					EditText editFecha = (EditText) findViewById(R.id.editText2);
					EditText editNotas = (EditText) findViewById(R.id.editText3);

					String nombre_ev = editNombre.getText().toString();
					String notas_ev = editNotas.getText().toString();
					String fecha_ev = editFecha.getText().toString();

					// TODO Auto-generated method stub
					SQLiteDatabase database = gestor.getWritableDatabase();

					Cursor cursor = database.rawQuery(
							"SELECT * FROM sqlite_sequence", null);
					cursor.moveToFirst();
					int indice = cursor.getInt(1);

					if (nombre_ev.length() == 0 || nombre_ev == ""
							|| nombre_ev.isEmpty()) {
						Toast.makeText(getApplicationContext(),
								"Introduce un nombre para la evaluación",
								Toast.LENGTH_LONG).show();
					} else {

						if (database != null) {
							database.execSQL("INSERT INTO Evaluaciones VALUES ("
									+ null
									+ ",'"
									+ nombre_ev
									+ "','"
									+ fecha_ev
									+ "','"
									+ notas_ev
									+ "','"
									+ areas + "','" + nombre_org + "')");
							database.close();
						}

						Intent intent = new Intent(
								Nueva_evaluacion_etapas.this,
								Gestion_configuracion.class);
						intent.putExtra("indice", indice + 1);
						intent.putExtra("areas", areas);
						Nueva_evaluacion_etapas.this.startActivity(intent);
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueva_evaluacion_etapas, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent intent = new Intent(Nueva_evaluacion_etapas.this,
						Acerca_de.class);
	        	Nueva_evaluacion_etapas.this.startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
