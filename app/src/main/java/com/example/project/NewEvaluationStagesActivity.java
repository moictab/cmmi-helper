package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewEvaluationStagesActivity extends Activity {

    private CustomSqliteHelper gestor = new CustomSqliteHelper(this, "database",
            null, 1);

    private String areas = "CM,MA,PMC,PP,PPQA,REQM,SAM,";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_evaluacion_etapas);

        final RadioButton ml2 = findViewById(R.id.radioButton1);
        RadioButton ml3 = findViewById(R.id.radioButton2);
        RadioButton ml4 = findViewById(R.id.radioButton3);
        RadioButton ml5 = findViewById(R.id.radioButton4);

        Button botonAyuda = findViewById(R.id.button1);
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        NewEvaluationStagesActivity.this,
                        HelpActivity.class);
                NewEvaluationStagesActivity.this
                        .startActivity(intent);
            }
        });

        EditText editFecha = findViewById(R.id.editText2);
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
            }
        });

        Button botonComenzar = findViewById(R.id.button2);

        botonComenzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!ml2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Selecciona un nivel de madurez",
                            Toast.LENGTH_LONG).show();
                } else {

                    Intent i = getIntent();
                    String nombre_org = i.getStringExtra("nombre_org");

                    EditText editNombre = findViewById(R.id.editText1);
                    EditText editFecha = findViewById(R.id.editText2);
                    EditText editNotas = findViewById(R.id.editText3);

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
                                "Introduce un nombre para la evaluaci�n",
                                Toast.LENGTH_LONG).show();
                    } else {

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

                        Intent intent = new Intent(
                                NewEvaluationStagesActivity.this,
                                ConfigurationManagementActivity.class);
                        intent.putExtra("indice", indice + 1);
                        intent.putExtra("areas", areas);
                        NewEvaluationStagesActivity.this.startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nueva_evaluacion_etapas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(NewEvaluationStagesActivity.this,
                    AboutActivity.class);
            NewEvaluationStagesActivity.this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
