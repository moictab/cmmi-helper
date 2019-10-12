package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Nueva_organizacion extends Activity {

	private static int RESULT_LOAD_IMAGE = 1;
	GestorSQLiteHelper gestor = new GestorSQLiteHelper(this, "databasefile",
			null, 1);

	String picturePath;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			picturePath = cursor.getString(columnIndex);
			cursor.close();

		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueva_organizacion);

		Button buttonNuevaEvaluacion = (Button) findViewById(R.id.button1);
		Button buttonAyudaCMMI = (Button) findViewById(R.id.buttonAyudaCMMI_NO);
		Button buttonGuardar = (Button) findViewById(R.id.buttonGuardarOrganizacion);
		Button buttonAnadirIcono = (Button) findViewById(R.id.buttonAnadirIcono);

		buttonAnadirIcono.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});

		buttonGuardar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				EditText editNombreOrg = (EditText) findViewById(R.id.SP11NotasNotasEdit);
				EditText editNotasOrg = (EditText) findViewById(R.id.editText7);
				EditText editNombrePer = (EditText) findViewById(R.id.SP11NotasDebilidadesEdit);
				EditText editCargoPer = (EditText) findViewById(R.id.SP11EjemploInputText);
				EditText editCorreoPer = (EditText) findViewById(R.id.editText5);
				EditText editTelefonoPer = (EditText) findViewById(R.id.editText6);

				String nombreOrg = editNombreOrg.getText().toString();
				String nota = editNotasOrg.getText().toString();
				String nombrePer = editNombrePer.getText().toString();
				String cargo = editCargoPer.getText().toString();
				String correo = editCorreoPer.getText().toString();
				String telefono = editTelefonoPer.getText().toString();

				SQLiteDatabase database = gestor.getWritableDatabase();
				try {
					if (nombreOrg.length() == 0 || nombreOrg == ""
							|| nombreOrg.isEmpty()) {
						Toast.makeText(getApplicationContext(),
								"Introduce un nombre para la organización",
								Toast.LENGTH_LONG).show();
					} else {
						database.execSQL("INSERT INTO Organizaciones VALUES ("
								+ "'" + picturePath + "','" + nombreOrg + "','"
								+ nota + "','" + nombrePer + "','" + cargo
								+ "','" + correo + "','" + telefono + "')");
						database.close();

						Toast.makeText(getApplicationContext(),
								"Se ha guardado la organización",
								Toast.LENGTH_LONG).show();

						Intent intent = new Intent(Nueva_organizacion.this,
								MainActivity.class);
						Nueva_organizacion.this.startActivity(intent);
					}

				} catch (android.database.sqlite.SQLiteConstraintException ex) {
					Toast.makeText(
							getApplicationContext(),
							"Nombre de organización duplicado, introduce otro",
							Toast.LENGTH_LONG).show();
				}

			}
		});

		buttonAyudaCMMI.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Nueva_organizacion.this,
						Ayuda_CMMI.class);
				Nueva_organizacion.this.startActivity(intent);
			}
		});

		buttonNuevaEvaluacion.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Nueva_organizacion.this);
				builder.setTitle("¿Quieres guardar esta organización?")
						.setMessage(
								"Se guardarán los datos de la organización introducidos y comenzará una nueva evaluación. ¿Quieres continuar?")
						.setCancelable(false)
						.setPositiveButton("Cancelar", null)
						.setNegativeButton("Aceptar",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {

										EditText editNombreOrg = (EditText) findViewById(R.id.SP11NotasNotasEdit);
										EditText editNota = (EditText) findViewById(R.id.editText7);
										EditText editNombrePer = (EditText) findViewById(R.id.SP11NotasDebilidadesEdit);
										EditText editCargo = (EditText) findViewById(R.id.SP11EjemploInputText);
										EditText editCorreo = (EditText) findViewById(R.id.editText5);
										EditText editTelefono = (EditText) findViewById(R.id.editText6);

										String nombreOrg = editNombreOrg
												.getText().toString();
										String nota = editNota.getText()
												.toString();
										String nombrePer = editNombrePer
												.getText().toString();
										String cargo = editCargo.getText()
												.toString();
										String correo = editCorreo.getText()
												.toString();
										String telefono = editTelefono
												.getText().toString();

										SQLiteDatabase database = gestor
												.getWritableDatabase();
										try {
											if (nombreOrg.length() != 0
													&& nombreOrg != ""
													&& !nombreOrg.isEmpty()) {
												if (database != null) {
													database.execSQL("INSERT INTO Organizaciones VALUES ('"
															+ picturePath
															+ "','"
															+ nombreOrg
															+ "','"
															+ nota
															+ "','"
															+ nombrePer
															+ "','"
															+ cargo
															+ "','"
															+ correo
															+ "','"
															+ telefono
															+ "')");
													database.close();
												}
												Toast.makeText(
														getApplicationContext(),
														"Se ha guardado la organización",
														Toast.LENGTH_LONG)
														.show();

												Intent intent = new Intent(
														Nueva_organizacion.this,
														Nueva_evaluacion.class);
												intent.putExtra("nombre_org",
														nombreOrg);
												Nueva_organizacion.this
														.startActivity(intent);
											} else {
												Toast.makeText(
														getApplicationContext(),
														"Introduce un nombre para la organización",
														Toast.LENGTH_LONG)
														.show();
											}
										} catch (android.database.sqlite.SQLiteConstraintException ex) {
											if (nombreOrg.length() == 0
													|| nombreOrg == ""
													|| nombreOrg.isEmpty()) {
												Toast.makeText(
														getApplicationContext(),
														"Introduce un nombre para la organización",
														Toast.LENGTH_LONG)
														.show();
											} else {
												Toast.makeText(
														getApplicationContext(),
														"Nombre de organización duplicado, introduce otro",
														Toast.LENGTH_LONG)
														.show();
											}
										}
									}
								});
				AlertDialog alert = builder.create();
				alert.show();

				// Intent intent = new Intent(Nueva_organizacion.this,
				// Nueva_evaluacion.class);
				// Nueva_organizacion.this.startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueva_organizacion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent intent = new Intent(Nueva_organizacion.this, Acerca_de.class);
			Nueva_organizacion.this.startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
