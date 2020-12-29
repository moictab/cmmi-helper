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

public class NewEvaluationActivity extends Activity {

    private CustomSqliteHelper gestor = new CustomSqliteHelper(this, "database",
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
                Intent intent = new Intent(NewEvaluationActivity.this,
                        HelpActivity.class);
                NewEvaluationActivity.this.startActivity(intent);
            }
        });

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
                    Intent intent = new Intent(NewEvaluationActivity.this,
                            Nueva_evaluacion_continua.class);
                    intent.putExtra("nombre_org", nombre_org);
                    intent.putExtra("indice", indice + 1);
                    intent.putExtra("nombre_ev", nombre_ev);
                    intent.putExtra("fecha_ev", fecha_ev);
                    NewEvaluationActivity.this.startActivity(intent);
                }
            }
        });

        Button btnStages = findViewById(R.id.button2);
        btnStages.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String evaluationName = editTextNombre.getText().toString();
                String evaluationDate = notasOrganizacion.getText().toString();

                if (evaluationName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.input_evaluation_name),
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = getIntent();
                    String organizationName = intent.getStringExtra("nombre_org");
                    SQLiteDatabase database = gestor.getWritableDatabase();

                    Cursor cursor = database.rawQuery("SELECT * FROM Evaluaciones",
                            null);
                    cursor.moveToFirst();
                    int indice = cursor.getCount();
                    Intent stagesIntent = new Intent(NewEvaluationActivity.this,
                            NewEvaluationStagesActivity.class);
                    stagesIntent.putExtra("indice", indice + 1);
                    stagesIntent.putExtra("nombre_org", organizationName);
                    stagesIntent.putExtra("nombre_ev", evaluationName);
                    stagesIntent.putExtra("fecha_ev", evaluationDate);
                    NewEvaluationActivity.this.startActivity(stagesIntent);
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
                Intent intent = new Intent(NewEvaluationActivity.this,
                        AboutActivity.class);
                NewEvaluationActivity.this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
