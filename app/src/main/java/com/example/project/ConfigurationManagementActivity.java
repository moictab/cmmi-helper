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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationManagementActivity extends Activity {

    private int indiceEvaluacion;
    private int nivel = 3;
    private boolean b1 = true;
    private boolean b2 = true;

    private CustomSQLiteHelper helper = new CustomSQLiteHelper(this, "database", null, 1);

    protected void onStop() {
        super.onStop();

        SharedPreferences preferencias = getSharedPreferences(
                "gestion_configuracion_" + indiceEvaluacion, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        SeekBar sb1 = findViewById(R.id.SP11Seekbar);
        editor.putInt("SP11seekbar", sb1.getProgress());
        nivel1(sb1.getProgress());

        EditText SP11Edit1 = findViewById(R.id.SP11NotasNotasEdit);
        EditText SP11Edit2 = findViewById(R.id.SP11NotasFortalezasEdit);
        EditText SP11Edit3 = findViewById(R.id.SP11NotasDebilidadesEdit);
        editor.putString("SP11edittext1", SP11Edit1.getText().toString());
        editor.putString("SP11edittext2", SP11Edit2.getText().toString());
        editor.putString("SP11edittext3", SP11Edit3.getText().toString());

        Spinner SP11spinner1 = findViewById(R.id.SP11EjemploInputSpinner);
        editor.putInt("SP11spinner1", SP11spinner1.getSelectedItemPosition());
        EditText SP11Edit4 = findViewById(R.id.SP11EjemploInputText);
        editor.putString("SP11edittext4", SP11Edit4.getText().toString());

        SeekBar sb2 = findViewById(R.id.SP12Seekbar);
        editor.putInt("SP12seekbar", sb2.getProgress());
        nivel1(sb2.getProgress());

        EditText SP12Edit1 = findViewById(R.id.SP12NotasEvaluacionEdit);
        EditText SP12Edit2 = findViewById(R.id.SP12NotasFortalezasEdit);
        EditText SP12Edit3 = findViewById(R.id.SP12NotasDebilidadesEdit);
        editor.putString("SP12edittext1", SP12Edit1.getText().toString());
        editor.putString("SP12edittext2", SP12Edit2.getText().toString());
        editor.putString("SP12edittext3", SP12Edit3.getText().toString());

        Spinner SP12spinner1 = findViewById(R.id.Spinner01);
        editor.putInt("SP12spinner1", SP12spinner1.getSelectedItemPosition());
        EditText SP12Edit4 = findViewById(R.id.EditText01);
        editor.putString("SP12edittext4", SP12Edit4.getText().toString());
        Spinner SP12spinner2 = findViewById(R.id.Spinner03);
        editor.putInt("SP12spinner2", SP12spinner2.getSelectedItemPosition());
        EditText SP12Edit5 = findViewById(R.id.EditText06);
        editor.putString("SP12edittext5", SP12Edit5.getText().toString());
        Spinner SP12spinner3 = findViewById(R.id.Spinner04);
        editor.putInt("SP12spinner3", SP12spinner3.getSelectedItemPosition());
        EditText SP12Edit6 = findViewById(R.id.EditText07);
        editor.putString("SP12edittext6", SP12Edit6.getText().toString());

        SeekBar sb3 = findViewById(R.id.SeekBar01);
        editor.putInt("SP13seekbar", sb3.getProgress());
        nivel1(sb3.getProgress());

        EditText SP13Edit1 = findViewById(R.id.EditText03);
        EditText SP13Edit2 = findViewById(R.id.EditText04);
        EditText SP13Edit3 = findViewById(R.id.EditText02);
        editor.putString("SP13edittext1", SP13Edit1.getText().toString());
        editor.putString("SP13edittext2", SP13Edit2.getText().toString());
        editor.putString("SP13edittext3", SP13Edit3.getText().toString());

        Spinner SP13spinner1 = findViewById(R.id.Spinner05);
        editor.putInt("SP13spinner1", SP13spinner1.getSelectedItemPosition());
        EditText SP13Edit4 = findViewById(R.id.EditText08);
        editor.putString("SP13edittext4", SP13Edit4.getText().toString());
        Spinner SP13spinner2 = findViewById(R.id.Spinner02);
        editor.putInt("SP13spinner2", SP13spinner2.getSelectedItemPosition());
        EditText SP13Edit5 = findViewById(R.id.EditText05);
        editor.putString("SP13edittext5", SP13Edit5.getText().toString());

        SeekBar sb4 = findViewById(R.id.SeekBar02);
        editor.putInt("SP21seekbar", sb4.getProgress());
        nivel1(sb4.getProgress());

        EditText SP21Edit1 = findViewById(R.id.EditText17);
        EditText SP21Edit2 = findViewById(R.id.EditText18);
        EditText SP21Edit3 = findViewById(R.id.EditText16);
        editor.putString("SP21edittext1", SP21Edit1.getText().toString());
        editor.putString("SP21edittext2", SP21Edit2.getText().toString());
        editor.putString("SP21edittext3", SP21Edit3.getText().toString());

        Spinner SP21spinner1 = findViewById(R.id.Spinner06);
        editor.putInt("SP21spinner1", SP21spinner1.getSelectedItemPosition());
        EditText SP21Edit4 = findViewById(R.id.EditText14);
        editor.putString("SP21edittext4", SP21Edit4.getText().toString());

        SeekBar sb5 = findViewById(R.id.SeekBar04);
        editor.putInt("SP22seekbar", sb5.getProgress());
        nivel1(sb5.getProgress());

        EditText SP22Edit1 = findViewById(R.id.EditText12);
        EditText SP22Edit2 = findViewById(R.id.EditText11);
        EditText SP22Edit3 = findViewById(R.id.EditText23);
        editor.putString("SP22edittext1", SP22Edit1.getText().toString());
        editor.putString("SP22edittext2", SP22Edit2.getText().toString());
        editor.putString("SP22edittext3", SP22Edit3.getText().toString());

        Spinner SP22spinner1 = findViewById(R.id.Spinner11);
        editor.putInt("SP22spinner1", SP22spinner1.getSelectedItemPosition());
        EditText SP22Edit4 = findViewById(R.id.EditText13);
        editor.putString("SP22edittext4", SP22Edit4.getText().toString());
        Spinner SP22spinner2 = findViewById(R.id.Spinner09);
        editor.putInt("SP22spinner2", SP22spinner2.getSelectedItemPosition());
        EditText SP22Edit5 = findViewById(R.id.EditText19);
        editor.putString("SP22edittext5", SP22Edit5.getText().toString());

        SeekBar sb6 = findViewById(R.id.SeekBar03);
        editor.putInt("SP23seekbar", sb6.getProgress());
        nivel1(sb6.getProgress());

        EditText SP23Edit1 = findViewById(R.id.EditText09);
        EditText SP23Edit2 = findViewById(R.id.EditText10);
        EditText SP23Edit3 = findViewById(R.id.EditText22);
        editor.putString("SP23edittext1", SP23Edit1.getText().toString());
        editor.putString("SP23edittext2", SP23Edit2.getText().toString());
        editor.putString("SP23edittext3", SP23Edit3.getText().toString());

        Spinner SP23spinner1 = findViewById(R.id.Spinner10);
        editor.putInt("SP23spinner1", SP23spinner1.getSelectedItemPosition());
        EditText SP23Edit4 = findViewById(R.id.EditText15);
        editor.putString("SP23edittext4", SP23Edit4.getText().toString());
        Spinner SP23spinner2 = findViewById(R.id.Spinner08);
        editor.putInt("SP23spinner2", SP23spinner2.getSelectedItemPosition());
        EditText SP23Edit5 = findViewById(R.id.EditText20);
        editor.putString("SP23edittext5", SP23Edit5.getText().toString());
        Spinner SP23spinner3 = findViewById(R.id.Spinner07);
        editor.putInt("SP23spinner3", SP23spinner3.getSelectedItemPosition());
        EditText SP23Edit6 = findViewById(R.id.EditText21);
        editor.putString("SP23edittext6", SP23Edit6.getText().toString());
        Spinner SP23spinner4 = findViewById(R.id.Spinner12);
        editor.putInt("SP23spinner4", SP23spinner4.getSelectedItemPosition());
        EditText SP23Edit7 = findViewById(R.id.EditText24);
        editor.putString("SP23edittext7", SP23Edit7.getText().toString());
        Spinner SP23spinner5 = findViewById(R.id.Spinner13);
        editor.putInt("SP23spinner5", SP23spinner5.getSelectedItemPosition());
        EditText SP23Edit8 = findViewById(R.id.EditText25);
        editor.putString("SP23edittext8", SP23Edit8.getText().toString());

        SeekBar sb7 = findViewById(R.id.SeekBar06);
        editor.putInt("SP24seekbar", sb7.getProgress());
        nivel1(sb7.getProgress());

        EditText SP24Edit1 = findViewById(R.id.EditText47);
        EditText SP24Edit2 = findViewById(R.id.EditText48);
        EditText SP24Edit3 = findViewById(R.id.EditText38);
        editor.putString("SP24edittext1", SP24Edit1.getText().toString());
        editor.putString("SP24edittext2", SP24Edit2.getText().toString());
        editor.putString("SP24edittext3", SP24Edit3.getText().toString());

        Spinner SP24spinner1 = findViewById(R.id.Spinner26);
        editor.putInt("SP24spinner1", SP24spinner1.getSelectedItemPosition());
        EditText SP24Edit4 = findViewById(R.id.EditText44);
        editor.putString("SP24edittext4", SP24Edit4.getText().toString());
        Spinner SP24spinner2 = findViewById(R.id.Spinner28);
        editor.putInt("SP24spinner2", SP24spinner2.getSelectedItemPosition());
        EditText SP24Edit5 = findViewById(R.id.EditText46);
        editor.putString("SP24edittext5", SP24Edit5.getText().toString());

        //GG

        SeekBar sbgp21 = findViewById(R.id.sbgp21);
        editor.putInt("GP21seekbar", sbgp21.getProgress());
        nivel2(sbgp21.getProgress());

        EditText GP21Edit1 = findViewById(R.id.gp21et1);
        EditText GP21Edit2 = findViewById(R.id.gp21et2);
        EditText GP21Edit3 = findViewById(R.id.gp21et3);
        editor.putString("GP21edittext1", GP21Edit1.getText().toString());
        editor.putString("GP21edittext2", GP21Edit2.getText().toString());
        editor.putString("GP21edittext3", GP21Edit3.getText().toString());

        SeekBar sbgp22 = findViewById(R.id.sbgp22);
        editor.putInt("GP22seekbar", sbgp22.getProgress());
        nivel2(sbgp22.getProgress());

        EditText GP22Edit1 = findViewById(R.id.gp22et1);
        EditText GP22Edit2 = findViewById(R.id.gp22et2);
        EditText GP22Edit3 = findViewById(R.id.gp22et3);
        editor.putString("GP22edittext1", GP22Edit1.getText().toString());
        editor.putString("GP22edittext2", GP22Edit2.getText().toString());
        editor.putString("GP22edittext3", GP22Edit3.getText().toString());

        SeekBar sbgp23 = findViewById(R.id.sbgp23);
        editor.putInt("GP23seekbar", sbgp23.getProgress());
        nivel2(sbgp23.getProgress());

        EditText GP23Edit1 = findViewById(R.id.gp23et1);
        EditText GP23Edit2 = findViewById(R.id.gp23et2);
        EditText GP23Edit3 = findViewById(R.id.gp23et3);
        editor.putString("GP23edittext1", GP23Edit1.getText().toString());
        editor.putString("GP23edittext2", GP23Edit2.getText().toString());
        editor.putString("GP23edittext3", GP23Edit3.getText().toString());

        SeekBar sbgp24 = findViewById(R.id.sbgp24);
        editor.putInt("GP24seekbar", sbgp24.getProgress());
        nivel2(sbgp24.getProgress());

        EditText GP24Edit1 = findViewById(R.id.gp24et1);
        EditText GP24Edit2 = findViewById(R.id.gp24et2);
        EditText GP24Edit3 = findViewById(R.id.gp24et3);
        editor.putString("GP24edittext1", GP24Edit1.getText().toString());
        editor.putString("GP24edittext2", GP24Edit2.getText().toString());
        editor.putString("GP24edittext3", GP24Edit3.getText().toString());

        SeekBar sbgp25 = findViewById(R.id.sbgp25);
        editor.putInt("GP25seekbar", sbgp25.getProgress());
        nivel2(sbgp25.getProgress());

        EditText GP25Edit1 = findViewById(R.id.gp25et1);
        EditText GP25Edit2 = findViewById(R.id.gp25et2);
        EditText GP25Edit3 = findViewById(R.id.gp25et3);
        editor.putString("GP25edittext1", GP25Edit1.getText().toString());
        editor.putString("GP25edittext2", GP25Edit2.getText().toString());
        editor.putString("GP25edittext3", GP25Edit3.getText().toString());

        SeekBar sbgp26 = findViewById(R.id.sbgp26);
        editor.putInt("GP26seekbar", sbgp26.getProgress());
        nivel2(sbgp26.getProgress());

        EditText GP26Edit1 = findViewById(R.id.gp26et1);
        EditText GP26Edit2 = findViewById(R.id.gp26et2);
        EditText GP26Edit3 = findViewById(R.id.gp26et3);
        editor.putString("GP26edittext1", GP26Edit1.getText().toString());
        editor.putString("GP26edittext2", GP26Edit2.getText().toString());
        editor.putString("GP26edittext3", GP26Edit3.getText().toString());

        SeekBar sbgp27 = findViewById(R.id.sbgp27);
        editor.putInt("GP27seekbar", sbgp27.getProgress());
        nivel2(sbgp27.getProgress());

        EditText GP27Edit1 = findViewById(R.id.gp27et1);
        EditText GP27Edit2 = findViewById(R.id.gp27et2);
        EditText GP27Edit3 = findViewById(R.id.gp27et3);
        editor.putString("GP27edittext1", GP27Edit1.getText().toString());
        editor.putString("GP27edittext2", GP27Edit2.getText().toString());
        editor.putString("GP27edittext3", GP27Edit3.getText().toString());

        SeekBar sbgp28 = findViewById(R.id.sbgp28);
        editor.putInt("GP28seekbar", sbgp28.getProgress());
        nivel2(sbgp28.getProgress());

        EditText GP28Edit1 = findViewById(R.id.gp28et1);
        EditText GP28Edit2 = findViewById(R.id.gp28et2);
        EditText GP28Edit3 = findViewById(R.id.gp28et3);
        editor.putString("GP28edittext1", GP28Edit1.getText().toString());
        editor.putString("GP28edittext2", GP28Edit2.getText().toString());
        editor.putString("GP28edittext3", GP28Edit3.getText().toString());

        SeekBar sbgp29 = findViewById(R.id.sbgp29);
        editor.putInt("GP29seekbar", sbgp29.getProgress());
        nivel2(sbgp29.getProgress());

        EditText GP29Edit1 = findViewById(R.id.gp29et1);
        EditText GP29Edit2 = findViewById(R.id.gp29et2);
        EditText GP29Edit3 = findViewById(R.id.gp29et3);
        editor.putString("GP29edittext1", GP29Edit1.getText().toString());
        editor.putString("GP29edittext2", GP29Edit2.getText().toString());
        editor.putString("GP29edittext3", GP29Edit3.getText().toString());

        SeekBar sbgp210 = findViewById(R.id.sbgp210);
        editor.putInt("GP210seekbar", sbgp210.getProgress());
        nivel2(sbgp210.getProgress());

        EditText GP210Edit1 = findViewById(R.id.gp210et1);
        EditText GP210Edit2 = findViewById(R.id.gp210et2);
        EditText GP210Edit3 = findViewById(R.id.gp210et3);
        editor.putString("GP210edittext1", GP210Edit1.getText().toString());
        editor.putString("GP210edittext2", GP210Edit2.getText().toString());
        editor.putString("GP210edittext3", GP210Edit3.getText().toString());

        SeekBar sbgp31 = findViewById(R.id.sbgp31);
        editor.putInt("GP31seekbar", sbgp31.getProgress());
        nivel3(sbgp31.getProgress());

        EditText GP31Edit1 = findViewById(R.id.gp31et1);
        EditText GP31Edit2 = findViewById(R.id.gp31et2);
        EditText GP31Edit3 = findViewById(R.id.gp31et3);
        editor.putString("GP31edittext1", GP31Edit1.getText().toString());
        editor.putString("GP31edittext2", GP31Edit2.getText().toString());
        editor.putString("GP31edittext3", GP31Edit3.getText().toString());

        SeekBar sbgp32 = findViewById(R.id.sbgp32);
        editor.putInt("GP32seekbar", sbgp32.getProgress());
        nivel3(sbgp32.getProgress());

        EditText GP32Edit1 = findViewById(R.id.gp32et1);
        EditText GP32Edit2 = findViewById(R.id.gp32et2);
        EditText GP32Edit3 = findViewById(R.id.gp32et3);
        editor.putString("GP32edittext1", GP32Edit1.getText().toString());
        editor.putString("GP32edittext2", GP32Edit2.getText().toString());
        editor.putString("GP32edittext3", GP32Edit3.getText().toString());

        editor.putInt("nivel", nivel);

        editor.commit();
    }

    void nivel1(int i) {
        if (i < 2) {
            nivel = 0;
            b1 = false;
        }
    }

    void nivel2(int i) {
        if (i < 2 && b1 == true) {
            nivel = 1;
            b2 = false;
        }
    }

    void nivel3(int i) {
        if (i < 2 && b2 && b1) {
            nivel = 2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_configuracion);

        Intent intent = getIntent();
        indiceEvaluacion = intent.getIntExtra("indice", 0);

        int gestion_configuracion_1 = R.string.gestion_configuracion_SP11;
        int gestion_configuracion_2 = R.string.gestion_configuracion_SP11subpracticas;
        int gestion_configuracion_3 = R.string.gestion_configuracion_SP12;
        int gestion_configuracion_4 = R.string.gestion_configuracion_SP12subrpacticas;
        int gestion_configuracion_5 = R.string.gestion_configuracion_SP13;
        int gestion_configuracion_6 = R.string.gestion_configuracion_SP13subpracticas;
        int gestion_configuracion_7 = R.string.gestion_configuracion_SP21;
        int gestion_configuracion_8 = R.string.gestion_configuracion_SP21subpracticas;
        int gestion_configuracion_9 = R.string.gestion_configuracion_SP22;
        int gestion_configuracion_10 = R.string.gestion_configuracion_SP22subpracticas;
        int gestion_configuracion_11 = R.string.gestion_configuracion_SP31;
        int gestion_configuracion_12 = R.string.gestion_configuracion_SP31subpracticas;
        int gestion_configuracion_13 = R.string.gestion_configuracion_SP32;
        int gestion_configuracion_14 = R.string.gestion_configuracion_SP32subpracticas;

        //GG

        int gestion_configuracion_GP21 = R.string.generic_GP21;
        int gestion_configuracion_GP22 = R.string.generic_GP22;
        int gestion_configuracion_GP22s = R.string.generic_GP22subpracticas;
        int gestion_configuracion_GP23 = R.string.generic_GP23;
        int gestion_configuracion_GP24 = R.string.generic_GP24;
        int gestion_configuracion_GP24s = R.string.generic_GP24subpracticas;
        int gestion_configuracion_GP25 = R.string.generic_GP25;
        int gestion_configuracion_GP26 = R.string.generic_GP26;
        int gestion_configuracion_GP27 = R.string.generic_GP27;
        int gestion_configuracion_GP27s = R.string.generic_GP27subpracticas;
        int gestion_configuracion_GP28 = R.string.generic_GP28;
        int gestion_configuracion_GP28s = R.string.generic_GP28subpracticas;
        int gestion_configuracion_GP29 = R.string.generic_GP29;
        int gestion_configuracion_GP210 = R.string.generic_GP210;
        int gestion_configuracion_GP31 = R.string.generic_GP31;
        int gestion_configuracion_GP31s = R.string.generic_GP31subpracticas;
        int gestion_configuracion_GP32 = R.string.generic_GP32;
        int gestion_configuracion_GP32s = R.string.generic_GP32subpracticas;

        TextView tvsp11intro = findViewById(R.id.SP11Intro);
        TextView tvsp11subpracticas = findViewById(R.id.SP11Subpracticas);
        TextView tvsp12intro = findViewById(R.id.SP12Intro);
        TextView tvsp12subpracticas = findViewById(R.id.SP12Subpracticas);
        TextView tvsp13intro = findViewById(R.id.SP13Intro);
        TextView tvsp13subpracticas = findViewById(R.id.SP13Subpracticas);
        TextView tvsp21intro = findViewById(R.id.TextView13);
        TextView tvsp21subpracticas = findViewById(R.id.TextView14);
        TextView tvsp22intro = findViewById(R.id.TextView23);
        TextView tvsp22subpracticas = findViewById(R.id.TextView45);
        TextView tvsp31intro = findViewById(R.id.TextView19);
        TextView tvsp31subpracticas = findViewById(R.id.TextView17);
        TextView tvsp32intro = findViewById(R.id.TextView84);
        TextView tvsp32subpracticas = findViewById(R.id.TextView86);

        //GG

        TextView tvgp21intro = findViewById(R.id.gp21tv1);
        TextView tvgp22intro = findViewById(R.id.gp22tv1);
        TextView tvgp22subpracticas = findViewById(R.id.gp22tv8);
        TextView tvgp23intro = findViewById(R.id.gp23tv1);
        TextView tvgp24intro = findViewById(R.id.gp24tv1);
        TextView tvgp24subpracticas = findViewById(R.id.gp24tv8);
        TextView tvgp25intro = findViewById(R.id.gp25tv1);
        TextView tvgp26intro = findViewById(R.id.gp26tv1);
        TextView tvgp27intro = findViewById(R.id.gp27tv1);
        TextView tvgp27subpracticas = findViewById(R.id.gp27tv8);
        TextView tvgp28intro = findViewById(R.id.gp28tv1);
        TextView tvgp28subpracticas = findViewById(R.id.gp28tv8);
        TextView tvgp29intro = findViewById(R.id.gp29tv1);
        TextView tvgp210intro = findViewById(R.id.gp210tv1);
        TextView tvgp31intro = findViewById(R.id.gp31tv1);
        TextView tvgp31subpracticas = findViewById(R.id.gp31tv8);
        TextView tvgp32intro = findViewById(R.id.gp32tv1);
        TextView tvgp32subpracticas = findViewById(R.id.gp32tv8);

        tvsp11intro.setText(Html.fromHtml(getString(gestion_configuracion_1)));
        tvsp11subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_2)));
        tvsp12intro.setText(Html.fromHtml(getString(gestion_configuracion_3)));
        tvsp12subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_4)));
        tvsp13intro.setText(Html.fromHtml(getString(gestion_configuracion_5)));
        tvsp13subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_6)));
        tvsp21intro.setText(Html.fromHtml(getString(gestion_configuracion_7)));
        tvsp21subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_8)));
        tvsp22intro.setText(Html.fromHtml(getString(gestion_configuracion_9)));
        tvsp22subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_10)));
        tvsp31intro.setText(Html.fromHtml(getString(gestion_configuracion_11)));
        tvsp31subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_12)));
        tvsp32intro.setText(Html.fromHtml(getString(gestion_configuracion_13)));
        tvsp32subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_14)));

        //GG

        tvgp21intro.setText(Html.fromHtml(getString(gestion_configuracion_GP21)));
        tvgp22intro.setText(Html.fromHtml(getString(gestion_configuracion_GP22)));
        tvgp22subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_GP22s)));
        tvgp23intro.setText(Html.fromHtml(getString(gestion_configuracion_GP23)));
        tvgp24intro.setText(Html.fromHtml(getString(gestion_configuracion_GP24)));
        tvgp24subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_GP24s)));
        tvgp25intro.setText(Html.fromHtml(getString(gestion_configuracion_GP25)));
        tvgp26intro.setText(Html.fromHtml(getString(gestion_configuracion_GP26)));
        tvgp27intro.setText(Html.fromHtml(getString(gestion_configuracion_GP27)));
        tvgp27subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_GP27s)));
        tvgp28intro.setText(Html.fromHtml(getString(gestion_configuracion_GP28)));
        tvgp28subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_GP28s)));
        tvgp29intro.setText(Html.fromHtml(getString(gestion_configuracion_GP29)));
        tvgp210intro.setText(Html.fromHtml(getString(gestion_configuracion_GP210)));
        tvgp31intro.setText(Html.fromHtml(getString(gestion_configuracion_GP31)));
        tvgp31subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_GP31s)));
        tvgp32intro.setText(Html.fromHtml(getString(gestion_configuracion_GP32)));
        tvgp32subpracticas.setText(Html.fromHtml(getString(gestion_configuracion_GP32s)));

        Spinner spinner1 = findViewById(R.id.SP11EjemploInputSpinner);
        Spinner spinner2 = findViewById(R.id.Spinner01);
        Spinner spinner3 = findViewById(R.id.Spinner03);
        Spinner spinner4 = findViewById(R.id.Spinner04);
        Spinner spinner5 = findViewById(R.id.Spinner02);
        Spinner spinner6 = findViewById(R.id.Spinner05);
        Spinner spinner7 = findViewById(R.id.Spinner06);
        Spinner spinner8 = findViewById(R.id.Spinner11);
        Spinner spinner9 = findViewById(R.id.Spinner09);
        Spinner spinner10 = findViewById(R.id.Spinner10);
        Spinner spinner11 = findViewById(R.id.Spinner08);
        Spinner spinner12 = findViewById(R.id.Spinner07);
        Spinner spinner13 = findViewById(R.id.Spinner12);
        Spinner spinner14 = findViewById(R.id.Spinner26);
        Spinner spinner15 = findViewById(R.id.Spinner28);
        Spinner spinner16 = findViewById(R.id.Spinner13);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.example_work_products,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);
        spinner9.setAdapter(adapter);
        spinner10.setAdapter(adapter);
        spinner11.setAdapter(adapter);
        spinner12.setAdapter(adapter);
        spinner13.setAdapter(adapter);
        spinner14.setAdapter(adapter);
        spinner15.setAdapter(adapter);
        spinner16.setAdapter(adapter);

        SeekBar sb7 = findViewById(R.id.SeekBar06);
        sb7.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.TextView66);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        //GG

        SeekBar sbgp21 = findViewById(R.id.sbgp21);
        sbgp21.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp21tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp22 = findViewById(R.id.sbgp22);
        sbgp22.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp22tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp23 = findViewById(R.id.sbgp23);
        sbgp23.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp23tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp24 = findViewById(R.id.sbgp24);
        sbgp24.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp24tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp25 = findViewById(R.id.sbgp25);
        sbgp25.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp25tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp26 = findViewById(R.id.sbgp26);
        sbgp26.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp26tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp27 = findViewById(R.id.sbgp27);
        sbgp27.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp27tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp28 = findViewById(R.id.sbgp28);
        sbgp28.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp28tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp29 = findViewById(R.id.sbgp29);
        sbgp29.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp29tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp210 = findViewById(R.id.sbgp210);
        sbgp210.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp210tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp31 = findViewById(R.id.sbgp31);
        sbgp31.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp31tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sbgp32 = findViewById(R.id.sbgp32);
        sbgp32.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.gp32tv3);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        //SG

        SeekBar sb6 = findViewById(R.id.SeekBar03);
        sb6.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.TextView35);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sb5 = findViewById(R.id.SeekBar04);
        sb5.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.TextView27);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sb4 = findViewById(R.id.SeekBar02);
        sb4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.TextView18);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sb1 = findViewById(R.id.SP11Seekbar);
        TextView progresoBarra = findViewById(R.id.SP11AlcanceText2);

        if (sb1.getProgress() == 0) {
            progresoBarra.setText("No alcanzado");
        }

        if (sb1.getProgress() == 1) {
            progresoBarra.setText("Parcialmente alcanzado");
        }

        if (sb1.getProgress() == 2) {
            progresoBarra.setText("Ampliamente alcanzado");
        }

        if (sb1.getProgress() == 3) {
            progresoBarra.setText("Totalmente alcanzado");
        }

        sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.SP11AlcanceText2);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub
            }
        });

        SeekBar sb2 = findViewById(R.id.SP12Seekbar);
        sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.SP12AlcanceText2);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        SeekBar sb3 = findViewById(R.id.SeekBar01);
        sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                TextView progresoBarra = findViewById(R.id.SP13AlcanceText2);

                progress = arg1;

                if (progress == 0) {
                    progresoBarra.setText("No alcanzado");
                }

                if (progress == 1) {
                    progresoBarra.setText("Parcialmente alcanzado");
                }

                if (progress == 2) {
                    progresoBarra.setText("Ampliamente alcanzado");
                }

                if (progress == 3) {
                    progresoBarra.setText("Totalmente alcanzado");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }
        });

        ListView listViewAreas = findViewById(R.id.listView1);
        listViewAreas.setAdapter(new ItemAdapter(this, indiceEvaluacion));

        listViewAreas.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

                TextView text = arg1.findViewById(R.id.big_text);
                String area = text.getText().toString();

                if (area.equals("CM")) {

                }
                if (area.equals("MA")) {
                    Intent intent = new Intent(ConfigurationManagementActivity.this,
                            MeasurementAnalysisManagementActivity.class);
                    intent.putExtra("indice", indiceEvaluacion);
                    ConfigurationManagementActivity.this.startActivity(intent);
                }
                if (area.equals("PPQA")) {
                    Intent intent = new Intent(ConfigurationManagementActivity.this,
                            Aseguramiento_calidad_proceso_producto.class);
                    intent.putExtra("indice", indiceEvaluacion);
                    ConfigurationManagementActivity.this.startActivity(intent);
                }
                if (area.equals("PMC")) {
                    Intent intent = new Intent(ConfigurationManagementActivity.this,
                            Monitorizacion_control_proyecto.class);
                    intent.putExtra("indice", indiceEvaluacion);
                    ConfigurationManagementActivity.this.startActivity(intent);
                }
                if (area.equals("PP")) {
                    Intent intent = new Intent(ConfigurationManagementActivity.this,
                            Planificacion_proyecto.class);
                    intent.putExtra("indice", indiceEvaluacion);
                    ConfigurationManagementActivity.this.startActivity(intent);
                }
                if (area.equals("SAM")) {
                    Intent intent = new Intent(ConfigurationManagementActivity.this,
                            Gestion_acuerdos_proveedores.class);
                    intent.putExtra("indice", indiceEvaluacion);
                    ConfigurationManagementActivity.this.startActivity(intent);
                }
                if (area.equals("REQM")) {
                    Intent intent = new Intent(ConfigurationManagementActivity.this,
                            Gestion_requisitos.class);
                    intent.putExtra("indice", indiceEvaluacion);
                    ConfigurationManagementActivity.this.startActivity(intent);
                }
            }
        });

        Button botonAyuda = findViewById(R.id.button1);
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationManagementActivity.this,
                        HelpActivity.class);
                ConfigurationManagementActivity.this.startActivity(intent);

            }
        });

        //CARGAR DATOS DE EVALUACI�N

        SharedPreferences preferencias = getSharedPreferences(
                "gestion_configuracion_" + indiceEvaluacion, Context.MODE_PRIVATE);

        //SeekBar sb1 = (SeekBar) findViewById(R.id.SP11Seekbar);
        sb1.setProgress(preferencias.getInt("SP11seekbar", 0));

        EditText SP11Edit1 = findViewById(R.id.SP11NotasNotasEdit);
        EditText SP11Edit2 = findViewById(R.id.SP11NotasFortalezasEdit);
        EditText SP11Edit3 = findViewById(R.id.SP11NotasDebilidadesEdit);
        SP11Edit1.setText(preferencias.getString("SP11edittext1", ""));
        SP11Edit2.setText(preferencias.getString("SP11edittext2", ""));
        SP11Edit3.setText(preferencias.getString("SP11edittext3", ""));

        Spinner SP11spinner1 = findViewById(R.id.SP11EjemploInputSpinner);
        SP11spinner1.setSelection(preferencias.getInt("SP11spinner1", 0));
        EditText SP11Edit4 = findViewById(R.id.SP11EjemploInputText);
        SP11Edit4.setText(preferencias.getString("SP11edittext4", ""));

        //SeekBar sb2 = (SeekBar) findViewById(R.id.SP12Seekbar);
        sb2.setProgress(preferencias.getInt("SP12seekbar", 0));

        EditText SP12Edit1 = findViewById(R.id.SP12NotasEvaluacionEdit);
        EditText SP12Edit2 = findViewById(R.id.SP12NotasFortalezasEdit);
        EditText SP12Edit3 = findViewById(R.id.SP12NotasDebilidadesEdit);
        SP12Edit1.setText(preferencias.getString("SP12edittext1", ""));
        SP12Edit2.setText(preferencias.getString("SP12edittext2", ""));
        SP12Edit3.setText(preferencias.getString("SP12edittext3", ""));

        Spinner SP12spinner1 = findViewById(R.id.Spinner01);
        SP12spinner1.setSelection(preferencias.getInt("SP12spinner1", 0));
        EditText SP12Edit4 = findViewById(R.id.EditText01);
        SP12Edit4.setText(preferencias.getString("SP12edittext4", ""));
        Spinner SP12spinner2 = findViewById(R.id.Spinner03);
        SP12spinner2.setSelection(preferencias.getInt("SP12spinner2", 0));
        EditText SP12Edit5 = findViewById(R.id.EditText06);
        SP12Edit5.setText(preferencias.getString("SP12edittext5", ""));
        Spinner SP12spinner3 = findViewById(R.id.Spinner04);
        SP12spinner3.setSelection(preferencias.getInt("SP12spinner3", 0));
        EditText SP12Edit6 = findViewById(R.id.EditText07);
        SP12Edit6.setText(preferencias.getString("SP12edittext6", ""));

        //SeekBar sb3 = (SeekBar) findViewById(R.id.SeekBar01);
        sb3.setProgress(preferencias.getInt("SP13seekbar", 0));

        EditText SP13Edit1 = findViewById(R.id.EditText03);
        EditText SP13Edit2 = findViewById(R.id.EditText04);
        EditText SP13Edit3 = findViewById(R.id.EditText02);
        SP13Edit1.setText(preferencias.getString("SP13edittext1", ""));
        SP13Edit2.setText(preferencias.getString("SP13edittext2", ""));
        SP13Edit3.setText(preferencias.getString("SP13edittext3", ""));

        Spinner SP13spinner1 = findViewById(R.id.Spinner05);
        SP13spinner1.setSelection(preferencias.getInt("SP13spinner1", 0));
        EditText SP13Edit4 = findViewById(R.id.EditText08);
        SP13Edit4.setText(preferencias.getString("SP13edittext4", ""));

        Spinner SP13spinner2 = findViewById(R.id.Spinner02);
        SP13spinner2.setSelection(preferencias.getInt("SP13spinner2", 0));
        EditText SP13Edit5 = findViewById(R.id.EditText05);
        SP13Edit5.setText(preferencias.getString("SP13edittext5", ""));

        //SeekBar sb4 = (SeekBar) findViewById(R.id.SeekBar02);
        sb4.setProgress(preferencias.getInt("SP21seekbar", 0));

        EditText SP21Edit1 = findViewById(R.id.EditText17);
        EditText SP21Edit2 = findViewById(R.id.EditText18);
        EditText SP21Edit3 = findViewById(R.id.EditText16);
        SP21Edit1.setText(preferencias.getString("SP21edittext1", ""));
        SP21Edit2.setText(preferencias.getString("SP21edittext2", ""));
        SP21Edit3.setText(preferencias.getString("SP21edittext3", ""));

        Spinner SP21spinner1 = findViewById(R.id.Spinner06);
        SP21spinner1.setSelection(preferencias.getInt("SP21spinner1", 0));
        EditText SP21Edit4 = findViewById(R.id.EditText14);
        SP21Edit4.setText(preferencias.getString("SP21edittext4", ""));

        //SeekBar sb5 = (SeekBar) findViewById(R.id.SeekBar04);
        sb5.setProgress(preferencias.getInt("SP22seekbar", 0));

        EditText SP22Edit1 = findViewById(R.id.EditText12);
        EditText SP22Edit2 = findViewById(R.id.EditText11);
        EditText SP22Edit3 = findViewById(R.id.EditText23);
        SP22Edit1.setText(preferencias.getString("SP22edittext1", ""));
        SP22Edit2.setText(preferencias.getString("SP22edittext2", ""));
        SP22Edit3.setText(preferencias.getString("SP22edittext3", ""));

        Spinner SP22spinner1 = findViewById(R.id.Spinner11);
        SP22spinner1.setSelection(preferencias.getInt("SP22spinner1", 0));
        EditText SP22Edit4 = findViewById(R.id.EditText13);
        SP22Edit4.setText(preferencias.getString("SP22edittext4", ""));
        Spinner SP22spinner2 = findViewById(R.id.Spinner09);
        SP22spinner2.setSelection(preferencias.getInt("SP22spinner2", 0));
        EditText SP22Edit5 = findViewById(R.id.EditText19);
        SP22Edit5.setText(preferencias.getString("SP22edittext5", ""));

        sb6.setProgress(preferencias.getInt("SP23seekbar", 0));

        EditText SP23Edit1 = findViewById(R.id.EditText09);
        EditText SP23Edit2 = findViewById(R.id.EditText10);
        EditText SP23Edit3 = findViewById(R.id.EditText22);
        SP23Edit1.setText(preferencias.getString("SP23edittext1", ""));
        SP23Edit2.setText(preferencias.getString("SP23edittext2", ""));
        SP23Edit3.setText(preferencias.getString("SP23edittext3", ""));

        Spinner SP23spinner1 = findViewById(R.id.Spinner10);
        SP23spinner1.setSelection(preferencias.getInt("SP23spinner1", 0));
        EditText SP23Edit4 = findViewById(R.id.EditText15);
        SP23Edit4.setText(preferencias.getString("SP23edittext4", ""));
        Spinner SP23spinner2 = findViewById(R.id.Spinner08);
        SP23spinner2.setSelection(preferencias.getInt("SP23spinner2", 0));
        EditText SP23Edit5 = findViewById(R.id.EditText20);
        SP23Edit5.setText(preferencias.getString("SP23edittext5", ""));
        Spinner SP23spinner3 = findViewById(R.id.Spinner07);
        SP23spinner3.setSelection(preferencias.getInt("SP23spinner3", 0));
        EditText SP23Edit6 = findViewById(R.id.EditText21);
        SP23Edit6.setText(preferencias.getString("SP23edittext6", ""));
        Spinner SP23spinner4 = findViewById(R.id.Spinner12);
        SP23spinner4.setSelection(preferencias.getInt("SP23spinner4", 0));
        EditText SP23Edit7 = findViewById(R.id.EditText24);
        SP23Edit7.setText(preferencias.getString("SP23edittext7", ""));
        Spinner SP23spinner5 = findViewById(R.id.Spinner13);
        SP23spinner5.setSelection(preferencias.getInt("SP23spinner5", 0));
        EditText SP23Edit8 = findViewById(R.id.EditText25);
        SP23Edit8.setText(preferencias.getString("SP23edittext8", ""));

        //SeekBar sb7 = (SeekBar) findViewById(R.id.SeekBar06);
        sb7.setProgress(preferencias.getInt("SP24seekbar", 0));

        EditText SP24Edit1 = findViewById(R.id.EditText47);
        EditText SP24Edit2 = findViewById(R.id.EditText48);
        EditText SP24Edit3 = findViewById(R.id.EditText38);
        SP24Edit1.setText(preferencias.getString("SP24edittext1", ""));
        SP24Edit2.setText(preferencias.getString("SP24edittext2", ""));
        SP24Edit3.setText(preferencias.getString("SP24edittext3", ""));

        Spinner SP24spinner1 = findViewById(R.id.Spinner26);
        SP24spinner1.setSelection(preferencias.getInt("SP24spinner1", 0));
        EditText SP24Edit4 = findViewById(R.id.EditText44);
        SP24Edit4.setText(preferencias.getString("SP24edittext4", ""));
        Spinner SP24spinner2 = findViewById(R.id.Spinner28);
        SP24spinner2.setSelection(preferencias.getInt("SP24spinner2", 0));
        EditText SP24Edit5 = findViewById(R.id.EditText46);
        SP24Edit5.setText(preferencias.getString("SP24edittext5", ""));

        //GG

        sbgp21.setProgress(preferencias.getInt("GP21seekbar", 0));

        EditText GP21Edit1 = findViewById(R.id.gp21et1);
        EditText GP21Edit2 = findViewById(R.id.gp21et2);
        EditText GP21Edit3 = findViewById(R.id.gp21et3);
        GP21Edit1.setText(preferencias.getString("GP21edittext1", ""));
        GP21Edit2.setText(preferencias.getString("GP21edittext2", ""));
        GP21Edit3.setText(preferencias.getString("GP21edittext3", ""));

        sbgp22.setProgress(preferencias.getInt("GP22seekbar", 0));

        EditText GP22Edit1 = findViewById(R.id.gp22et1);
        EditText GP22Edit2 = findViewById(R.id.gp22et2);
        EditText GP22Edit3 = findViewById(R.id.gp22et3);
        GP22Edit1.setText(preferencias.getString("GP22edittext1", ""));
        GP22Edit2.setText(preferencias.getString("GP22edittext2", ""));
        GP22Edit3.setText(preferencias.getString("GP22edittext3", ""));

        sbgp23.setProgress(preferencias.getInt("GP23seekbar", 0));

        EditText GP23Edit1 = findViewById(R.id.gp23et1);
        EditText GP23Edit2 = findViewById(R.id.gp23et2);
        EditText GP23Edit3 = findViewById(R.id.gp23et3);
        GP23Edit1.setText(preferencias.getString("GP23edittext1", ""));
        GP23Edit2.setText(preferencias.getString("GP23edittext2", ""));
        GP23Edit3.setText(preferencias.getString("GP23edittext3", ""));

        sbgp24.setProgress(preferencias.getInt("GP24seekbar", 0));

        EditText GP24Edit1 = findViewById(R.id.gp24et1);
        EditText GP24Edit2 = findViewById(R.id.gp24et2);
        EditText GP24Edit3 = findViewById(R.id.gp24et3);
        GP24Edit1.setText(preferencias.getString("GP24edittext1", ""));
        GP24Edit2.setText(preferencias.getString("GP24edittext2", ""));
        GP24Edit3.setText(preferencias.getString("GP24edittext3", ""));

        sbgp25.setProgress(preferencias.getInt("GP25seekbar", 0));

        EditText GP25Edit1 = findViewById(R.id.gp25et1);
        EditText GP25Edit2 = findViewById(R.id.gp25et2);
        EditText GP25Edit3 = findViewById(R.id.gp25et3);
        GP25Edit1.setText(preferencias.getString("GP25edittext1", ""));
        GP25Edit2.setText(preferencias.getString("GP25edittext2", ""));
        GP25Edit3.setText(preferencias.getString("GP25edittext3", ""));

        sbgp26.setProgress(preferencias.getInt("GP26seekbar", 0));

        EditText GP26Edit1 = findViewById(R.id.gp26et1);
        EditText GP26Edit2 = findViewById(R.id.gp26et2);
        EditText GP26Edit3 = findViewById(R.id.gp26et3);
        GP26Edit1.setText(preferencias.getString("GP26edittext1", ""));
        GP26Edit2.setText(preferencias.getString("GP26edittext2", ""));
        GP26Edit3.setText(preferencias.getString("GP26edittext3", ""));

        sbgp27.setProgress(preferencias.getInt("GP27seekbar", 0));

        EditText GP27Edit1 = findViewById(R.id.gp27et1);
        EditText GP27Edit2 = findViewById(R.id.gp27et2);
        EditText GP27Edit3 = findViewById(R.id.gp27et3);
        GP27Edit1.setText(preferencias.getString("GP27edittext1", ""));
        GP27Edit2.setText(preferencias.getString("GP27edittext2", ""));
        GP27Edit3.setText(preferencias.getString("GP27edittext3", ""));

        sbgp28.setProgress(preferencias.getInt("GP28seekbar", 0));

        EditText GP28Edit1 = findViewById(R.id.gp28et1);
        EditText GP28Edit2 = findViewById(R.id.gp28et2);
        EditText GP28Edit3 = findViewById(R.id.gp28et3);
        GP28Edit1.setText(preferencias.getString("GP28edittext1", ""));
        GP28Edit2.setText(preferencias.getString("GP28edittext2", ""));
        GP28Edit3.setText(preferencias.getString("GP28edittext3", ""));

        sbgp29.setProgress(preferencias.getInt("GP29seekbar", 0));

        EditText GP29Edit1 = findViewById(R.id.gp29et1);
        EditText GP29Edit2 = findViewById(R.id.gp29et2);
        EditText GP29Edit3 = findViewById(R.id.gp29et3);
        GP29Edit1.setText(preferencias.getString("GP29edittext1", ""));
        GP29Edit2.setText(preferencias.getString("GP29edittext2", ""));
        GP29Edit3.setText(preferencias.getString("GP29edittext3", ""));

        sbgp210.setProgress(preferencias.getInt("GP210seekbar", 0));

        EditText GP210Edit1 = findViewById(R.id.gp210et1);
        EditText GP210Edit2 = findViewById(R.id.gp210et2);
        EditText GP210Edit3 = findViewById(R.id.gp210et3);
        GP210Edit1.setText(preferencias.getString("GP210edittext1", ""));
        GP210Edit2.setText(preferencias.getString("GP210edittext2", ""));
        GP210Edit3.setText(preferencias.getString("GP210edittext3", ""));

        sbgp31.setProgress(preferencias.getInt("GP31seekbar", 0));

        EditText GP31Edit1 = findViewById(R.id.gp31et1);
        EditText GP31Edit2 = findViewById(R.id.gp31et2);
        EditText GP31Edit3 = findViewById(R.id.gp31et3);
        GP31Edit1.setText(preferencias.getString("GP31edittext1", ""));
        GP31Edit2.setText(preferencias.getString("GP31edittext2", ""));
        GP31Edit3.setText(preferencias.getString("GP31edittext3", ""));

        sbgp32.setProgress(preferencias.getInt("GP32seekbar", 0));

        EditText GP32Edit1 = findViewById(R.id.gp32et1);
        EditText GP32Edit2 = findViewById(R.id.gp32et2);
        EditText GP32Edit3 = findViewById(R.id.gp32et3);
        GP32Edit1.setText(preferencias.getString("GP32edittext1", ""));
        GP32Edit2.setText(preferencias.getString("GP32edittext2", ""));
        GP32Edit3.setText(preferencias.getString("GP32edittext3", ""));

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gestion_configuracion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(ConfigurationManagementActivity.this,
                        AboutActivity.class);
                ConfigurationManagementActivity.this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public class ItemAdapter extends BaseAdapter {

        SQLiteDatabase database = helper.getReadableDatabase();

        String areas;
        List<String> lista = new ArrayList<String>();
        int index;
        int contador = 0;
        View view;
        TextView bigText;
        TextView littleText;
        String aux;

        LayoutInflater inflater;


        public ItemAdapter(Context context, int indice) {
            inflater = LayoutInflater.from(context);
            index = indice;

            Cursor cursor = database.rawQuery(
                    "SELECT * FROM Evaluaciones WHERE cod_ev = '" + indice + "'", null);
            cursor.moveToFirst();
            areas = cursor.getString(4);

            while (!(areas.length() == 0 || areas == "" || areas.isEmpty())) {
                index = areas.indexOf(",") + 1;
                aux = areas.substring(0, index);
                areas = areas.substring(index);
                lista.add(aux);
            }
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return lista.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (convertView == null) {
                String nombre = lista.get(contador);
                if (nombre.length() > 0 && nombre.charAt(nombre.length() - 1) == ',') {
                    nombre = nombre.substring(0, nombre.length() - 1);
                }
                if (contador < lista.size() - 1) {
                    contador++;
                }
                LayoutInflater layoutInflater = getLayoutInflater();
                view = layoutInflater.inflate(R.layout.list_item2, null);
                bigText = view.findViewById(R.id.big_text);
                bigText.setText(nombre);
                littleText = view.findViewById(R.id.little_text);
                littleText.setText("ejemplo");

                if (nombre.equals("CM")) {
                    littleText.setText("Gesti�n de la configuraci�n");
                    view.setBackgroundColor(Color.parseColor("#87CEFA"));
                } else if (nombre.equals("MA")) {
                    littleText.setText("Medici�n y an�lisis");
                } else if (nombre.equals("PMC")) {
                    littleText.setText("Monitorizaci�n y control del proyecto");
                } else if (nombre.equals("PP")) {
                    littleText.setText("Planificaci�n del proyecto");
                } else if (nombre.equals("PPQA")) {
                    littleText.setText("Aseguramiento de la calidad del proceso y del producto");
                } else if (nombre.equals("REQM")) {
                    littleText.setText("Gesti�n de requisitos");
                } else if (nombre.equals("SAM")) {
                    littleText.setText("Gesti�n de acuerdos con proveedores");
                }


            } else {
                view = convertView;

            }
            return view;
        }

        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.gestion_configuracion, menu);
            return true;
        }
    }
}

