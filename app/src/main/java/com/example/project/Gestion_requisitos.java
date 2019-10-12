package com.example.project;

import java.util.ArrayList;
import java.util.List;

import com.example.project.Gestion_configuracion.ItemAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Gestion_requisitos extends Activity {
	
	Intent intent = getIntent();
	int indiceEvaluacion;
	int nivel = 3;
	boolean b1 = true;
	boolean b2 = true;
	boolean b3 = true;
	GestorSQLiteHelper gestor = new GestorSQLiteHelper(this, "databasefile",
			null, 1);

	protected void onStop(){
		super.onStop();
		
		SharedPreferences preferencias = getSharedPreferences("gestion_requisitos_"+String.valueOf(indiceEvaluacion),Context.MODE_PRIVATE);
		SharedPreferences.Editor editorPreferencias = preferencias.edit();		
		
		SeekBar sb1 = (SeekBar) findViewById(R.id.SP11Seekbar);
		editorPreferencias.putInt("SP11seekbar", sb1.getProgress());
		nivel1(sb1.getProgress());
		
		EditText SP11Edit1 = (EditText) findViewById(R.id.SP11NotasNotasEdit);
		EditText SP11Edit2 = (EditText) findViewById(R.id.SP11NotasFortalezasEdit);
		EditText SP11Edit3 = (EditText) findViewById(R.id.SP11NotasDebilidadesEdit);
		editorPreferencias.putString("SP11edittext1", SP11Edit1.getText().toString());
		editorPreferencias.putString("SP11edittext2", SP11Edit2.getText().toString());
		editorPreferencias.putString("SP11edittext3", SP11Edit3.getText().toString());
		
		Spinner SP11spinner1 = (Spinner) findViewById (R.id.Spinner09);
		editorPreferencias.putInt("SP11spinner1", SP11spinner1.getSelectedItemPosition());
		EditText SP11Edit4 = (EditText) findViewById(R.id.EditText11);
		editorPreferencias.putString("SP11edittext4", SP11Edit4.getText().toString());
		Spinner SP11spinner2 = (Spinner) findViewById (R.id.Spinner08);
		editorPreferencias.putInt("SP11spinner2", SP11spinner2.getSelectedItemPosition());
		EditText SP11Edit5 = (EditText) findViewById(R.id.EditText10);
		editorPreferencias.putString("SP11edittext5", SP11Edit5.getText().toString());
		Spinner SP11spinner3 = (Spinner) findViewById (R.id.Spinner07);
		editorPreferencias.putInt("SP11spinner3", SP11spinner3.getSelectedItemPosition());
		EditText SP11Edit6 = (EditText) findViewById(R.id.EditText09);
		editorPreferencias.putString("SP11edittext6", SP11Edit6.getText().toString());
		Spinner SP11spinner4 = (Spinner) findViewById (R.id.SP11EjemploInputSpinner);
		editorPreferencias.putInt("SP11spinner4", SP11spinner4.getSelectedItemPosition());
		EditText SP11Edit7 = (EditText) findViewById(R.id.SP11EjemploInputText);
		editorPreferencias.putString("SP11edittext7", SP11Edit7.getText().toString());
		
		SeekBar sb2 = (SeekBar) findViewById(R.id.SP12Seekbar);
		editorPreferencias.putInt("SP12seekbar", sb2.getProgress());
		nivel1(sb2.getProgress());
		
		EditText SP12Edit1 = (EditText) findViewById(R.id.SP12NotasEvaluacionEdit);
		EditText SP12Edit2 = (EditText) findViewById(R.id.SP12NotasFortalezasEdit);
		EditText SP12Edit3 = (EditText) findViewById(R.id.SP12NotasDebilidadesEdit);
		editorPreferencias.putString("SP12edittext1", SP12Edit1.getText().toString());
		editorPreferencias.putString("SP12edittext2", SP12Edit2.getText().toString());
		editorPreferencias.putString("SP12edittext3", SP12Edit3.getText().toString());
		
		Spinner SP12spinner1 = (Spinner) findViewById (R.id.Spinner10);
		editorPreferencias.putInt("SP12spinner1", SP12spinner1.getSelectedItemPosition());
		EditText SP12Edit4 = (EditText) findViewById(R.id.EditText12);
		editorPreferencias.putString("SP12edittext4", SP12Edit4.getText().toString());
		Spinner SP12spinner2 = (Spinner) findViewById (R.id.Spinner01);
		editorPreferencias.putInt("SP12spinner2", SP12spinner2.getSelectedItemPosition());
		EditText SP12Edit5 = (EditText) findViewById(R.id.EditText01);
		editorPreferencias.putString("SP12edittext5", SP12Edit5.getText().toString());
		
		SeekBar sb3 = (SeekBar) findViewById(R.id.SeekBar01);
		editorPreferencias.putInt("SP13seekbar", sb3.getProgress());
		nivel1(sb3.getProgress());
		
		EditText SP13Edit1 = (EditText) findViewById(R.id.EditText03);
		EditText SP13Edit2 = (EditText) findViewById(R.id.EditText04);
		EditText SP13Edit3 = (EditText) findViewById(R.id.EditText02);
		editorPreferencias.putString("SP13edittext1", SP13Edit1.getText().toString());
		editorPreferencias.putString("SP13edittext2", SP13Edit2.getText().toString());
		editorPreferencias.putString("SP13edittext3", SP13Edit3.getText().toString());
		
		Spinner SP13spinner1 = (Spinner) findViewById (R.id.Spinner12);
		editorPreferencias.putInt("SP13spinner1", SP13spinner1.getSelectedItemPosition());
		EditText SP13Edit4 = (EditText) findViewById(R.id.EditText15);
		editorPreferencias.putString("SP13edittext4", SP13Edit4.getText().toString());
		Spinner SP13spinner2 = (Spinner) findViewById (R.id.Spinner11);
		editorPreferencias.putInt("SP13spinner2", SP13spinner2.getSelectedItemPosition());
		EditText SP13Edit5 = (EditText) findViewById(R.id.EditText13);
		editorPreferencias.putString("SP13edittext5", SP13Edit5.getText().toString());	
		Spinner SP13spinner3 = (Spinner) findViewById (R.id.Spinner05);
		editorPreferencias.putInt("SP13spinner3", SP13spinner3.getSelectedItemPosition());
		EditText SP13Edit6 = (EditText) findViewById(R.id.EditText08);
		editorPreferencias.putString("SP13edittext6", SP13Edit6.getText().toString());
		Spinner SP13spinner4 = (Spinner) findViewById (R.id.Spinner02);
		editorPreferencias.putInt("SP13spinner4", SP13spinner4.getSelectedItemPosition());
		EditText SP13Edit7 = (EditText) findViewById(R.id.EditText05);
		editorPreferencias.putString("SP13edittext7", SP13Edit7.getText().toString());
		
		SeekBar sb8 = (SeekBar) findViewById(R.id.SP14seekbar);
		editorPreferencias.putInt("SP14seekbar", sb8.getProgress());
		nivel1(sb8.getProgress());
		
		EditText SP14Edit1 = (EditText) findViewById(R.id.EditText26);
		EditText SP14Edit2 = (EditText) findViewById(R.id.EditText27);
		EditText SP14Edit3 = (EditText) findViewById(R.id.EditText07);
		editorPreferencias.putString("SP14edittext1", SP14Edit1.getText().toString());
		editorPreferencias.putString("SP14edittext2", SP14Edit2.getText().toString());
		editorPreferencias.putString("SP14edittext3", SP14Edit3.getText().toString());
		
		Spinner SP14spinner1 = (Spinner) findViewById (R.id.Spinner03);
		editorPreferencias.putInt("SP14spinner1", SP14spinner1.getSelectedItemPosition());
		EditText SP14Edit4 = (EditText) findViewById(R.id.EditText06);
		editorPreferencias.putString("SP14edittext4", SP14Edit4.getText().toString());
		Spinner SP14spinner2 = (Spinner) findViewById (R.id.Spinner04);
		editorPreferencias.putInt("SP14spinner2", SP14spinner2.getSelectedItemPosition());
		EditText SP14Edit5 = (EditText) findViewById(R.id.EditText28);
		editorPreferencias.putString("SP14edittext5", SP14Edit5.getText().toString());	
		
		SeekBar sb4 = (SeekBar) findViewById(R.id.SeekBar02);
		editorPreferencias.putInt("SP15seekbar", sb4.getProgress());
		nivel1(sb4.getProgress());
		
		EditText SP15Edit1 = (EditText) findViewById(R.id.EditText17);
		EditText SP15Edit2 = (EditText) findViewById(R.id.EditText18);
		EditText SP15Edit3 = (EditText) findViewById(R.id.EditText16);
		editorPreferencias.putString("SP15edittext1", SP15Edit1.getText().toString());
		editorPreferencias.putString("SP15edittext2", SP15Edit2.getText().toString());
		editorPreferencias.putString("SP15edittext3", SP15Edit3.getText().toString());
		
		Spinner SP15spinner1 = (Spinner) findViewById (R.id.Spinner06);
		editorPreferencias.putInt("SP15spinner1", SP15spinner1.getSelectedItemPosition());
		EditText SP15Edit4 = (EditText) findViewById(R.id.EditText14);
		editorPreferencias.putString("SP15edittext4", SP15Edit4.getText().toString());
		Spinner SP15spinner2 = (Spinner) findViewById (R.id.Spinner14);
		editorPreferencias.putInt("SP15spinner2", SP15spinner2.getSelectedItemPosition());
		EditText SP15Edit5 = (EditText) findViewById(R.id.EditText29);
		editorPreferencias.putString("SP15edittext5", SP15Edit5.getText().toString());
		
		//GG
		
				SeekBar sbgp21 = (SeekBar) findViewById(R.id.sbgp21);
				editorPreferencias.putInt("GP21seekbar", sbgp21.getProgress());
				nivel2(sbgp21.getProgress());
				
				EditText GP21Edit1 = (EditText) findViewById(R.id.gp21et1);
				EditText GP21Edit2 = (EditText) findViewById(R.id.gp21et2);
				EditText GP21Edit3 = (EditText) findViewById(R.id.gp21et3);
				editorPreferencias.putString("GP21edittext1", GP21Edit1.getText().toString());
				editorPreferencias.putString("GP21edittext2", GP21Edit2.getText().toString());
				editorPreferencias.putString("GP21edittext3", GP21Edit3.getText().toString());
				
				SeekBar sbgp22 = (SeekBar) findViewById(R.id.sbgp22);
				editorPreferencias.putInt("GP22seekbar", sbgp22.getProgress());
				nivel2(sbgp22.getProgress());
				
				EditText GP22Edit1 = (EditText) findViewById(R.id.gp22et1);
				EditText GP22Edit2 = (EditText) findViewById(R.id.gp22et2);
				EditText GP22Edit3 = (EditText) findViewById(R.id.gp22et3);
				editorPreferencias.putString("GP22edittext1", GP22Edit1.getText().toString());
				editorPreferencias.putString("GP22edittext2", GP22Edit2.getText().toString());
				editorPreferencias.putString("GP22edittext3", GP22Edit3.getText().toString());
				
				
				SeekBar sbgp23 = (SeekBar) findViewById(R.id.sbgp23);
				editorPreferencias.putInt("GP23seekbar", sbgp23.getProgress());
				nivel2(sbgp23.getProgress());
				
				EditText GP23Edit1 = (EditText) findViewById(R.id.gp23et1);
				EditText GP23Edit2 = (EditText) findViewById(R.id.gp23et2);
				EditText GP23Edit3 = (EditText) findViewById(R.id.gp23et3);
				editorPreferencias.putString("GP23edittext1", GP23Edit1.getText().toString());
				editorPreferencias.putString("GP23edittext2", GP23Edit2.getText().toString());
				editorPreferencias.putString("GP23edittext3", GP23Edit3.getText().toString());
				
				
				SeekBar sbgp24 = (SeekBar) findViewById(R.id.sbgp24);
				editorPreferencias.putInt("GP24seekbar", sbgp24.getProgress());
				nivel2(sbgp24.getProgress());
				
				EditText GP24Edit1 = (EditText) findViewById(R.id.gp24et1);
				EditText GP24Edit2 = (EditText) findViewById(R.id.gp24et2);
				EditText GP24Edit3 = (EditText) findViewById(R.id.gp24et3);
				editorPreferencias.putString("GP24edittext1", GP24Edit1.getText().toString());
				editorPreferencias.putString("GP24edittext2", GP24Edit2.getText().toString());
				editorPreferencias.putString("GP24edittext3", GP24Edit3.getText().toString());
				
				
				SeekBar sbgp25 = (SeekBar) findViewById(R.id.sbgp25);
				editorPreferencias.putInt("GP25seekbar", sbgp25.getProgress());
				nivel2(sbgp25.getProgress());
				
				EditText GP25Edit1 = (EditText) findViewById(R.id.gp25et1);
				EditText GP25Edit2 = (EditText) findViewById(R.id.gp25et2);
				EditText GP25Edit3 = (EditText) findViewById(R.id.gp25et3);
				editorPreferencias.putString("GP25edittext1", GP25Edit1.getText().toString());
				editorPreferencias.putString("GP25edittext2", GP25Edit2.getText().toString());
				editorPreferencias.putString("GP25edittext3", GP25Edit3.getText().toString());
				
				
				SeekBar sbgp26 = (SeekBar) findViewById(R.id.sbgp26);
				editorPreferencias.putInt("GP26seekbar", sbgp26.getProgress());
				nivel2(sbgp26.getProgress());
				
				EditText GP26Edit1 = (EditText) findViewById(R.id.gp26et1);
				EditText GP26Edit2 = (EditText) findViewById(R.id.gp26et2);
				EditText GP26Edit3 = (EditText) findViewById(R.id.gp26et3);
				editorPreferencias.putString("GP26edittext1", GP26Edit1.getText().toString());
				editorPreferencias.putString("GP26edittext2", GP26Edit2.getText().toString());
				editorPreferencias.putString("GP26edittext3", GP26Edit3.getText().toString());
				
				
				SeekBar sbgp27 = (SeekBar) findViewById(R.id.sbgp27);
				editorPreferencias.putInt("GP27seekbar", sbgp27.getProgress());
				nivel2(sbgp27.getProgress());
				
				EditText GP27Edit1 = (EditText) findViewById(R.id.gp27et1);
				EditText GP27Edit2 = (EditText) findViewById(R.id.gp27et2);
				EditText GP27Edit3 = (EditText) findViewById(R.id.gp27et3);
				editorPreferencias.putString("GP27edittext1", GP27Edit1.getText().toString());
				editorPreferencias.putString("GP27edittext2", GP27Edit2.getText().toString());
				editorPreferencias.putString("GP27edittext3", GP27Edit3.getText().toString());
				
				
				SeekBar sbgp28 = (SeekBar) findViewById(R.id.sbgp28);
				editorPreferencias.putInt("GP28seekbar", sbgp28.getProgress());
				nivel2(sbgp28.getProgress());
				
				EditText GP28Edit1 = (EditText) findViewById(R.id.gp28et1);
				EditText GP28Edit2 = (EditText) findViewById(R.id.gp28et2);
				EditText GP28Edit3 = (EditText) findViewById(R.id.gp28et3);
				editorPreferencias.putString("GP28edittext1", GP28Edit1.getText().toString());
				editorPreferencias.putString("GP28edittext2", GP28Edit2.getText().toString());
				editorPreferencias.putString("GP28edittext3", GP28Edit3.getText().toString());
				
				
				SeekBar sbgp29 = (SeekBar) findViewById(R.id.sbgp29);
				editorPreferencias.putInt("GP29seekbar", sbgp29.getProgress());
				nivel2(sbgp29.getProgress());
				
				EditText GP29Edit1 = (EditText) findViewById(R.id.gp29et1);
				EditText GP29Edit2 = (EditText) findViewById(R.id.gp29et2);
				EditText GP29Edit3 = (EditText) findViewById(R.id.gp29et3);
				editorPreferencias.putString("GP29edittext1", GP29Edit1.getText().toString());
				editorPreferencias.putString("GP29edittext2", GP29Edit2.getText().toString());
				editorPreferencias.putString("GP29edittext3", GP29Edit3.getText().toString());
				
				
				SeekBar sbgp210 = (SeekBar) findViewById(R.id.sbgp210);
				editorPreferencias.putInt("GP210seekbar", sbgp210.getProgress());
				nivel2(sbgp210.getProgress());
				
				EditText GP210Edit1 = (EditText) findViewById(R.id.gp210et1);
				EditText GP210Edit2 = (EditText) findViewById(R.id.gp210et2);
				EditText GP210Edit3 = (EditText) findViewById(R.id.gp210et3);
				editorPreferencias.putString("GP210edittext1", GP210Edit1.getText().toString());
				editorPreferencias.putString("GP210edittext2", GP210Edit2.getText().toString());
				editorPreferencias.putString("GP210edittext3", GP210Edit3.getText().toString());
				
				
				SeekBar sbgp31 = (SeekBar) findViewById(R.id.sbgp31);
				editorPreferencias.putInt("GP31seekbar", sbgp31.getProgress());
				nivel3(sbgp31.getProgress());
				
				EditText GP31Edit1 = (EditText) findViewById(R.id.gp31et1);
				EditText GP31Edit2 = (EditText) findViewById(R.id.gp31et2);
				EditText GP31Edit3 = (EditText) findViewById(R.id.gp31et3);
				editorPreferencias.putString("GP31edittext1", GP31Edit1.getText().toString());
				editorPreferencias.putString("GP31edittext2", GP31Edit2.getText().toString());
				editorPreferencias.putString("GP31edittext3", GP31Edit3.getText().toString());
				
				
				SeekBar sbgp32 = (SeekBar) findViewById(R.id.sbgp32);
				editorPreferencias.putInt("GP32seekbar", sbgp32.getProgress());
				nivel3(sbgp32.getProgress());
				
				EditText GP32Edit1 = (EditText) findViewById(R.id.gp32et1);
				EditText GP32Edit2 = (EditText) findViewById(R.id.gp32et2);
				EditText GP32Edit3 = (EditText) findViewById(R.id.gp32et3);
				editorPreferencias.putString("GP32edittext1", GP32Edit1.getText().toString());
				editorPreferencias.putString("GP32edittext2", GP32Edit2.getText().toString());
				editorPreferencias.putString("GP32edittext3", GP32Edit3.getText().toString());
		
				editorPreferencias.putInt("nivel", nivel);
				
		editorPreferencias.commit();
	}
	
	void nivel1 (int i){
		if (i < 2){
			nivel = 0;
			b1 = false;
		}
	}
	
	void nivel2 (int i){
		if (i < 2 && b1 == true){
			nivel = 1;
			b2 = false;
		}
	}
	
	void nivel3 (int i){
		if (i < 2 && b2 == true && b1 == true){
			nivel = 2;
		}
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestion_requisitos);
		
		Intent intent = getIntent();
		indiceEvaluacion = intent.getIntExtra("indice", 0);

	int gestion_requisitos_1 = R.string.gestion_requisitos_SP11;
	int gestion_requisitos_2 = R.string.gestion_requisitos_SP11subpracticas;
	int gestion_requisitos_3 = R.string.gestion_requisitos_SP12;
	int gestion_requisitos_4 = R.string.gestion_requisitos_SP12subpracticas;
	int gestion_requisitos_5 = R.string.gestion_requisitos_SP13;
	int gestion_requisitos_6 = R.string.gestion_requisitos_SP13subpracticas;
	int gestion_requisitos_7 = R.string.gestion_requisitos_SP14;
	int gestion_requisitos_8 = R.string.gestion_requisitos_SP14subpracticas;
	int gestion_requisitos_9 = R.string.gestion_requisitos_SP15;
	int gestion_requisitos_10 = R.string.gestion_requisitos_SP15subpracticas;
	
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
	
	TextView tvsp11intro = (TextView) findViewById(R.id.SP11Intro);
	TextView tvsp11subpracticas = (TextView) findViewById(R.id.SP11Subpracticas);
	TextView tvsp12intro = (TextView) findViewById(R.id.SP12Intro);
	TextView tvsp12subpracticas = (TextView) findViewById(R.id.SP12Subpracticas);
	TextView tvsp13intro = (TextView) findViewById(R.id.SP13Intro);
	TextView tvsp13subpracticas = (TextView) findViewById(R.id.SP13Subpracticas);
	TextView tvsp14intro = (TextView) findViewById(R.id.TextView08);
	TextView tvsp14subpracticas = (TextView) findViewById(R.id.TextView04);
	TextView tvsp15intro = (TextView) findViewById(R.id.TextView13);
	TextView tvsp15subpracticas = (TextView) findViewById(R.id.TextView14);
	
	//GG
	
	TextView tvgp21intro = (TextView) findViewById(R.id.gp21tv1);
	TextView tvgp22intro = (TextView) findViewById(R.id.gp22tv1);
	TextView tvgp22subpracticas = (TextView) findViewById(R.id.gp22tv8);
	TextView tvgp23intro = (TextView) findViewById(R.id.gp23tv1);
	TextView tvgp24intro = (TextView) findViewById(R.id.gp24tv1);
	TextView tvgp24subpracticas = (TextView) findViewById(R.id.gp24tv8);
	TextView tvgp25intro = (TextView) findViewById(R.id.gp25tv1);
	TextView tvgp26intro = (TextView) findViewById(R.id.gp26tv1);
	TextView tvgp27intro = (TextView) findViewById(R.id.gp27tv1);
	TextView tvgp27subpracticas = (TextView) findViewById(R.id.gp27tv8);
	TextView tvgp28intro = (TextView) findViewById(R.id.gp28tv1);
	TextView tvgp28subpracticas = (TextView) findViewById(R.id.gp28tv8);
	TextView tvgp29intro = (TextView) findViewById(R.id.gp29tv1);
	TextView tvgp210intro = (TextView) findViewById(R.id.gp210tv1);
	TextView tvgp31intro = (TextView) findViewById(R.id.gp31tv1);
	TextView tvgp31subpracticas = (TextView) findViewById(R.id.gp31tv8);
	TextView tvgp32intro = (TextView) findViewById(R.id.gp32tv1);
	TextView tvgp32subpracticas = (TextView) findViewById(R.id.gp32tv8);

	tvsp11intro.setText(Html.fromHtml(getString(gestion_requisitos_1)));
	tvsp11subpracticas.setText(Html.fromHtml(getString(gestion_requisitos_2)));
	tvsp12intro.setText(Html.fromHtml(getString(gestion_requisitos_3)));
	tvsp12subpracticas.setText(Html.fromHtml(getString(gestion_requisitos_4)));
	tvsp13intro.setText(Html.fromHtml(getString(gestion_requisitos_5)));
	tvsp13subpracticas.setText(Html.fromHtml(getString(gestion_requisitos_6)));
	tvsp14intro.setText(Html.fromHtml(getString(gestion_requisitos_7)));
	tvsp14subpracticas.setText(Html.fromHtml(getString(gestion_requisitos_8)));
	tvsp15intro.setText(Html.fromHtml(getString(gestion_requisitos_9)));
	tvsp15subpracticas.setText(Html.fromHtml(getString(gestion_requisitos_10)));
	
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
	
	Spinner spinner1 = (Spinner) findViewById (R.id.Spinner09);
	Spinner spinner2 = (Spinner) findViewById (R.id.Spinner08);
	Spinner spinner3 = (Spinner) findViewById (R.id.Spinner07);
	Spinner spinner4 = (Spinner) findViewById (R.id.SP11EjemploInputSpinner);
	Spinner spinner5 = (Spinner) findViewById (R.id.Spinner10);
	Spinner spinner6 = (Spinner) findViewById (R.id.Spinner01);
	Spinner spinner7 = (Spinner) findViewById (R.id.Spinner12);
	Spinner spinner8 = (Spinner) findViewById (R.id.Spinner11);
	Spinner spinner10 = (Spinner) findViewById (R.id.Spinner05);
	Spinner spinner14 = (Spinner) findViewById (R.id.Spinner02);
	Spinner spinner15 = (Spinner) findViewById (R.id.Spinner03);
	Spinner spinner17 = (Spinner) findViewById (R.id.Spinner04);
	Spinner spinner18 = (Spinner) findViewById (R.id.Spinner06);
	Spinner spinner19 = (Spinner) findViewById (R.id.Spinner14);
	
	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.example_work_products, android.R.layout.simple_spinner_item);
	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner1.setAdapter(adapter);
	spinner2.setAdapter(adapter);
	spinner3.setAdapter(adapter);
	spinner4.setAdapter(adapter);
	spinner5.setAdapter(adapter);
	spinner6.setAdapter(adapter);
	spinner7.setAdapter(adapter);
	spinner8.setAdapter(adapter);
	spinner10.setAdapter(adapter);
	spinner14.setAdapter(adapter);
	spinner15.setAdapter(adapter);
	spinner17.setAdapter(adapter);
	spinner18.setAdapter(adapter);
	spinner19.setAdapter(adapter);
	
	//GG
	
	
			SeekBar sbgp21 = (SeekBar) findViewById(R.id.sbgp21);
			sbgp21.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp21tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp22 = (SeekBar) findViewById(R.id.sbgp22);
			sbgp22.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp22tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp23 = (SeekBar) findViewById(R.id.sbgp23);
			sbgp23.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp23tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp24 = (SeekBar) findViewById(R.id.sbgp24);
			sbgp24.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp24tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp25 = (SeekBar) findViewById(R.id.sbgp25);
			sbgp25.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp25tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp26 = (SeekBar) findViewById(R.id.sbgp26);
			sbgp26.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp26tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp27 = (SeekBar) findViewById(R.id.sbgp27);
			sbgp27.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp27tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp28 = (SeekBar) findViewById(R.id.sbgp28);
			sbgp28.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp28tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp29 = (SeekBar) findViewById(R.id.sbgp29);
			sbgp29.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp29tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp210 = (SeekBar) findViewById(R.id.sbgp210);
			sbgp210.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp210tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp31 = (SeekBar) findViewById(R.id.sbgp31);
			sbgp31.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp31tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
			
			SeekBar sbgp32 = (SeekBar) findViewById(R.id.sbgp32);
			sbgp32.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
				int progress;

				@Override
				public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
					// TODO Auto-generated method stub
					TextView progresoBarra = (TextView) findViewById(R.id.gp32tv3);
					
					progress = arg1;
					
					if (progress == 0){
						progresoBarra.setText("No alcanzado");	
					}

					if (progress == 1){
						progresoBarra.setText("Parcialmente alcanzado");	
					}
					
					if (progress == 2){
						progresoBarra.setText("Ampliamente alcanzado");	
					}
					
					if (progress == 3){
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
	
	SeekBar sb1 = (SeekBar) findViewById(R.id.SP11Seekbar);
	sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
		int progress;

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			TextView progresoBarra = (TextView) findViewById(R.id.SP11AlcanceText2);
			
			progress = arg1;
			
			if (progress == 0){
				progresoBarra.setText("No alcanzado");	
			}

			if (progress == 1){
				progresoBarra.setText("Parcialmente alcanzado");	
			}
			
			if (progress == 2){
				progresoBarra.setText("Ampliamente alcanzado");	
			}
			
			if (progress == 3){
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
	
	SeekBar sb2 = (SeekBar) findViewById(R.id.SP12Seekbar);
	sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
		int progress;

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			TextView progresoBarra = (TextView) findViewById(R.id.SP12AlcanceText2);
			
			progress = arg1;
			
			if (progress == 0){
				progresoBarra.setText("No alcanzado");	
			}

			if (progress == 1){
				progresoBarra.setText("Parcialmente alcanzado");	
			}
			
			if (progress == 2){
				progresoBarra.setText("Ampliamente alcanzado");	
			}
			
			if (progress == 3){
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
	
	SeekBar sb3 = (SeekBar) findViewById(R.id.SeekBar01);
	sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
		int progress;

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			TextView progresoBarra = (TextView) findViewById(R.id.SP13AlcanceText2);
			
			progress = arg1;
			
			if (progress == 0){
				progresoBarra.setText("No alcanzado");	
			}

			if (progress == 1){
				progresoBarra.setText("Parcialmente alcanzado");	
			}
			
			if (progress == 2){
				progresoBarra.setText("Ampliamente alcanzado");	
			}
			
			if (progress == 3){
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
	
	SeekBar sb4 = (SeekBar) findViewById(R.id.SP14seekbar);
	sb4.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
		int progress;

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			TextView progresoBarra = (TextView) findViewById(R.id.TextView51);
			
			progress = arg1;
			
			if (progress == 0){
				progresoBarra.setText("No alcanzado");	
			}

			if (progress == 1){
				progresoBarra.setText("Parcialmente alcanzado");	
			}
			
			if (progress == 2){
				progresoBarra.setText("Ampliamente alcanzado");	
			}
			
			if (progress == 3){
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
	
	SeekBar sb5 = (SeekBar) findViewById(R.id.SeekBar02);
	sb5.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
		int progress;

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			TextView progresoBarra = (TextView) findViewById(R.id.TextView18);
			
			progress = arg1;
			
			if (progress == 0){
				progresoBarra.setText("No alcanzado");	
			}

			if (progress == 1){
				progresoBarra.setText("Parcialmente alcanzado");	
			}
			
			if (progress == 2){
				progresoBarra.setText("Ampliamente alcanzado");	
			}
			
			if (progress == 3){
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
			
	ListView listViewAreas = (ListView) findViewById(R.id.listView1);
	listViewAreas.setAdapter(new ItemAdapter(this, indiceEvaluacion));
	
	listViewAreas.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub

			TextView text = (TextView) arg1.findViewById(R.id.big_text);
			String area = text.getText().toString();
			
			if (area.equals("CM")){
				Intent intent = new Intent(Gestion_requisitos.this,
						Gestion_configuracion.class);
				intent.putExtra("indice", indiceEvaluacion);
				Gestion_requisitos.this.startActivity(intent);
			}
			if (area.equals("MA")){
				Intent intent = new Intent(Gestion_requisitos.this,
						Medicion_analisis.class);
				intent.putExtra("indice", indiceEvaluacion);
				Gestion_requisitos.this.startActivity(intent);
			}
			if (area.equals("PPQA")){
				Intent intent = new Intent(Gestion_requisitos.this,
						Aseguramiento_calidad_proceso_producto.class);
				intent.putExtra("indice", indiceEvaluacion );
				Gestion_requisitos.this.startActivity(intent);
			}
			if (area.equals("PMC")){
				Intent intent = new Intent(Gestion_requisitos.this,
						Monitorizacion_control_proyecto.class);
				intent.putExtra("indice", indiceEvaluacion );
				Gestion_requisitos.this.startActivity(intent);
			}
			if (area.equals("PP")){
				Intent intent = new Intent(Gestion_requisitos.this,
						Planificacion_proyecto.class);
				intent.putExtra("indice",indiceEvaluacion );
				Gestion_requisitos.this.startActivity(intent);
			}
			if (area.equals("SAM")){
				Intent intent = new Intent(Gestion_requisitos.this,
						Gestion_acuerdos_proveedores.class);
				intent.putExtra("indice", indiceEvaluacion );
				Gestion_requisitos.this.startActivity(intent);
			}
			if (area.equals("REQM")){

			}
		}
	});
	
	Button botonAyuda = (Button) findViewById (R.id.button1);
	botonAyuda.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Gestion_requisitos.this,
					Ayuda_CMMI.class);
			Gestion_requisitos.this.startActivity(intent);
		}
	});
	
	
	//CARGAR DATOS DE EVALUACIÓN
	
			SharedPreferences preferencias = getSharedPreferences("gestion_requisitos_"+String.valueOf(indiceEvaluacion),Context.MODE_PRIVATE);	
			
			//SeekBar sb1 = (SeekBar) findViewById(R.id.SP11Seekbar);
			sb1.setProgress(preferencias.getInt("SP11seekbar", 0));
			
			EditText SP11Edit1 = (EditText) findViewById(R.id.SP11NotasNotasEdit);
			EditText SP11Edit2 = (EditText) findViewById(R.id.SP11NotasFortalezasEdit);
			EditText SP11Edit3 = (EditText) findViewById(R.id.SP11NotasDebilidadesEdit);
			SP11Edit1.setText(preferencias.getString("SP11edittext1", ""));
			SP11Edit2.setText(preferencias.getString("SP11edittext2", ""));
			SP11Edit3.setText(preferencias.getString("SP11edittext3", ""));
			
			Spinner SP11spinner1 = (Spinner) findViewById (R.id.Spinner09);
			SP11spinner1.setSelection(preferencias.getInt("SP11spinner1", 0));
			EditText SP11Edit4 = (EditText) findViewById(R.id.EditText11);
			SP11Edit4.setText(preferencias.getString("SP11edittext4", ""));		
			Spinner SP11spinner2 = (Spinner) findViewById (R.id.Spinner08);
			SP11spinner2.setSelection(preferencias.getInt("SP12spinner1", 0));
			EditText SP11Edit5 = (EditText) findViewById(R.id.EditText10);
			SP11Edit5.setText(preferencias.getString("SP12edittext4", ""));		
			Spinner SP11spinner3 = (Spinner) findViewById (R.id.Spinner07);
			SP11spinner3.setSelection(preferencias.getInt("SP13spinner1", 0));
			EditText SP11Edit6 = (EditText) findViewById(R.id.EditText09);
			SP11Edit6.setText(preferencias.getString("SP13edittext4", ""));		
			Spinner SP11spinner4 = (Spinner) findViewById (R.id.SP11EjemploInputSpinner);
			SP11spinner4.setSelection(preferencias.getInt("SP14spinner1", 0));
			EditText SP11Edit7 = (EditText) findViewById(R.id.SP11EjemploInputText);
			SP11Edit7.setText(preferencias.getString("SP14edittext4", ""));		
			
			//SeekBar sb2 = (SeekBar) findViewById(R.id.SP12Seekbar);
			sb2.setProgress(preferencias.getInt("SP12seekbar", 0));
					
			EditText SP12Edit1 = (EditText) findViewById(R.id.SP12NotasEvaluacionEdit);
			EditText SP12Edit2 = (EditText) findViewById(R.id.SP12NotasFortalezasEdit);
			EditText SP12Edit3 = (EditText) findViewById(R.id.SP12NotasDebilidadesEdit);
			SP12Edit1.setText(preferencias.getString("SP12edittext1", ""));
			SP12Edit2.setText(preferencias.getString("SP12edittext2", ""));
			SP12Edit3.setText(preferencias.getString("SP12edittext3", ""));
			
			Spinner SP12spinner1 = (Spinner) findViewById (R.id.Spinner10);
			SP12spinner1.setSelection(preferencias.getInt("SP12spinner1", 0));		
			EditText SP12Edit4 = (EditText) findViewById(R.id.EditText12);
			SP12Edit4.setText(preferencias.getString("SP12edittext4", ""));
			Spinner SP12spinner2 = (Spinner) findViewById (R.id.Spinner01);
			SP12spinner2.setSelection(preferencias.getInt("SP12spinner2", 0));		
			EditText SP12Edit5 = (EditText) findViewById(R.id.EditText01);
			SP12Edit5.setText(preferencias.getString("SP12edittext5", ""));
			
			//SeekBar sb3 = (SeekBar) findViewById(R.id.SeekBar01);
			sb3.setProgress(preferencias.getInt("SP13seekbar", 0));
			
			EditText SP13Edit1 = (EditText) findViewById(R.id.EditText03);
			EditText SP13Edit2 = (EditText) findViewById(R.id.EditText04);
			EditText SP13Edit3 = (EditText) findViewById(R.id.EditText02);
			SP13Edit1.setText(preferencias.getString("SP13edittext1", ""));
			SP13Edit2.setText(preferencias.getString("SP13edittext2", ""));
			SP13Edit3.setText(preferencias.getString("SP13edittext3", ""));
			
			Spinner SP13spinner1 = (Spinner) findViewById (R.id.Spinner12);
			SP13spinner1.setSelection(preferencias.getInt("SP13spinner1", 0));
			EditText SP13Edit4 = (EditText) findViewById(R.id.EditText15);
			SP13Edit4.setText(preferencias.getString("SP13edittext4", ""));
			Spinner SP13spinner2 = (Spinner) findViewById (R.id.Spinner11);
			SP13spinner2.setSelection(preferencias.getInt("SP13spinner2", 0));
			EditText SP13Edit5 = (EditText) findViewById(R.id.EditText13);
			SP13Edit5.setText(preferencias.getString("SP13edittext5", ""));
			Spinner SP13spinner3 = (Spinner) findViewById (R.id.Spinner05);
			SP13spinner3.setSelection(preferencias.getInt("SP13spinner3", 0));
			EditText SP13Edit6 = (EditText) findViewById(R.id.EditText08);
			SP13Edit6.setText(preferencias.getString("SP13edittext6", ""));
			Spinner SP13spinner4 = (Spinner) findViewById (R.id.Spinner02);
			SP13spinner4.setSelection(preferencias.getInt("SP13spinner4", 0));
			EditText SP13Edit7 = (EditText) findViewById(R.id.EditText05);
			SP13Edit7.setText(preferencias.getString("SP13edittext7", ""));
			
			sb4.setProgress(preferencias.getInt("SP14seekbar", 0));
			
			EditText SP14Edit1 = (EditText) findViewById(R.id.EditText26);
			EditText SP14Edit2 = (EditText) findViewById(R.id.EditText27);
			EditText SP14Edit3 = (EditText) findViewById(R.id.EditText07);
			SP14Edit1.setText(preferencias.getString("SP14edittext1", ""));
			SP14Edit2.setText(preferencias.getString("SP14edittext2", ""));
			SP14Edit3.setText(preferencias.getString("SP14edittext3", ""));
			
			Spinner SP14spinner1 = (Spinner) findViewById (R.id.Spinner03);
			SP14spinner1.setSelection(preferencias.getInt("SP14spinner1", 0));
			EditText SP14Edit4 = (EditText) findViewById(R.id.EditText06);
			SP14Edit4.setText(preferencias.getString("SP14edittext4", ""));
			Spinner SP14spinner2 = (Spinner) findViewById (R.id.Spinner04);
			SP14spinner2.setSelection(preferencias.getInt("SP14spinner2", 0));
			EditText SP14Edit5 = (EditText) findViewById(R.id.EditText28);
			SP14Edit5.setText(preferencias.getString("SP14edittext5", ""));
			
			//SeekBar sb4 = (SeekBar) findViewById(R.id.SeekBar02);
			sb5.setProgress(preferencias.getInt("SP15seekbar", 0));
			
			EditText SP15Edit1 = (EditText) findViewById(R.id.EditText17);
			EditText SP15Edit2 = (EditText) findViewById(R.id.EditText18);
			EditText SP15Edit3 = (EditText) findViewById(R.id.EditText16);
			SP15Edit1.setText(preferencias.getString("SP15edittext1", ""));
			SP15Edit2.setText(preferencias.getString("SP15edittext2", ""));
			SP15Edit3.setText(preferencias.getString("SP15edittext3", ""));
			
			Spinner SP15spinner1 = (Spinner) findViewById (R.id.Spinner06);
			SP15spinner1.setSelection(preferencias.getInt("SP15spinner1", 0));
			EditText SP15Edit4 = (EditText) findViewById(R.id.EditText14);
			SP15Edit4.setText(preferencias.getString("SP15edittext4", ""));
			Spinner SP15spinner2 = (Spinner) findViewById (R.id.Spinner14);
			SP15spinner2.setSelection(preferencias.getInt("SP15spinner2", 0));
			EditText SP15Edit5 = (EditText) findViewById(R.id.EditText29);
			SP15Edit5.setText(preferencias.getString("SP15edittext5", ""));
			
			//GG
			
			sbgp21.setProgress(preferencias.getInt("GP21seekbar", 0));
			
			EditText GP21Edit1 = (EditText) findViewById(R.id.gp21et1);
			EditText GP21Edit2 = (EditText) findViewById(R.id.gp21et2);
			EditText GP21Edit3 = (EditText) findViewById(R.id.gp21et3);
			GP21Edit1.setText(preferencias.getString("GP21edittext1", ""));
			GP21Edit2.setText(preferencias.getString("GP21edittext2", ""));
			GP21Edit3.setText(preferencias.getString("GP21edittext3", ""));
			
			sbgp22.setProgress(preferencias.getInt("GP22seekbar", 0));
			
			EditText GP22Edit1 = (EditText) findViewById(R.id.gp22et1);
			EditText GP22Edit2 = (EditText) findViewById(R.id.gp22et2);
			EditText GP22Edit3 = (EditText) findViewById(R.id.gp22et3);
			GP22Edit1.setText(preferencias.getString("GP22edittext1", ""));
			GP22Edit2.setText(preferencias.getString("GP22edittext2", ""));
			GP22Edit3.setText(preferencias.getString("GP22edittext3", ""));
			
			sbgp23.setProgress(preferencias.getInt("GP23seekbar", 0));
			
			EditText GP23Edit1 = (EditText) findViewById(R.id.gp23et1);
			EditText GP23Edit2 = (EditText) findViewById(R.id.gp23et2);
			EditText GP23Edit3 = (EditText) findViewById(R.id.gp23et3);
			GP23Edit1.setText(preferencias.getString("GP23edittext1", ""));
			GP23Edit2.setText(preferencias.getString("GP23edittext2", ""));
			GP23Edit3.setText(preferencias.getString("GP23edittext3", ""));
			
			sbgp24.setProgress(preferencias.getInt("GP24seekbar", 0));
			
			EditText GP24Edit1 = (EditText) findViewById(R.id.gp24et1);
			EditText GP24Edit2 = (EditText) findViewById(R.id.gp24et2);
			EditText GP24Edit3 = (EditText) findViewById(R.id.gp24et3);
			GP24Edit1.setText(preferencias.getString("GP24edittext1", ""));
			GP24Edit2.setText(preferencias.getString("GP24edittext2", ""));
			GP24Edit3.setText(preferencias.getString("GP24edittext3", ""));
			
			sbgp25.setProgress(preferencias.getInt("GP25seekbar", 0));
			
			EditText GP25Edit1 = (EditText) findViewById(R.id.gp25et1);
			EditText GP25Edit2 = (EditText) findViewById(R.id.gp25et2);
			EditText GP25Edit3 = (EditText) findViewById(R.id.gp25et3);
			GP25Edit1.setText(preferencias.getString("GP25edittext1", ""));
			GP25Edit2.setText(preferencias.getString("GP25edittext2", ""));
			GP25Edit3.setText(preferencias.getString("GP25edittext3", ""));
			
			sbgp26.setProgress(preferencias.getInt("GP26seekbar", 0));
			
			EditText GP26Edit1 = (EditText) findViewById(R.id.gp26et1);
			EditText GP26Edit2 = (EditText) findViewById(R.id.gp26et2);
			EditText GP26Edit3 = (EditText) findViewById(R.id.gp26et3);
			GP26Edit1.setText(preferencias.getString("GP26edittext1", ""));
			GP26Edit2.setText(preferencias.getString("GP26edittext2", ""));
			GP26Edit3.setText(preferencias.getString("GP26edittext3", ""));
			
			sbgp27.setProgress(preferencias.getInt("GP27seekbar", 0));
			
			EditText GP27Edit1 = (EditText) findViewById(R.id.gp27et1);
			EditText GP27Edit2 = (EditText) findViewById(R.id.gp27et2);
			EditText GP27Edit3 = (EditText) findViewById(R.id.gp27et3);
			GP27Edit1.setText(preferencias.getString("GP27edittext1", ""));
			GP27Edit2.setText(preferencias.getString("GP27edittext2", ""));
			GP27Edit3.setText(preferencias.getString("GP27edittext3", ""));
			
			sbgp28.setProgress(preferencias.getInt("GP28seekbar", 0));
			
			EditText GP28Edit1 = (EditText) findViewById(R.id.gp28et1);
			EditText GP28Edit2 = (EditText) findViewById(R.id.gp28et2);
			EditText GP28Edit3 = (EditText) findViewById(R.id.gp28et3);
			GP28Edit1.setText(preferencias.getString("GP28edittext1", ""));
			GP28Edit2.setText(preferencias.getString("GP28edittext2", ""));
			GP28Edit3.setText(preferencias.getString("GP28edittext3", ""));
			
			sbgp29.setProgress(preferencias.getInt("GP29seekbar", 0));
			
			EditText GP29Edit1 = (EditText) findViewById(R.id.gp29et1);
			EditText GP29Edit2 = (EditText) findViewById(R.id.gp29et2);
			EditText GP29Edit3 = (EditText) findViewById(R.id.gp29et3);
			GP29Edit1.setText(preferencias.getString("GP29edittext1", ""));
			GP29Edit2.setText(preferencias.getString("GP29edittext2", ""));
			GP29Edit3.setText(preferencias.getString("GP29edittext3", ""));
			
			sbgp210.setProgress(preferencias.getInt("GP210seekbar", 0));
			
			EditText GP210Edit1 = (EditText) findViewById(R.id.gp210et1);
			EditText GP210Edit2 = (EditText) findViewById(R.id.gp210et2);
			EditText GP210Edit3 = (EditText) findViewById(R.id.gp210et3);
			GP210Edit1.setText(preferencias.getString("GP210edittext1", ""));
			GP210Edit2.setText(preferencias.getString("GP210edittext2", ""));
			GP210Edit3.setText(preferencias.getString("GP210edittext3", ""));
			
			sbgp31.setProgress(preferencias.getInt("GP31seekbar", 0));
			
			EditText GP31Edit1 = (EditText) findViewById(R.id.gp31et1);
			EditText GP31Edit2 = (EditText) findViewById(R.id.gp31et2);
			EditText GP31Edit3 = (EditText) findViewById(R.id.gp31et3);
			GP31Edit1.setText(preferencias.getString("GP31edittext1", ""));
			GP31Edit2.setText(preferencias.getString("GP31edittext2", ""));
			GP31Edit3.setText(preferencias.getString("GP31edittext3", ""));
			
			sbgp32.setProgress(preferencias.getInt("GP32seekbar", 0));
			
			EditText GP32Edit1 = (EditText) findViewById(R.id.gp32et1);
			EditText GP32Edit2 = (EditText) findViewById(R.id.gp32et2);
			EditText GP32Edit3 = (EditText) findViewById(R.id.gp32et3);
			GP32Edit1.setText(preferencias.getString("GP32edittext1", ""));
			GP32Edit2.setText(preferencias.getString("GP32edittext2", ""));
			GP32Edit3.setText(preferencias.getString("GP32edittext3", ""));
			
}
	
public class ItemAdapter extends BaseAdapter {
		
		SQLiteDatabase database = gestor.getReadableDatabase();
		
		String areas;
		List<String> lista = new ArrayList<String>();
		int index;
		int contador = 0;
		View view;
		TextView bigText;
		TextView littleText;
		String aux;

		LayoutInflater inflater;
		
		
		public ItemAdapter (Context context, int indice){
			inflater = LayoutInflater.from(context);
			index = indice;
			
			Cursor cursor = database.rawQuery(
					"SELECT * FROM Evaluaciones WHERE cod_ev = '" + indice + "'", null);
			cursor.moveToFirst();
			areas = cursor.getString(4).toString();
			
			while (!(areas.length() == 0 || areas == "" || areas.isEmpty())){
				index = areas.indexOf(",")+1;
				aux = areas.substring (0, index);
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
			if (convertView == null){
				String nombre = lista.get(contador).toString();
				  if (nombre.length() > 0 && nombre.charAt(nombre.length()-1)==',') {
					    nombre = nombre.substring(0, nombre.length()-1);
					  }
				if (contador < lista.size()-1){
					contador++;
				}
				LayoutInflater layoutInflater = getLayoutInflater();
				view = layoutInflater.inflate(R.layout.list_item2, null);
				bigText = (TextView) view.findViewById (R.id.big_text);
				bigText.setText(nombre);
				littleText = (TextView) view.findViewById(R.id.little_text);
				littleText.setText("ejemplo");
				
				if (nombre.equals("CM")){
					littleText.setText("Gestión de la configuración");
				} else if (nombre.equals("MA")){
					littleText.setText("Medición y análisis");
				} else if (nombre.equals("PMC")){
					littleText.setText("Monitorización y control del proyecto");
				} else if (nombre.equals("PP")){
					littleText.setText("Planificación del proyecto");
				} else if (nombre.equals("PPQA")){
					littleText.setText("Aseguramiento de la calidad del proceso y del producto");
				} else if (nombre.equals("REQM")){
					littleText.setText("Gestión de requisitos");
					view.setBackgroundColor(Color.parseColor("#87CEFA"));
				} else if (nombre.equals("SAM")){
					littleText.setText("Gestión de acuerdos con proveedores");
				}
			} else {
				view = convertView;
			}
			return view;
	}}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.gestion_requisitos, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.action_settings:
        	Intent intent = new Intent(Gestion_requisitos.this,
					Acerca_de.class);
        	Gestion_requisitos.this.startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}

}
