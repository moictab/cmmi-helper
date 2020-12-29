package com.example.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewOrganizationActivity extends Activity {

    private static final String TAG = "NewOrganization";
    private static final int RESULT_LOAD_IMAGE = 1;
    private static final String DATABASE = "DATABASE";

    private final CustomSqliteHelper helper = new CustomSqliteHelper(this, DATABASE, null, 1);
    private String picturePath;

    private EditText etOrganizationName;
    private EditText etOrganizationNotes;
    private EditText etContactName;
    private EditText etContactPosition;
    private EditText etContactEmail;
    private EditText etContactPhone;

    private FloatingActionButton fabNewEvaluation;
    private Button btnHelp;
    private Button btnSave;
    private Button btnAddIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_organization);

        fabNewEvaluation = findViewById(R.id.fabNewEvaluation);

        etOrganizationName = findViewById(R.id.etOrganizationName);
        etOrganizationNotes = findViewById(R.id.etOrganizationNotes);
        etContactName = findViewById(R.id.etContactName);
        etContactPosition = findViewById(R.id.etContactPosition);
        etContactEmail = findViewById(R.id.etContactEmail);
        etContactPhone = findViewById(R.id.etContactPhone);

        btnAddIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOrganization();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewOrganizationActivity.this, HelpActivity.class);
                NewOrganizationActivity.this.startActivity(intent);
            }
        });

        fabNewEvaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvaluation();
            }
        });
    }

    private void saveOrganization() {
        String nombreOrg = etOrganizationName.getText().toString();
        String nota = etOrganizationNotes.getText().toString();
        String nombrePer = etContactName.getText().toString();
        String cargo = etContactPosition.getText().toString();
        String correo = etContactEmail.getText().toString();
        String telefono = etContactPhone.getText().toString();

        SQLiteDatabase database = helper.getWritableDatabase();
        try {
            if (nombreOrg.isEmpty()) {
                Toast.makeText(getApplicationContext(), getString(R.string.new_organization_name_empty), Toast.LENGTH_LONG).show();
            } else {
                database.execSQL("INSERT INTO Organizaciones VALUES ('" + picturePath + "','" + nombreOrg + "','" + nota + "','" + nombrePer + "','" + cargo + "','" + correo + "','" + telefono + "')");
                database.close();

                Toast.makeText(getApplicationContext(), "Se ha guardado la organizaci�n", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(NewOrganizationActivity.this, MainActivity.class);
                NewOrganizationActivity.this.startActivity(intent);
            }
        } catch (SQLiteException e) {
            Log.e(TAG, "Error saving organization into database", e);
        }
    }

    private void addEvaluation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(NewOrganizationActivity.this);
        builder.setTitle("�Quieres guardar esta organizaci�n?")
                .setMessage("Se guardar�n los datos de la organizaci�n introducidos y comenzar� una nueva evaluaci�n. �Quieres continuar?")
                .setCancelable(false)
                .setPositiveButton("Cancelar", null)
                .setNegativeButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String nombreOrg = etOrganizationName.getText().toString();
                                String nota = etOrganizationNotes.getText().toString();
                                String nombrePer = etContactName.getText().toString();
                                String cargo = etContactPosition.getText().toString();
                                String correo = etContactEmail.getText().toString();
                                String telefono = etContactPhone.getText().toString();

                                SQLiteDatabase database = helper.getWritableDatabase();
                                try {
                                    if (nombreOrg.length() != 0 && !nombreOrg.equals("") && !nombreOrg.isEmpty()) {
                                        if (database != null) {
                                            database.execSQL("INSERT INTO Organizaciones VALUES ('" + picturePath + "','" + nombreOrg + "','" + nota + "','" + nombrePer + "','" + cargo + "','" + correo + "','" + telefono + "')");
                                            database.close();
                                        }
                                        Toast.makeText(getApplicationContext(), "Se ha guardado la organizaci�n", Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(NewOrganizationActivity.this, NewEvaluationActivity.class);
                                        intent.putExtra("nombre_org", nombreOrg);
                                        NewOrganizationActivity.this.startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Introduce un nombre para la organizaci�n", Toast.LENGTH_LONG).show();
                                    }
                                } catch (SQLiteException e) {
                                    if (nombreOrg.length() == 0 || nombreOrg.equals("") || nombreOrg.isEmpty()) {
                                        Toast.makeText(getApplicationContext(), "Introduce un nombre para la organizaci�n", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Nombre de organizaci�n duplicado, introduce otro", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            // TODO Fix this, projection parameter is not working
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.nueva_organizacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(NewOrganizationActivity.this, AboutActivity.class);
            NewOrganizationActivity.this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
