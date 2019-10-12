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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Nueva_evaluacion_continua extends Activity {

	GestorSQLiteHelper gestor = new GestorSQLiteHelper(this, "databasefile",
			null, 1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueva_evaluacion_continua);

		final CheckBox sup = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox cm = (CheckBox) findViewById(R.id.checkBox26);
		final CheckBox ma = (CheckBox) findViewById(R.id.checkBox4);
		final CheckBox ppqa = (CheckBox) findViewById(R.id.checkBox5);
		final CheckBox pm = (CheckBox) findViewById(R.id.checkBox6);
		final CheckBox pmc = (CheckBox) findViewById(R.id.checkBox8);
		final CheckBox pp = (CheckBox) findViewById(R.id.checkBox9);
		final CheckBox sam = (CheckBox) findViewById(R.id.checkBox12);
		final CheckBox eng = (CheckBox) findViewById(R.id.checkBox19);
		final CheckBox reqm = (CheckBox) findViewById(R.id.checkBox22);
		
		EditText editFecha = (EditText) findViewById(R.id.editText1);
	
		Button botonAyuda = (Button) findViewById(R.id.button1);
		botonAyuda.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(
						Nueva_evaluacion_continua.this,
						Ayuda_CMMI.class);
				Nueva_evaluacion_continua.this
						.startActivity(intent);
			}
		});
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = df.format(c.getTime());
		editFecha.setText(formattedDate);
		editFecha.setKeyListener(null);
		editFecha.setFocusable(false);
			
		sup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (sup.isChecked()) {
					cm.setChecked(true);
					ma.setChecked(true);
					ppqa.setChecked(true);
				} else {
					cm.setChecked(false);
					ma.setChecked(false);
					ppqa.setChecked(false);
				}
			}
		});

		cm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!cm.isChecked()) {
					sup.setChecked(false);
				}
			}
		});

		ma.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!ma.isChecked()) {
					sup.setChecked(false);
				}
			}
		});

		ppqa.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!cm.isChecked()) {
					sup.setChecked(false);
				}
			}
		});

		pm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (pm.isChecked()) {
					pmc.setChecked(true);
					pp.setChecked(true);
					sam.setChecked(true);
				} else {
					pmc.setChecked(false);
					pp.setChecked(false);
					sam.setChecked(false);
				}
			}
		});

		pmc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!pmc.isChecked()) {
					pm.setChecked(false);
				}
			}
		});

		pp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!pmc.isChecked()) {
					pm.setChecked(false);
				}
			}
		});

		sam.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!pmc.isChecked()) {
					pm.setChecked(false);
				}
			}
		});

		eng.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (eng.isChecked()) {
					reqm.setChecked(true);
				} else
					reqm.setChecked(false);
			}
		});

		reqm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) { // TODO Auto-generated method
				if (!reqm.isChecked()) {
					eng.setChecked(false);
				}
			}
		});

		Button botonComenzar = (Button) findViewById(R.id.button2);

		botonComenzar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = getIntent();
				String nombre_org = i.getStringExtra("nombre_org");

				EditText editNotas = (EditText) findViewById(R.id.notasEdit);
				EditText editNombre = (EditText) findViewById(R.id.editText2);
				EditText editFecha = (EditText) findViewById(R.id.editText1);

				String nombre_ev = editNombre.getText().toString();
				String notas_ev = editNotas.getText().toString();
				String fecha_ev = editFecha.getText().toString();

				// TODO Auto-generated method stub
				SQLiteDatabase database = gestor.getWritableDatabase();

				String areas = "";

				Cursor cursor = database.rawQuery("SELECT * FROM Evaluaciones",
						null);
				cursor.moveToFirst();
				int indice = cursor.getCount();

				if (cm.isChecked()) {
					areas += "CM,";
				}
				if (ma.isChecked()) {
					areas += "MA,";
				}
				if (ppqa.isChecked()) {
					areas += "PPQA,";
				}
				if (pmc.isChecked()) {
					areas += "PMC,";
				}
				if (pp.isChecked()) {
					areas += "PP,";
				}
				if (sam.isChecked()) {
					areas += "SAM,";
				}
				if (reqm.isChecked()) {
					areas += "REQM,";
				}

				if (nombre_ev.length() == 0 || nombre_ev == ""
						|| nombre_ev.isEmpty()) {
					Toast.makeText(getApplicationContext(),
							"Introduce un nombre para la evaluación",
							Toast.LENGTH_LONG).show();
				} else {

					if (areas.length() == 0 || areas == "" || areas.isEmpty()) {
						Toast.makeText(
								getApplicationContext(),
								"Selecciona una o más áreas de proceso para la evaluación",
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

						int pos = areas.indexOf(",");
						String firstArea = areas.substring(0, pos);

						if (firstArea.equals("CM")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Gestion_configuracion.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
						if (firstArea.equals("MA")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Medicion_analisis.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
						if (firstArea.equals("PPQA")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Aseguramiento_calidad_proceso_producto.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
						if (firstArea.equals("PMC")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Monitorizacion_control_proyecto.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
						if (firstArea.equals("PP")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Planificacion_proyecto.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
						if (firstArea.equals("SAM")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Gestion_acuerdos_proveedores.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
						if (firstArea.equals("REQM")) {
							Intent intent = new Intent(
									Nueva_evaluacion_continua.this,
									Gestion_requisitos.class);
							intent.putExtra("indice", indice + 1);
							intent.putExtra("areas", areas);
							Nueva_evaluacion_continua.this
									.startActivity(intent);
						}
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueva_evaluacion_continua, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent intent = new Intent(Nueva_evaluacion_continua.this,
						Acerca_de.class);
	        	Nueva_evaluacion_continua.this.startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
