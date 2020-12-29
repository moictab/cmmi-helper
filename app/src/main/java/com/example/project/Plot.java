package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Plot extends Activity {

    public static final String DATABASE = "database";

    private CustomSqliteHelper databaseManager = new CustomSqliteHelper(this, DATABASE, null, 1);
    private LinearLayout linearChart;
    private int evaluationIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_plot);
        this.setTitle(this.getString(R.string.evaluation_details));

        this.evaluationIndex = getIntent().getIntExtra("indice", 0);

        SharedPreferences preferenciasCM = getSharedPreferences(
                "gestion_configuracion_" + evaluationIndex, Context.MODE_PRIVATE);
        int cm = preferenciasCM.getInt("nivel", 0);

        SharedPreferences preferenciasMA = getSharedPreferences(
                "medicion_analisis_" + evaluationIndex, Context.MODE_PRIVATE);
        int ma = preferenciasMA.getInt("nivel", 0);

        SharedPreferences preferenciasPMC = getSharedPreferences(
                "monitorizacion_control_proyecto_" + evaluationIndex,
                Context.MODE_PRIVATE);
        int pmc = preferenciasPMC.getInt("nivel", 0);

        SharedPreferences preferenciasPP = getSharedPreferences(
                "planificacion_proyecto_" + evaluationIndex, Context.MODE_PRIVATE);
        int pp = preferenciasPP.getInt("nivel", 0);

        SharedPreferences preferenciasPPQA = getSharedPreferences(
                "aseguramiento_calidad_proceso_producto_" + evaluationIndex,
                Context.MODE_PRIVATE);
        int ppqa = preferenciasPPQA.getInt("nivel", 0);

        SharedPreferences preferenciasREQM = getSharedPreferences(
                "gestion_requisitos_" + evaluationIndex, Context.MODE_PRIVATE);
        int reqm = preferenciasREQM.getInt("nivel", 0);

        SharedPreferences preferenciasSAM = getSharedPreferences(
                "gestion_acuerdos_proveedores_" + evaluationIndex, Context.MODE_PRIVATE);
        int sam = preferenciasSAM.getInt("nivel", 0);

        int a = R.string.niveles_capacidad;
        TextView tv1 = findViewById(R.id.textView17);
        tv1.setText(Html.fromHtml(getString(a)));

        Button botonAyuda = findViewById(R.id.button1);
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Plot.this,
                        HelpActivity.class);
                Plot.this
                        .startActivity(intent);
            }
        });

        linearChart = findViewById(R.id.linearChart);
        int base = 45;
        drawChart(5, cm * base + 5, ma * base + 5, pmc * base + 5, pp * base + 5, ppqa * base + 5,
                reqm * base + 5, sam * base + 5);

        Button botonContinuar = findViewById(R.id.button2);
        botonContinuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Plot.this,
                        ConfigurationManagementActivity.class);
                intent.putExtra("indice", evaluationIndex);
                Plot.this.startActivity(intent);
            }
        });

        EditText editNombre = findViewById(R.id.editText1);
        EditText editNotas = findViewById(R.id.editText2);

        SQLiteDatabase database = databaseManager.getWritableDatabase();
        Cursor cursor = database
                .rawQuery("SELECT * FROM Evaluaciones WHERE cod_ev = '" + evaluationIndex + "'", null);
        boolean bol = cursor.moveToFirst();

        String nombre = cursor.getString(1);
        String notas = cursor.getString(3);

        editNombre.setText(nombre);
        editNotas.setText(notas);

        editNombre.setFocusable(false);
        editNombre.setKeyListener(null);
        editNotas.setFocusable(false);
        editNotas.setKeyListener(null);

    }


    public void drawChart(int count, int h1, int h2, int h3, int h4, int h5, int h6, int h7) {
        System.out.println(count);

        View view1 = new View(this);
        view1.setBackgroundColor(Color.parseColor("#87CEFA"));

        view1.setLayoutParams(new LinearLayout.LayoutParams(15, h1));
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) view1
                .getLayoutParams();
        params1.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view1.setLayoutParams(params1);
        linearChart.addView(view1);

        View view2 = new View(this);
        view2.setBackgroundColor(Color.parseColor("#87CEFA"));
        view2.setLayoutParams(new LinearLayout.LayoutParams(15, h2));
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) view2
                .getLayoutParams();
        params2.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view2.setLayoutParams(params2);
        linearChart.addView(view2);

        View view3 = new View(this);
        view3.setBackgroundColor(Color.parseColor("#87CEFA"));
        view3.setLayoutParams(new LinearLayout.LayoutParams(15, h3));
        LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) view3
                .getLayoutParams();
        params3.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view3.setLayoutParams(params3);
        linearChart.addView(view3);

        View view4 = new View(this);
        view4.setBackgroundColor(Color.parseColor("#87CEFA"));
        view4.setLayoutParams(new LinearLayout.LayoutParams(15, h4));
        LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) view4
                .getLayoutParams();
        params4.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view4.setLayoutParams(params4);
        linearChart.addView(view4);

        View view5 = new View(this);
        view5.setBackgroundColor(Color.parseColor("#87CEFA"));
        view5.setLayoutParams(new LinearLayout.LayoutParams(15, h5));
        LinearLayout.LayoutParams params5 = (LinearLayout.LayoutParams) view5
                .getLayoutParams();
        params5.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view5.setLayoutParams(params5);
        linearChart.addView(view5);

        View view6 = new View(this);
        view6.setBackgroundColor(Color.parseColor("#87CEFA"));
        view6.setLayoutParams(new LinearLayout.LayoutParams(15, h6));
        LinearLayout.LayoutParams params6 = (LinearLayout.LayoutParams) view6
                .getLayoutParams();
        params6.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view6.setLayoutParams(params6);
        linearChart.addView(view6);

        View view7 = new View(this);
        view7.setBackgroundColor(Color.parseColor("#87CEFA"));
        view7.setLayoutParams(new LinearLayout.LayoutParams(15, h7));
        LinearLayout.LayoutParams params7 = (LinearLayout.LayoutParams) view7
                .getLayoutParams();
        params7.setMargins(20, 0, 0, 0); // substitute parameters for left,top, right, bottom
        view7.setLayoutParams(params7);
        linearChart.addView(view7);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plot, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(Plot.this,
                        AboutActivity.class);
                Plot.this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
