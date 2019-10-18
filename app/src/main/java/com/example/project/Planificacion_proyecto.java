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

public class Planificacion_proyecto extends Activity {

  Intent intent = getIntent();
  int indiceEvaluacion;
  int nivel = 3;
  boolean b1 = true;
  boolean b2 = true;
  boolean b3 = true;
  CustomSQLiteHelper gestor = new CustomSQLiteHelper(this, "database",
      null, 1);

  protected void onStop() {
    super.onStop();

    SharedPreferences preferencias = getSharedPreferences(
        "planificacion_proyecto_" + indiceEvaluacion, Context.MODE_PRIVATE);
    SharedPreferences.Editor editorPreferencias = preferencias.edit();

    SeekBar sb1 = findViewById(R.id.SP11Seekbar);
    editorPreferencias.putInt("SP11seekbar", sb1.getProgress());
    nivel1(sb1.getProgress());

    EditText SP11Edit1 = findViewById(R.id.SP11NotasNotasEdit);
    EditText SP11Edit2 = findViewById(R.id.SP11NotasFortalezasEdit);
    EditText SP11Edit3 = findViewById(R.id.SP11NotasDebilidadesEdit);
    editorPreferencias.putString("SP11edittext1", SP11Edit1.getText().toString());
    editorPreferencias.putString("SP11edittext2", SP11Edit2.getText().toString());
    editorPreferencias.putString("SP11edittext3", SP11Edit3.getText().toString());

    Spinner SP11spinner1 = findViewById(R.id.SP11EjemploInputSpinner);
    editorPreferencias.putInt("SP11spinner1", SP11spinner1.getSelectedItemPosition());
    EditText SP11Edit4 = findViewById(R.id.SP11EjemploInputText);
    editorPreferencias.putString("SP11edittext4", SP11Edit4.getText().toString());
    Spinner SP11spinner2 = findViewById(R.id.spinner1);
    editorPreferencias.putInt("SP11spinner2", SP11spinner2.getSelectedItemPosition());
    EditText SP11Edit5 = findViewById(R.id.editText1);
    editorPreferencias.putString("SP11edittext5", SP11Edit5.getText().toString());
    Spinner SP11spinner3 = findViewById(R.id.spinner2);
    editorPreferencias.putInt("SP11spinner3", SP11spinner3.getSelectedItemPosition());
    EditText SP11Edit6 = findViewById(R.id.editText2);
    editorPreferencias.putString("SP11edittext6", SP11Edit6.getText().toString());

    SeekBar sb2 = findViewById(R.id.SP12Seekbar);
    editorPreferencias.putInt("SP12seekbar", sb2.getProgress());
    nivel1(sb2.getProgress());

    EditText SP12Edit1 = findViewById(R.id.SP12NotasEvaluacionEdit);
    EditText SP12Edit2 = findViewById(R.id.SP12NotasFortalezasEdit);
    EditText SP12Edit3 = findViewById(R.id.SP12NotasDebilidadesEdit);
    editorPreferencias.putString("SP12edittext1", SP12Edit1.getText().toString());
    editorPreferencias.putString("SP12edittext2", SP12Edit2.getText().toString());
    editorPreferencias.putString("SP12edittext3", SP12Edit3.getText().toString());

    Spinner SP12spinner1 = findViewById(R.id.spinner08);
    editorPreferencias.putInt("SP12spinner1", SP12spinner1.getSelectedItemPosition());
    EditText SP12Edit4 = findViewById(R.id.editText20);
    editorPreferencias.putString("SP12edittext4", SP12Edit4.getText().toString());
    Spinner SP12spinner2 = findViewById(R.id.spinner07);
    editorPreferencias.putInt("SP12spinner2", SP12spinner2.getSelectedItemPosition());
    EditText SP12Edit5 = findViewById(R.id.editText19);
    editorPreferencias.putString("SP12edittext5", SP12Edit5.getText().toString());
    Spinner SP12spinner3 = findViewById(R.id.spinner04);
    editorPreferencias.putInt("SP12spinner3", SP12spinner3.getSelectedItemPosition());
    EditText SP12Edit6 = findViewById(R.id.editText07);
    editorPreferencias.putString("SP12edittext6", SP12Edit6.getText().toString());
    Spinner SP12spinner4 = findViewById(R.id.spinner03);
    editorPreferencias.putInt("SP12spinner4", SP12spinner4.getSelectedItemPosition());
    EditText SP12Edit7 = findViewById(R.id.editText06);
    editorPreferencias.putString("SP12edittext7", SP12Edit7.getText().toString());

    SeekBar sb3 = findViewById(R.id.SeekBar01);
    editorPreferencias.putInt("SP13seekbar", sb3.getProgress());
    nivel1(sb3.getProgress());

    EditText SP13Edit1 = findViewById(R.id.EditText03);
    EditText SP13Edit2 = findViewById(R.id.EditText04);
    EditText SP13Edit3 = findViewById(R.id.EditText02);
    editorPreferencias.putString("SP13edittext1", SP13Edit1.getText().toString());
    editorPreferencias.putString("SP13edittext2", SP13Edit2.getText().toString());
    editorPreferencias.putString("SP13edittext3", SP13Edit3.getText().toString());

    Spinner SP13spinner1 = findViewById(R.id.Spinner05);
    editorPreferencias.putInt("SP13spinner1", SP13spinner1.getSelectedItemPosition());
    EditText SP13Edit4 = findViewById(R.id.EditText08);
    editorPreferencias.putString("SP13edittext4", SP13Edit4.getText().toString());

    SeekBar sb8 = findViewById(R.id.SP14seekbar);
    editorPreferencias.putInt("SP14seekbar", sb8.getProgress());
    nivel1(sb8.getProgress());

    EditText SP14Edit1 = findViewById(R.id.EditText26);
    EditText SP14Edit2 = findViewById(R.id.EditText27);
    EditText SP14Edit3 = findViewById(R.id.EditText07);
    editorPreferencias.putString("SP14edittext1", SP14Edit1.getText().toString());
    editorPreferencias.putString("SP14edittext2", SP14Edit2.getText().toString());
    editorPreferencias.putString("SP14edittext3", SP14Edit3.getText().toString());

    Spinner SP14spinner1 = findViewById(R.id.Spinner03);
    editorPreferencias.putInt("SP14spinner1", SP14spinner1.getSelectedItemPosition());
    EditText SP14Edit4 = findViewById(R.id.EditText06);
    editorPreferencias.putString("SP14edittext4", SP14Edit4.getText().toString());
    Spinner SP14spinner2 = findViewById(R.id.Spinner04);
    editorPreferencias.putInt("SP14spinner2", SP14spinner2.getSelectedItemPosition());
    EditText SP14Edit5 = findViewById(R.id.EditText28);
    editorPreferencias.putString("SP14edittext5", SP14Edit5.getText().toString());
    Spinner SP14spinner3 = findViewById(R.id.Spinner02);
    editorPreferencias.putInt("SP14spinner3", SP14spinner3.getSelectedItemPosition());
    EditText SP14Edit6 = findViewById(R.id.EditText05);
    editorPreferencias.putString("SP14edittext6", SP14Edit6.getText().toString());

    SeekBar sb4 = findViewById(R.id.SeekBar02);
    editorPreferencias.putInt("SP21seekbar", sb4.getProgress());
    nivel1(sb4.getProgress());

    EditText SP21Edit1 = findViewById(R.id.EditText17);
    EditText SP21Edit2 = findViewById(R.id.EditText18);
    EditText SP21Edit3 = findViewById(R.id.EditText16);
    editorPreferencias.putString("SP21edittext1", SP21Edit1.getText().toString());
    editorPreferencias.putString("SP21edittext2", SP21Edit2.getText().toString());
    editorPreferencias.putString("SP21edittext3", SP21Edit3.getText().toString());

    Spinner SP21spinner1 = findViewById(R.id.Spinner06);
    editorPreferencias.putInt("SP21spinner1", SP21spinner1.getSelectedItemPosition());
    EditText SP21Edit4 = findViewById(R.id.EditText14);
    editorPreferencias.putString("SP21edittext4", SP21Edit4.getText().toString());
    Spinner SP21spinner2 = findViewById(R.id.Spinner14);
    editorPreferencias.putInt("SP21spinner2", SP21spinner2.getSelectedItemPosition());
    EditText SP21Edit5 = findViewById(R.id.EditText29);
    editorPreferencias.putString("SP21edittext5", SP21Edit5.getText().toString());
    Spinner SP21spinner3 = findViewById(R.id.Spinner22);
    editorPreferencias.putInt("SP21spinner3", SP21spinner3.getSelectedItemPosition());
    EditText SP21Edit6 = findViewById(R.id.EditText60);
    editorPreferencias.putString("SP21edittext6", SP21Edit6.getText().toString());

    SeekBar sb5 = findViewById(R.id.SeekBar04);
    editorPreferencias.putInt("SP22seekbar", sb5.getProgress());
    nivel1(sb5.getProgress());

    EditText SP22Edit1 = findViewById(R.id.EditText12);
    EditText SP22Edit2 = findViewById(R.id.EditText11);
    EditText SP22Edit3 = findViewById(R.id.EditText23);
    editorPreferencias.putString("SP22edittext1", SP22Edit1.getText().toString());
    editorPreferencias.putString("SP22edittext2", SP22Edit2.getText().toString());
    editorPreferencias.putString("SP22edittext3", SP22Edit3.getText().toString());

    Spinner SP22spinner1 = findViewById(R.id.Spinner24);
    editorPreferencias.putInt("SP22spinner1", SP22spinner1.getSelectedItemPosition());
    EditText SP22Edit4 = findViewById(R.id.EditText62);
    editorPreferencias.putString("SP22edittext4", SP22Edit4.getText().toString());
    Spinner SP22spinner2 = findViewById(R.id.Spinner23);
    editorPreferencias.putInt("SP22spinner2", SP22spinner2.getSelectedItemPosition());
    EditText SP22Edit5 = findViewById(R.id.EditText61);
    editorPreferencias.putString("SP22edittext5", SP22Edit5.getText().toString());
    Spinner SP22spinner3 = findViewById(R.id.Spinner11);
    editorPreferencias.putInt("SP22spinner3", SP22spinner3.getSelectedItemPosition());
    EditText SP22Edit6 = findViewById(R.id.EditText13);
    editorPreferencias.putString("SP22edittext6", SP22Edit6.getText().toString());

    SeekBar sb6 = findViewById(R.id.SeekBar03);
    editorPreferencias.putInt("SP23seekbar", sb6.getProgress());
    nivel1(sb6.getProgress());

    EditText SP23Edit1 = findViewById(R.id.EditText09);
    EditText SP23Edit2 = findViewById(R.id.EditText10);
    EditText SP23Edit3 = findViewById(R.id.EditText22);
    editorPreferencias.putString("SP23edittext1", SP23Edit1.getText().toString());
    editorPreferencias.putString("SP23edittext2", SP23Edit2.getText().toString());
    editorPreferencias.putString("SP23edittext3", SP23Edit3.getText().toString());

    Spinner SP23spinner1 = findViewById(R.id.Spinner35);
    editorPreferencias.putInt("SP23spinner1", SP23spinner1.getSelectedItemPosition());
    EditText SP23Edit4 = findViewById(R.id.EditText71);
    editorPreferencias.putString("SP23edittext4", SP23Edit4.getText().toString());
    Spinner SP23spinner2 = findViewById(R.id.Spinner34);
    editorPreferencias.putInt("SP23spinner2", SP23spinner2.getSelectedItemPosition());
    EditText SP23Edit5 = findViewById(R.id.EditText70);
    editorPreferencias.putString("SP23edittext5", SP23Edit5.getText().toString());
    Spinner SP23spinner3 = findViewById(R.id.Spinner33);
    editorPreferencias.putInt("SP23spinner3", SP23spinner3.getSelectedItemPosition());
    EditText SP23Edit6 = findViewById(R.id.EditText69);
    editorPreferencias.putString("SP23edittext6", SP23Edit6.getText().toString());
    Spinner SP23spinner4 = findViewById(R.id.Spinner32);
    editorPreferencias.putInt("SP23spinner4", SP23spinner4.getSelectedItemPosition());
    EditText SP23Edit7 = findViewById(R.id.EditText68);
    editorPreferencias.putString("SP23edittext7", SP23Edit7.getText().toString());
    Spinner SP23spinner5 = findViewById(R.id.Spinner31);
    editorPreferencias.putInt("SP23spinner5", SP23spinner5.getSelectedItemPosition());
    EditText SP23Edit8 = findViewById(R.id.EditText67);
    editorPreferencias.putString("SP23edittext8", SP23Edit8.getText().toString());
    Spinner SP23spinner6 = findViewById(R.id.Spinner30);
    editorPreferencias.putInt("SP23spinner6", SP23spinner6.getSelectedItemPosition());
    EditText SP23Edit9 = findViewById(R.id.EditText66);
    editorPreferencias.putString("SP23edittext9", SP23Edit9.getText().toString());
    Spinner SP23spinner7 = findViewById(R.id.Spinner29);
    editorPreferencias.putInt("SP23spinner7", SP23spinner7.getSelectedItemPosition());
    EditText SP23Edit10 = findViewById(R.id.EditText65);
    editorPreferencias.putString("SP23edittext10", SP23Edit10.getText().toString());
    Spinner SP23spinner8 = findViewById(R.id.Spinner27);
    editorPreferencias.putInt("SP23spinner8", SP23spinner8.getSelectedItemPosition());
    EditText SP23Edit11 = findViewById(R.id.EditText64);
    editorPreferencias.putString("SP23edittext11", SP23Edit11.getText().toString());
    Spinner SP23spinner9 = findViewById(R.id.Spinner25);
    editorPreferencias.putInt("SP23spinner9", SP23spinner9.getSelectedItemPosition());
    EditText SP23Edit12 = findViewById(R.id.EditText63);
    editorPreferencias.putString("SP23edittext12", SP23Edit12.getText().toString());
    Spinner SP23spinner10 = findViewById(R.id.Spinner10);
    editorPreferencias.putInt("SP23spinner10", SP23spinner10.getSelectedItemPosition());
    EditText SP23Edit13 = findViewById(R.id.EditText15);
    editorPreferencias.putString("SP23edittext13", SP23Edit13.getText().toString());

    SeekBar sb7 = findViewById(R.id.SeekBar06);
    editorPreferencias.putInt("SP24seekbar", sb7.getProgress());
    nivel1(sb7.getProgress());

    EditText SP24Edit1 = findViewById(R.id.EditText47);
    EditText SP24Edit2 = findViewById(R.id.EditText48);
    EditText SP24Edit3 = findViewById(R.id.EditText38);
    editorPreferencias.putString("SP24edittext1", SP24Edit1.getText().toString());
    editorPreferencias.putString("SP24edittext2", SP24Edit2.getText().toString());
    editorPreferencias.putString("SP24edittext3", SP24Edit3.getText().toString());

    Spinner SP24spinner1 = findViewById(R.id.Spinner40);
    editorPreferencias.putInt("SP24spinner1", SP24spinner1.getSelectedItemPosition());
    EditText SP24Edit4 = findViewById(R.id.EditText76);
    editorPreferencias.putString("SP24edittext4", SP24Edit4.getText().toString());
    Spinner SP24spinner2 = findViewById(R.id.Spinner39);
    editorPreferencias.putInt("SP24spinner2", SP24spinner2.getSelectedItemPosition());
    EditText SP24Edit5 = findViewById(R.id.EditText75);
    editorPreferencias.putString("SP24edittext5", SP24Edit5.getText().toString());
    Spinner SP24spinner3 = findViewById(R.id.Spinner38);
    editorPreferencias.putInt("SP24spinner3", SP24spinner3.getSelectedItemPosition());
    EditText SP24Edit6 = findViewById(R.id.EditText74);
    editorPreferencias.putString("SP24edittext6", SP24Edit6.getText().toString());
    Spinner SP24spinner4 = findViewById(R.id.Spinner37);
    editorPreferencias.putInt("SP24spinner4", SP24spinner4.getSelectedItemPosition());
    EditText SP24Edit7 = findViewById(R.id.EditText73);
    editorPreferencias.putString("SP24edittext7", SP24Edit7.getText().toString());
    Spinner SP24spinner5 = findViewById(R.id.Spinner36);
    editorPreferencias.putInt("SP24spinner5", SP24spinner5.getSelectedItemPosition());
    EditText SP24Edit8 = findViewById(R.id.EditText72);
    editorPreferencias.putString("SP24edittext8", SP24Edit8.getText().toString());
    Spinner SP24spinner6 = findViewById(R.id.Spinner26);
    editorPreferencias.putInt("SP24spinner6", SP24spinner6.getSelectedItemPosition());
    EditText SP24Edit9 = findViewById(R.id.EditText44);
    editorPreferencias.putString("SP24edittext9", SP24Edit9.getText().toString());
    Spinner SP24spinner7 = findViewById(R.id.Spinner28);
    editorPreferencias.putInt("SP24spinner7", SP24spinner7.getSelectedItemPosition());
    EditText SP24Edit10 = findViewById(R.id.EditText46);
    editorPreferencias.putString("SP24edittext10", SP24Edit10.getText().toString());

    SeekBar sb9 = findViewById(R.id.SeekBar07);
    editorPreferencias.putInt("SP25seekbar", sb9.getProgress());
    nivel1(sb9.getProgress());

    EditText SP25Edit1 = findViewById(R.id.EditText20);
    EditText SP25Edit2 = findViewById(R.id.EditText24);
    EditText SP25Edit3 = findViewById(R.id.EditText25);
    editorPreferencias.putString("SP25edittext1", SP25Edit1.getText().toString());
    editorPreferencias.putString("SP25edittext2", SP25Edit2.getText().toString());
    editorPreferencias.putString("SP25edittext3", SP25Edit3.getText().toString());

    Spinner SP25spinner1 = findViewById(R.id.Spinner42);
    editorPreferencias.putInt("SP25spinner1", SP25spinner1.getSelectedItemPosition());
    EditText SP25Edit4 = findViewById(R.id.EditText78);
    editorPreferencias.putString("SP25edittext4", SP25Edit4.getText().toString());
    Spinner SP25spinner2 = findViewById(R.id.Spinner41);
    editorPreferencias.putInt("SP25spinner2", SP25spinner2.getSelectedItemPosition());
    EditText SP25Edit5 = findViewById(R.id.EditText77);
    editorPreferencias.putString("SP25edittext5", SP25Edit5.getText().toString());
    Spinner SP25spinner3 = findViewById(R.id.Spinner08);
    editorPreferencias.putInt("SP25spinner3", SP25spinner3.getSelectedItemPosition());
    EditText SP25Edit6 = findViewById(R.id.EditText19);
    editorPreferencias.putString("SP25edittext6", SP25Edit6.getText().toString());
    Spinner SP25spinner4 = findViewById(R.id.Spinner07);
    editorPreferencias.putInt("SP25spinner4", SP25spinner4.getSelectedItemPosition());
    EditText SP25Edit7 = findViewById(R.id.EditText21);
    editorPreferencias.putString("SP25edittext7", SP25Edit7.getText().toString());

    SeekBar sb10 = findViewById(R.id.SeekBar08);
    editorPreferencias.putInt("SP26seekbar", sb10.getProgress());
    nivel1(sb10.getProgress());

    EditText SP26Edit1 = findViewById(R.id.EditText31);
    EditText SP26Edit2 = findViewById(R.id.EditText32);
    EditText SP26Edit3 = findViewById(R.id.EditText30);
    editorPreferencias.putString("SP26edittext1", SP26Edit1.getText().toString());
    editorPreferencias.putString("SP26edittext2", SP26Edit2.getText().toString());
    editorPreferencias.putString("SP26edittext3", SP26Edit3.getText().toString());

    Spinner SP26spinner1 = findViewById(R.id.Spinner09);
    editorPreferencias.putInt("SP26spinner1", SP26spinner1.getSelectedItemPosition());
    EditText SP26Edit4 = findViewById(R.id.EditText33);
    editorPreferencias.putString("SP26edittext4", SP26Edit4.getText().toString());

    SeekBar sb11 = findViewById(R.id.SeekBar09);
    editorPreferencias.putInt("SP27seekbar", sb11.getProgress());
    nivel1(sb11.getProgress());

    EditText SP27Edit1 = findViewById(R.id.EditText35);
    EditText SP27Edit2 = findViewById(R.id.EditText36);
    EditText SP27Edit3 = findViewById(R.id.EditText34);
    editorPreferencias.putString("SP27edittext1", SP27Edit1.getText().toString());
    editorPreferencias.putString("SP27edittext2", SP27Edit2.getText().toString());
    editorPreferencias.putString("SP27edittext3", SP27Edit3.getText().toString());

    Spinner SP27spinner1 = findViewById(R.id.Spinner12);
    editorPreferencias.putInt("SP27spinner1", SP27spinner1.getSelectedItemPosition());
    EditText SP27Edit4 = findViewById(R.id.EditText37);
    editorPreferencias.putString("SP27edittext4", SP27Edit4.getText().toString());

    SeekBar sb12 = findViewById(R.id.SeekBar10);
    editorPreferencias.putInt("SP31seekbar", sb12.getProgress());
    nivel1(sb12.getProgress());

    EditText SP31Edit1 = findViewById(R.id.EditText40);
    EditText SP31Edit2 = findViewById(R.id.EditText41);
    EditText SP31Edit3 = findViewById(R.id.EditText39);
    editorPreferencias.putString("SP31edittext1", SP31Edit1.getText().toString());
    editorPreferencias.putString("SP31edittext2", SP31Edit2.getText().toString());
    editorPreferencias.putString("SP31edittext3", SP31Edit3.getText().toString());

    Spinner SP31spinner1 = findViewById(R.id.Spinner13);
    editorPreferencias.putInt("SP31spinner1", SP31spinner1.getSelectedItemPosition());
    EditText SP31Edit4 = findViewById(R.id.EditText42);
    editorPreferencias.putString("SP31edittext4", SP31Edit4.getText().toString());

    SeekBar sb13 = findViewById(R.id.SeekBar11);
    editorPreferencias.putInt("SP32seekbar", sb13.getProgress());
    nivel1(sb13.getProgress());

    EditText SP32Edit1 = findViewById(R.id.EditText45);
    EditText SP32Edit2 = findViewById(R.id.EditText49);
    EditText SP32Edit3 = findViewById(R.id.EditText43);
    editorPreferencias.putString("SP32edittext1", SP32Edit1.getText().toString());
    editorPreferencias.putString("SP32edittext2", SP32Edit2.getText().toString());
    editorPreferencias.putString("SP32edittext3", SP32Edit3.getText().toString());

    Spinner SP32spinner1 = findViewById(R.id.Spinner46);
    editorPreferencias.putInt("SP32spinner1", SP32spinner1.getSelectedItemPosition());
    EditText SP32Edit4 = findViewById(R.id.EditText82);
    editorPreferencias.putString("SP32edittext4", SP32Edit4.getText().toString());
    Spinner SP32spinner2 = findViewById(R.id.Spinner45);
    editorPreferencias.putInt("SP32spinner2", SP32spinner2.getSelectedItemPosition());
    EditText SP32Edit5 = findViewById(R.id.EditText81);
    editorPreferencias.putString("SP32edittext5", SP32Edit5.getText().toString());
    Spinner SP32spinner3 = findViewById(R.id.Spinner44);
    editorPreferencias.putInt("SP32spinner3", SP32spinner3.getSelectedItemPosition());
    EditText SP32Edit6 = findViewById(R.id.EditText80);
    editorPreferencias.putString("SP32edittext6", SP32Edit6.getText().toString());
    Spinner SP32spinner4 = findViewById(R.id.Spinner43);
    editorPreferencias.putInt("SP32spinner4", SP32spinner4.getSelectedItemPosition());
    EditText SP32Edit7 = findViewById(R.id.EditText79);
    editorPreferencias.putString("SP32edittext7", SP32Edit7.getText().toString());
    Spinner SP32spinner5 = findViewById(R.id.Spinner15);
    editorPreferencias.putInt("SP32spinner5", SP32spinner5.getSelectedItemPosition());
    EditText SP32Edit8 = findViewById(R.id.EditText50);
    editorPreferencias.putString("SP32edittext8", SP32Edit8.getText().toString());

    SeekBar sb14 = findViewById(R.id.SeekBar12);
    editorPreferencias.putInt("SP33seekbar", sb14.getProgress());
    nivel1(sb14.getProgress());

    EditText SP33Edit1 = findViewById(R.id.EditText52);
    EditText SP33Edit2 = findViewById(R.id.EditText53);
    EditText SP33Edit3 = findViewById(R.id.EditText51);
    editorPreferencias.putString("SP33edittext1", SP33Edit1.getText().toString());
    editorPreferencias.putString("SP33edittext2", SP33Edit2.getText().toString());
    editorPreferencias.putString("SP33edittext3", SP33Edit3.getText().toString());

    Spinner SP33spinner1 = findViewById(R.id.Spinner47);
    editorPreferencias.putInt("SP33spinner1", SP33spinner1.getSelectedItemPosition());
    EditText SP33Edit4 = findViewById(R.id.EditText83);
    editorPreferencias.putString("SP33edittext4", SP33Edit4.getText().toString());
    Spinner SP33spinner2 = findViewById(R.id.Spinner16);
    editorPreferencias.putInt("SP33spinner2", SP33spinner2.getSelectedItemPosition());
    EditText SP33Edit5 = findViewById(R.id.EditText54);
    editorPreferencias.putString("SP33edittext5", SP33Edit5.getText().toString());

    //GG

    SeekBar sbgp21 = findViewById(R.id.sbgp21);
    editorPreferencias.putInt("GP21seekbar", sbgp21.getProgress());
    nivel2(sbgp21.getProgress());

    EditText GP21Edit1 = findViewById(R.id.gp21et1);
    EditText GP21Edit2 = findViewById(R.id.gp21et2);
    EditText GP21Edit3 = findViewById(R.id.gp21et3);
    editorPreferencias.putString("GP21edittext1", GP21Edit1.getText().toString());
    editorPreferencias.putString("GP21edittext2", GP21Edit2.getText().toString());
    editorPreferencias.putString("GP21edittext3", GP21Edit3.getText().toString());

    SeekBar sbgp22 = findViewById(R.id.sbgp22);
    editorPreferencias.putInt("GP22seekbar", sbgp22.getProgress());
    nivel2(sbgp22.getProgress());

    EditText GP22Edit1 = findViewById(R.id.gp22et1);
    EditText GP22Edit2 = findViewById(R.id.gp22et2);
    EditText GP22Edit3 = findViewById(R.id.gp22et3);
    editorPreferencias.putString("GP22edittext1", GP22Edit1.getText().toString());
    editorPreferencias.putString("GP22edittext2", GP22Edit2.getText().toString());
    editorPreferencias.putString("GP22edittext3", GP22Edit3.getText().toString());

    SeekBar sbgp23 = findViewById(R.id.sbgp23);
    editorPreferencias.putInt("GP23seekbar", sbgp23.getProgress());
    nivel2(sbgp23.getProgress());

    EditText GP23Edit1 = findViewById(R.id.gp23et1);
    EditText GP23Edit2 = findViewById(R.id.gp23et2);
    EditText GP23Edit3 = findViewById(R.id.gp23et3);
    editorPreferencias.putString("GP23edittext1", GP23Edit1.getText().toString());
    editorPreferencias.putString("GP23edittext2", GP23Edit2.getText().toString());
    editorPreferencias.putString("GP23edittext3", GP23Edit3.getText().toString());

    SeekBar sbgp24 = findViewById(R.id.sbgp24);
    editorPreferencias.putInt("GP24seekbar", sbgp24.getProgress());
    nivel2(sbgp24.getProgress());

    EditText GP24Edit1 = findViewById(R.id.gp24et1);
    EditText GP24Edit2 = findViewById(R.id.gp24et2);
    EditText GP24Edit3 = findViewById(R.id.gp24et3);
    editorPreferencias.putString("GP24edittext1", GP24Edit1.getText().toString());
    editorPreferencias.putString("GP24edittext2", GP24Edit2.getText().toString());
    editorPreferencias.putString("GP24edittext3", GP24Edit3.getText().toString());

    SeekBar sbgp25 = findViewById(R.id.sbgp25);
    editorPreferencias.putInt("GP25seekbar", sbgp25.getProgress());
    nivel2(sbgp25.getProgress());

    EditText GP25Edit1 = findViewById(R.id.gp25et1);
    EditText GP25Edit2 = findViewById(R.id.gp25et2);
    EditText GP25Edit3 = findViewById(R.id.gp25et3);
    editorPreferencias.putString("GP25edittext1", GP25Edit1.getText().toString());
    editorPreferencias.putString("GP25edittext2", GP25Edit2.getText().toString());
    editorPreferencias.putString("GP25edittext3", GP25Edit3.getText().toString());

    SeekBar sbgp26 = findViewById(R.id.sbgp26);
    editorPreferencias.putInt("GP26seekbar", sbgp26.getProgress());
    nivel2(sbgp26.getProgress());

    EditText GP26Edit1 = findViewById(R.id.gp26et1);
    EditText GP26Edit2 = findViewById(R.id.gp26et2);
    EditText GP26Edit3 = findViewById(R.id.gp26et3);
    editorPreferencias.putString("GP26edittext1", GP26Edit1.getText().toString());
    editorPreferencias.putString("GP26edittext2", GP26Edit2.getText().toString());
    editorPreferencias.putString("GP26edittext3", GP26Edit3.getText().toString());

    SeekBar sbgp27 = findViewById(R.id.sbgp27);
    editorPreferencias.putInt("GP27seekbar", sbgp27.getProgress());
    nivel2(sbgp27.getProgress());

    EditText GP27Edit1 = findViewById(R.id.gp27et1);
    EditText GP27Edit2 = findViewById(R.id.gp27et2);
    EditText GP27Edit3 = findViewById(R.id.gp27et3);
    editorPreferencias.putString("GP27edittext1", GP27Edit1.getText().toString());
    editorPreferencias.putString("GP27edittext2", GP27Edit2.getText().toString());
    editorPreferencias.putString("GP27edittext3", GP27Edit3.getText().toString());

    SeekBar sbgp28 = findViewById(R.id.sbgp28);
    editorPreferencias.putInt("GP28seekbar", sbgp28.getProgress());
    nivel2(sbgp28.getProgress());

    EditText GP28Edit1 = findViewById(R.id.gp28et1);
    EditText GP28Edit2 = findViewById(R.id.gp28et2);
    EditText GP28Edit3 = findViewById(R.id.gp28et3);
    editorPreferencias.putString("GP28edittext1", GP28Edit1.getText().toString());
    editorPreferencias.putString("GP28edittext2", GP28Edit2.getText().toString());
    editorPreferencias.putString("GP28edittext3", GP28Edit3.getText().toString());

    SeekBar sbgp29 = findViewById(R.id.sbgp29);
    editorPreferencias.putInt("GP29seekbar", sbgp29.getProgress());
    nivel2(sbgp29.getProgress());

    EditText GP29Edit1 = findViewById(R.id.gp29et1);
    EditText GP29Edit2 = findViewById(R.id.gp29et2);
    EditText GP29Edit3 = findViewById(R.id.gp29et3);
    editorPreferencias.putString("GP29edittext1", GP29Edit1.getText().toString());
    editorPreferencias.putString("GP29edittext2", GP29Edit2.getText().toString());
    editorPreferencias.putString("GP29edittext3", GP29Edit3.getText().toString());

    SeekBar sbgp210 = findViewById(R.id.sbgp210);
    editorPreferencias.putInt("GP210seekbar", sbgp210.getProgress());
    nivel2(sbgp210.getProgress());

    EditText GP210Edit1 = findViewById(R.id.gp210et1);
    EditText GP210Edit2 = findViewById(R.id.gp210et2);
    EditText GP210Edit3 = findViewById(R.id.gp210et3);
    editorPreferencias.putString("GP210edittext1", GP210Edit1.getText().toString());
    editorPreferencias.putString("GP210edittext2", GP210Edit2.getText().toString());
    editorPreferencias.putString("GP210edittext3", GP210Edit3.getText().toString());

    SeekBar sbgp31 = findViewById(R.id.sbgp31);
    editorPreferencias.putInt("GP31seekbar", sbgp31.getProgress());
    nivel3(sbgp31.getProgress());

    EditText GP31Edit1 = findViewById(R.id.gp31et1);
    EditText GP31Edit2 = findViewById(R.id.gp31et2);
    EditText GP31Edit3 = findViewById(R.id.gp31et3);
    editorPreferencias.putString("GP31edittext1", GP31Edit1.getText().toString());
    editorPreferencias.putString("GP31edittext2", GP31Edit2.getText().toString());
    editorPreferencias.putString("GP31edittext3", GP31Edit3.getText().toString());

    SeekBar sbgp32 = findViewById(R.id.sbgp32);
    editorPreferencias.putInt("GP32seekbar", sbgp32.getProgress());
    nivel3(sbgp32.getProgress());

    EditText GP32Edit1 = findViewById(R.id.gp32et1);
    EditText GP32Edit2 = findViewById(R.id.gp32et2);
    EditText GP32Edit3 = findViewById(R.id.gp32et3);
    editorPreferencias.putString("GP32edittext1", GP32Edit1.getText().toString());
    editorPreferencias.putString("GP32edittext2", GP32Edit2.getText().toString());
    editorPreferencias.putString("GP32edittext3", GP32Edit3.getText().toString());

    editorPreferencias.putInt("nivel", nivel);

    editorPreferencias.commit();
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
    if (i < 2 && b2 == true && b1 == true) {
      nivel = 2;
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_planificacion_proyecto);

    Intent intent = getIntent();
    indiceEvaluacion = intent.getIntExtra("indice", 0);

    int planificacion_proyecto_1 = R.string.planificacion_proyecto_SP11;
    int planificacion_proyecto_2 = R.string.planificacion_proyecto_SP11subpracticas;
    int planificacion_proyecto_3 = R.string.planificacion_proyecto_SP12;
    int planificacion_proyecto_4 = R.string.planificacion_proyecto_SP12subpracticas;
    int planificacion_proyecto_5 = R.string.planificacion_proyecto_SP13;
    int planificacion_proyecto_7 = R.string.planificacion_proyecto_SP14;
    int planificacion_proyecto_8 = R.string.planificacion_proyecto_SP14subpracticas;
    int planificacion_proyecto_9 = R.string.planificacion_proyecto_SP21;
    int planificacion_proyecto_10 = R.string.planificacion_proyecto_SP21subpracticas;
    int planificacion_proyecto_11 = R.string.planificacion_proyecto_SP22;
    int planificacion_proyecto_12 = R.string.planificacion_proyecto_SP22subpracticas;
    int planificacion_proyecto_13 = R.string.planificacion_proyecto_SP23;
    int planificacion_proyecto_14 = R.string.planificacion_proyecto_SP23subpracticas;
    int planificacion_proyecto_15 = R.string.planificacion_proyecto_SP24;
    int planificacion_proyecto_16 = R.string.planificacion_proyecto_SP24subpracticas;
    int planificacion_proyecto_17 = R.string.planificacion_proyecto_SP25;
    int planificacion_proyecto_18 = R.string.planificacion_proyecto_SP25subpracticas;
    int planificacion_proyecto_19 = R.string.planificacion_proyecto_SP26;
    int planificacion_proyecto_20 = R.string.planificacion_proyecto_SP27;
    int planificacion_proyecto_21 = R.string.planificacion_proyecto_SP31;
    int planificacion_proyecto_22 = R.string.planificacion_proyecto_SP32;
    int planificacion_proyecto_23 = R.string.planificacion_proyecto_SP33;
    int planificacion_proyecto_24 = R.string.planificacion_proyecto_SP33subpracticas;

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
    TextView tvsp14intro = findViewById(R.id.TextView08);
    TextView tvsp14subpracticas = findViewById(R.id.TextView04);
    TextView tvsp21intro = findViewById(R.id.TextView13);
    TextView tvsp21subpracticas = findViewById(R.id.TextView14);
    TextView tvsp22intro = findViewById(R.id.TextView23);
    TextView tvsp22subpracticas = findViewById(R.id.TextView45);
    TextView tvsp23intro = findViewById(R.id.TextView19);
    TextView tvsp23subpracticas = findViewById(R.id.TextView17);
    TextView tvsp24intro = findViewById(R.id.TextView84);
    TextView tvsp24subpracticas = findViewById(R.id.TextView86);
    TextView tvsp25intro = findViewById(R.id.TextView237);
    TextView tvsp25subpracticas = findViewById(R.id.TextView247);
    TextView tvsp26intro = findViewById(R.id.TextView72);
    TextView tvsp27intro = findViewById(R.id.TextView282);
    TextView tvsp31intro = findViewById(R.id.TextView98);
    TextView tvsp32intro = findViewById(R.id.TextView108);
    TextView tvsp33intro = findViewById(R.id.TextView118);
    TextView tvsp33subpracticas = findViewById(R.id.TextView121);

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

    tvsp11intro.setText(Html.fromHtml(getString(planificacion_proyecto_1)));
    tvsp11subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_2)));
    tvsp12intro.setText(Html.fromHtml(getString(planificacion_proyecto_3)));
    tvsp12subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_4)));
    tvsp13intro.setText(Html.fromHtml(getString(planificacion_proyecto_5)));
    tvsp14intro.setText(Html.fromHtml(getString(planificacion_proyecto_7)));
    tvsp14subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_8)));
    tvsp21intro.setText(Html.fromHtml(getString(planificacion_proyecto_9)));
    tvsp21subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_10)));
    tvsp22intro.setText(Html.fromHtml(getString(planificacion_proyecto_11)));
    tvsp22subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_12)));
    tvsp23intro.setText(Html.fromHtml(getString(planificacion_proyecto_13)));
    tvsp23subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_14)));
    tvsp24intro.setText(Html.fromHtml(getString(planificacion_proyecto_15)));
    tvsp24subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_16)));
    tvsp25intro.setText(Html.fromHtml(getString(planificacion_proyecto_17)));
    tvsp25subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_18)));
    tvsp26intro.setText(Html.fromHtml(getString(planificacion_proyecto_19)));
    tvsp27intro.setText(Html.fromHtml(getString(planificacion_proyecto_20)));
    tvsp31intro.setText(Html.fromHtml(getString(planificacion_proyecto_21)));
    tvsp32intro.setText(Html.fromHtml(getString(planificacion_proyecto_22)));
    tvsp33intro.setText(Html.fromHtml(getString(planificacion_proyecto_23)));
    tvsp33subpracticas.setText(Html.fromHtml(getString(planificacion_proyecto_24)));

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
    Spinner spinner2 = findViewById(R.id.spinner1);
    Spinner spinner3 = findViewById(R.id.spinner2);
    Spinner spinner4 = findViewById(R.id.spinner08);
    Spinner spinner5 = findViewById(R.id.spinner07);
    Spinner spinner6 = findViewById(R.id.spinner04);
    Spinner spinner7 = findViewById(R.id.spinner03);
    Spinner spinner8 = findViewById(R.id.Spinner05);
    Spinner spinner10 = findViewById(R.id.Spinner03);
    Spinner spinner14 = findViewById(R.id.Spinner04);
    Spinner spinner15 = findViewById(R.id.Spinner02);
    Spinner spinner17 = findViewById(R.id.Spinner06);
    Spinner spinner18 = findViewById(R.id.Spinner14);
    Spinner spinner19 = findViewById(R.id.Spinner22);
    Spinner spinner20 = findViewById(R.id.Spinner24);
    Spinner spinner21 = findViewById(R.id.Spinner23);
    Spinner spinner22 = findViewById(R.id.Spinner11);
    Spinner spinner23 = findViewById(R.id.Spinner35);
    Spinner spinner24 = findViewById(R.id.Spinner34);
    Spinner spinner25 = findViewById(R.id.Spinner33);
    Spinner spinner26 = findViewById(R.id.Spinner32);
    Spinner spinner27 = findViewById(R.id.Spinner31);
    Spinner spinner28 = findViewById(R.id.Spinner30);
    Spinner spinner29 = findViewById(R.id.Spinner29);
    Spinner spinner30 = findViewById(R.id.Spinner27);
    Spinner spinner56 = findViewById(R.id.Spinner25);
    Spinner spinner31 = findViewById(R.id.Spinner10);
    Spinner spinner32 = findViewById(R.id.Spinner40);
    Spinner spinner33 = findViewById(R.id.Spinner39);
    Spinner spinner35 = findViewById(R.id.Spinner38);
    Spinner spinner36 = findViewById(R.id.Spinner37);
    Spinner spinner37 = findViewById(R.id.Spinner36);
    Spinner spinner38 = findViewById(R.id.Spinner26);
    Spinner spinner39 = findViewById(R.id.Spinner28);
    Spinner spinner42 = findViewById(R.id.Spinner42);
    Spinner spinner43 = findViewById(R.id.Spinner41);
    Spinner spinner44 = findViewById(R.id.Spinner08);
    Spinner spinner45 = findViewById(R.id.Spinner07);
    Spinner spinner46 = findViewById(R.id.Spinner09);
    Spinner spinner47 = findViewById(R.id.Spinner12);
    Spinner spinner48 = findViewById(R.id.Spinner13);
    Spinner spinner49 = findViewById(R.id.Spinner46);
    Spinner spinner50 = findViewById(R.id.Spinner45);
    Spinner spinner51 = findViewById(R.id.Spinner44);
    Spinner spinner52 = findViewById(R.id.Spinner43);
    Spinner spinner53 = findViewById(R.id.Spinner15);
    Spinner spinner54 = findViewById(R.id.Spinner47);
    Spinner spinner55 = findViewById(R.id.Spinner16);

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
    spinner10.setAdapter(adapter);
    spinner14.setAdapter(adapter);
    spinner15.setAdapter(adapter);
    spinner17.setAdapter(adapter);
    spinner18.setAdapter(adapter);
    spinner19.setAdapter(adapter);
    spinner20.setAdapter(adapter);
    spinner21.setAdapter(adapter);
    spinner22.setAdapter(adapter);
    spinner23.setAdapter(adapter);
    spinner24.setAdapter(adapter);
    spinner25.setAdapter(adapter);
    spinner26.setAdapter(adapter);
    spinner27.setAdapter(adapter);
    spinner28.setAdapter(adapter);
    spinner29.setAdapter(adapter);
    spinner30.setAdapter(adapter);
    spinner31.setAdapter(adapter);
    spinner32.setAdapter(adapter);
    spinner33.setAdapter(adapter);
    spinner35.setAdapter(adapter);
    spinner36.setAdapter(adapter);
    spinner37.setAdapter(adapter);
    spinner38.setAdapter(adapter);
    spinner39.setAdapter(adapter);
    spinner42.setAdapter(adapter);
    spinner43.setAdapter(adapter);
    spinner44.setAdapter(adapter);
    spinner45.setAdapter(adapter);
    spinner46.setAdapter(adapter);
    spinner47.setAdapter(adapter);
    spinner48.setAdapter(adapter);
    spinner49.setAdapter(adapter);
    spinner50.setAdapter(adapter);
    spinner51.setAdapter(adapter);
    spinner52.setAdapter(adapter);
    spinner53.setAdapter(adapter);
    spinner54.setAdapter(adapter);
    spinner55.setAdapter(adapter);
    spinner56.setAdapter(adapter);

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

    SeekBar sb20 = findViewById(R.id.SP14seekbar);
    sb20.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView51);

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

    SeekBar sb21 = findViewById(R.id.SeekBar07);
    sb21.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView60);

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

    SeekBar sb22 = findViewById(R.id.SeekBar08);
    sb22.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView78);

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

    SeekBar sb23 = findViewById(R.id.SeekBar09);
    sb23.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView94);

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

    SeekBar sb24 = findViewById(R.id.SeekBar10);
    sb24.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView104);

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

    SeekBar sb25 = findViewById(R.id.SeekBar11);
    sb25.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView114);

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

    SeekBar sb26 = findViewById(R.id.SeekBar12);
    sb26.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      int progress;

      @Override
      public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        // TODO Auto-generated method stub
        TextView progresoBarra = findViewById(R.id.TextView132);

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
          Intent intent = new Intent(Planificacion_proyecto.this,
              ConfigurationManagementActivity.class);
          intent.putExtra("indice", indiceEvaluacion);
          Planificacion_proyecto.this.startActivity(intent);
        }
        if (area.equals("MA")) {
          Intent intent = new Intent(Planificacion_proyecto.this,
              MeasurementAnalysisManagementActivity.class);
          intent.putExtra("indice", indiceEvaluacion);
          Planificacion_proyecto.this.startActivity(intent);
        }
        if (area.equals("PPQA")) {
          Intent intent = new Intent(Planificacion_proyecto.this,
              Aseguramiento_calidad_proceso_producto.class);
          intent.putExtra("indice", indiceEvaluacion);
          Planificacion_proyecto.this.startActivity(intent);
        }
        if (area.equals("PMC")) {
          Intent intent = new Intent(Planificacion_proyecto.this,
              Monitorizacion_control_proyecto.class);
          intent.putExtra("indice", indiceEvaluacion);
          Planificacion_proyecto.this.startActivity(intent);
        }
        if (area.equals("PP")) {
        }
        if (area.equals("SAM")) {
          Intent intent = new Intent(Planificacion_proyecto.this,
              Gestion_acuerdos_proveedores.class);
          intent.putExtra("indice", indiceEvaluacion);
          Planificacion_proyecto.this.startActivity(intent);
        }
        if (area.equals("REQM")) {
          Intent intent = new Intent(Planificacion_proyecto.this,
              Gestion_requisitos.class);
          intent.putExtra("indice", indiceEvaluacion);
          Planificacion_proyecto.this.startActivity(intent);
        }
      }
    });

    Button botonAyuda = findViewById(R.id.button1);
    botonAyuda.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Planificacion_proyecto.this,
            HelpActivity.class);
        Planificacion_proyecto.this.startActivity(intent);
      }
    });

    //CARGAR DATOS DE EVALUACI�N

    SharedPreferences preferencias = getSharedPreferences(
        "planificacion_proyecto_" + indiceEvaluacion, Context.MODE_PRIVATE);

    //SeekBar sb1 = (SeekBar) findViewById(R.id.SP11Seekbar);
    sb1.setProgress(preferencias.getInt("SP11seekbar", 0));

    EditText SP11Edit1 = findViewById(R.id.SP11NotasNotasEdit);
    EditText SP11Edit2 = findViewById(R.id.SP11NotasFortalezasEdit);
    EditText SP11Edit3 = findViewById(R.id.SP11NotasDebilidadesEdit);
    SP11Edit1.setText(preferencias.getString("SP11edittext1", ""));
    SP11Edit2.setText(preferencias.getString("SP11edittext2", ""));
    SP11Edit3.setText(preferencias.getString("SP11edittext3", ""));

    SP11Edit1.setNextFocusDownId(R.id.SP11NotasFortalezasEdit);
    SP11Edit2.setNextFocusDownId(R.id.SP11NotasDebilidadesEdit);
    //SP11Edit3.setNextFocusDownId(R.id.SP11NotasFortalezasEdit);

    Spinner SP11spinner1 = findViewById(R.id.SP11EjemploInputSpinner);
    SP11spinner1.setSelection(preferencias.getInt("SP11spinner1", 0));
    EditText SP11Edit4 = findViewById(R.id.SP11EjemploInputText);
    SP11Edit4.setText(preferencias.getString("SP11edittext4", ""));
    Spinner SP11spinner2 = findViewById(R.id.spinner1);
    SP11spinner2.setSelection(preferencias.getInt("SP11spinner2", 0));
    EditText SP11Edit5 = findViewById(R.id.editText1);
    SP11Edit5.setText(preferencias.getString("SP11edittext5", ""));
    Spinner SP11spinner3 = findViewById(R.id.spinner2);
    SP11spinner3.setSelection(preferencias.getInt("SP11spinner3", 0));
    EditText SP11Edit6 = findViewById(R.id.editText2);
    SP11Edit6.setText(preferencias.getString("SP11edittext6", ""));

    SP11Edit3.setNextFocusDownId(R.id.SP11EjemploInputText);
    SP11Edit4.setNextFocusDownId(R.id.editText1);
    SP11Edit5.setNextFocusDownId(R.id.editText2);

    //SeekBar sb2 = (SeekBar) findViewById(R.id.SP12Seekbar);
    sb2.setProgress(preferencias.getInt("SP12seekbar", 0));

    EditText SP12Edit1 = findViewById(R.id.SP12NotasEvaluacionEdit);
    EditText SP12Edit2 = findViewById(R.id.SP12NotasFortalezasEdit);
    EditText SP12Edit3 = findViewById(R.id.SP12NotasDebilidadesEdit);
    SP12Edit1.setText(preferencias.getString("SP12edittext1", ""));
    SP12Edit2.setText(preferencias.getString("SP12edittext2", ""));
    SP12Edit3.setText(preferencias.getString("SP12edittext3", ""));

    SP11Edit6.setNextFocusDownId(R.id.SP12NotasEvaluacionEdit);
    SP12Edit1.setNextFocusDownId(R.id.SP12NotasFortalezasEdit);
    SP12Edit2.setNextFocusDownId(R.id.SP12NotasDebilidadesEdit);

    Spinner SP12spinner1 = findViewById(R.id.spinner08);
    SP12spinner1.setSelection(preferencias.getInt("SP12spinner1", 0));
    EditText SP12Edit4 = findViewById(R.id.editText20);
    SP12Edit4.setText(preferencias.getString("SP12edittext4", ""));
    Spinner SP12spinner2 = findViewById(R.id.spinner07);
    SP12spinner2.setSelection(preferencias.getInt("SP12spinner2", 0));
    EditText SP12Edit5 = findViewById(R.id.editText19);
    SP12Edit5.setText(preferencias.getString("SP12edittext5", ""));
    Spinner SP12spinner3 = findViewById(R.id.spinner04);
    SP12spinner3.setSelection(preferencias.getInt("SP12spinner3", 0));
    EditText SP12Edit6 = findViewById(R.id.editText07);
    SP12Edit6.setText(preferencias.getString("SP12edittext6", ""));
    Spinner SP12spinner4 = findViewById(R.id.spinner03);
    SP12spinner4.setSelection(preferencias.getInt("SP12spinner4", 0));
    EditText SP12Edit7 = findViewById(R.id.editText06);
    SP12Edit7.setText(preferencias.getString("SP12edittext7", ""));

    SP12Edit3.setNextFocusDownId(R.id.editText20);
    SP12Edit4.setNextFocusDownId(R.id.editText19);
    SP12Edit5.setNextFocusDownId(R.id.editText07);
    SP12Edit6.setNextFocusDownId(R.id.editText06);

    //SeekBar sb3 = (SeekBar) findViewById(R.id.SeekBar01);
    sb3.setProgress(preferencias.getInt("SP13seekbar", 0));

    EditText SP13Edit1 = findViewById(R.id.EditText03);
    EditText SP13Edit2 = findViewById(R.id.EditText04);
    EditText SP13Edit3 = findViewById(R.id.EditText02);
    SP13Edit1.setText(preferencias.getString("SP13edittext1", ""));
    SP13Edit2.setText(preferencias.getString("SP13edittext2", ""));
    SP13Edit3.setText(preferencias.getString("SP13edittext3", ""));

    SP12Edit7.setNextFocusDownId(R.id.EditText03);

    Spinner SP13spinner1 = findViewById(R.id.Spinner05);
    SP13spinner1.setSelection(preferencias.getInt("SP13spinner1", 0));
    EditText SP13Edit4 = findViewById(R.id.EditText08);
    SP13Edit4.setText(preferencias.getString("SP13edittext4", ""));

    sb20.setProgress(preferencias.getInt("SP14seekbar", 0));

    EditText SP14Edit1 = findViewById(R.id.EditText26);
    EditText SP14Edit2 = findViewById(R.id.EditText27);
    EditText SP14Edit3 = findViewById(R.id.EditText07);
    SP14Edit1.setText(preferencias.getString("SP14edittext1", ""));
    SP14Edit2.setText(preferencias.getString("SP14edittext2", ""));
    SP14Edit3.setText(preferencias.getString("SP14edittext3", ""));

    Spinner SP14spinner1 = findViewById(R.id.Spinner03);
    SP14spinner1.setSelection(preferencias.getInt("SP14spinner1", 0));
    EditText SP14Edit4 = findViewById(R.id.EditText06);
    SP14Edit4.setText(preferencias.getString("SP14edittext4", ""));
    Spinner SP14spinner2 = findViewById(R.id.Spinner04);
    SP14spinner2.setSelection(preferencias.getInt("SP14spinner2", 0));
    EditText SP14Edit5 = findViewById(R.id.EditText28);
    SP14Edit5.setText(preferencias.getString("SP14edittext5", ""));
    Spinner SP14spinner3 = findViewById(R.id.Spinner02);
    SP14spinner3.setSelection(preferencias.getInt("SP14spinner3", 0));
    EditText SP14Edit6 = findViewById(R.id.EditText05);
    SP14Edit6.setText(preferencias.getString("SP14edittext6", ""));

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
    Spinner SP21spinner2 = findViewById(R.id.Spinner14);
    SP21spinner2.setSelection(preferencias.getInt("SP21spinner2", 0));
    EditText SP21Edit5 = findViewById(R.id.EditText29);
    SP21Edit5.setText(preferencias.getString("SP21edittext5", ""));
    Spinner SP21spinner3 = findViewById(R.id.Spinner22);
    SP21spinner3.setSelection(preferencias.getInt("SP21spinner3", 0));
    EditText SP21Edit6 = findViewById(R.id.EditText60);
    SP21Edit6.setText(preferencias.getString("SP21edittext6", ""));

    //SeekBar sb5 = (SeekBar) findViewById(R.id.SeekBar04);
    sb5.setProgress(preferencias.getInt("SP22seekbar", 0));

    EditText SP22Edit1 = findViewById(R.id.EditText12);
    EditText SP22Edit2 = findViewById(R.id.EditText11);
    EditText SP22Edit3 = findViewById(R.id.EditText23);
    SP22Edit1.setText(preferencias.getString("SP22edittext1", ""));
    SP22Edit2.setText(preferencias.getString("SP22edittext2", ""));
    SP22Edit3.setText(preferencias.getString("SP22edittext3", ""));

    Spinner SP22spinner1 = findViewById(R.id.Spinner24);
    SP22spinner1.setSelection(preferencias.getInt("SP22spinner1", 0));
    EditText SP22Edit4 = findViewById(R.id.EditText62);
    SP22Edit4.setText(preferencias.getString("SP22edittext4", ""));
    Spinner SP22spinner2 = findViewById(R.id.Spinner23);
    SP22spinner2.setSelection(preferencias.getInt("SP22spinner2", 0));
    EditText SP22Edit5 = findViewById(R.id.EditText61);
    SP22Edit5.setText(preferencias.getString("SP22edittext5", ""));
    Spinner SP22spinner3 = findViewById(R.id.Spinner11);
    SP22spinner3.setSelection(preferencias.getInt("SP22spinner3", 0));
    EditText SP22Edit6 = findViewById(R.id.EditText13);
    SP22Edit6.setText(preferencias.getString("SP22edittext6", ""));

    sb6.setProgress(preferencias.getInt("SP23seekbar", 0));

    EditText SP23Edit1 = findViewById(R.id.EditText09);
    EditText SP23Edit2 = findViewById(R.id.EditText10);
    EditText SP23Edit3 = findViewById(R.id.EditText22);
    SP23Edit1.setText(preferencias.getString("SP23edittext1", ""));
    SP23Edit2.setText(preferencias.getString("SP23edittext2", ""));
    SP23Edit3.setText(preferencias.getString("SP23edittext3", ""));

    Spinner SP23spinner1 = findViewById(R.id.Spinner35);
    SP23spinner1.setSelection(preferencias.getInt("SP23spinner1", 0));
    EditText SP23Edit4 = findViewById(R.id.EditText71);
    SP23Edit4.setText(preferencias.getString("SP23edittext4", ""));
    Spinner SP23spinner2 = findViewById(R.id.Spinner34);
    SP23spinner2.setSelection(preferencias.getInt("SP23spinner2", 0));
    EditText SP23Edit5 = findViewById(R.id.EditText70);
    SP23Edit5.setText(preferencias.getString("SP23edittext5", ""));
    Spinner SP23spinner3 = findViewById(R.id.Spinner33);
    SP23spinner3.setSelection(preferencias.getInt("SP23spinner3", 0));
    EditText SP23Edit6 = findViewById(R.id.EditText69);
    SP23Edit6.setText(preferencias.getString("SP23edittext6", ""));
    Spinner SP23spinner4 = findViewById(R.id.Spinner32);
    SP23spinner4.setSelection(preferencias.getInt("SP23spinner4", 0));
    EditText SP23Edit7 = findViewById(R.id.EditText68);
    SP23Edit7.setText(preferencias.getString("SP23edittext7", ""));
    Spinner SP23spinner5 = findViewById(R.id.Spinner31);
    SP23spinner5.setSelection(preferencias.getInt("SP23spinner5", 0));
    EditText SP23Edit8 = findViewById(R.id.EditText67);
    SP23Edit8.setText(preferencias.getString("SP23edittext8", ""));
    Spinner SP23spinner6 = findViewById(R.id.Spinner30);
    SP23spinner6.setSelection(preferencias.getInt("SP23spinner6", 0));
    EditText SP23Edit9 = findViewById(R.id.EditText66);
    SP23Edit9.setText(preferencias.getString("SP23edittext9", ""));
    Spinner SP23spinner7 = findViewById(R.id.Spinner29);
    SP23spinner7.setSelection(preferencias.getInt("SP23spinner7", 0));
    EditText SP23Edit10 = findViewById(R.id.EditText65);
    SP23Edit10.setText(preferencias.getString("SP23edittext10", ""));
    Spinner SP23spinner8 = findViewById(R.id.Spinner27);
    SP23spinner8.setSelection(preferencias.getInt("SP23spinner8", 0));
    EditText SP23Edit11 = findViewById(R.id.EditText64);
    SP23Edit11.setText(preferencias.getString("SP23edittext11", ""));
    Spinner SP23spinner9 = findViewById(R.id.Spinner25);
    SP23spinner9.setSelection(preferencias.getInt("SP23spinner9", 0));
    EditText SP23Edit12 = findViewById(R.id.EditText63);
    SP23Edit12.setText(preferencias.getString("SP23edittext12", ""));
    Spinner SP23spinner10 = findViewById(R.id.Spinner10);
    SP23spinner10.setSelection(preferencias.getInt("SP23spinner10", 0));
    EditText SP23Edit13 = findViewById(R.id.EditText15);
    SP23Edit13.setText(preferencias.getString("SP23edittext13", ""));

    //SeekBar sb7 = (SeekBar) findViewById(R.id.SeekBar06);
    sb7.setProgress(preferencias.getInt("SP24seekbar", 0));

    EditText SP24Edit1 = findViewById(R.id.EditText47);
    EditText SP24Edit2 = findViewById(R.id.EditText48);
    EditText SP24Edit3 = findViewById(R.id.EditText38);
    SP24Edit1.setText(preferencias.getString("SP24edittext1", ""));
    SP24Edit2.setText(preferencias.getString("SP24edittext2", ""));
    SP24Edit3.setText(preferencias.getString("SP24edittext3", ""));

    Spinner SP24spinner1 = findViewById(R.id.Spinner40);
    SP24spinner1.setSelection(preferencias.getInt("SP24spinner1", 0));
    EditText SP24Edit4 = findViewById(R.id.EditText76);
    SP24Edit4.setText(preferencias.getString("SP24edittext4", ""));
    Spinner SP24spinner2 = findViewById(R.id.Spinner39);
    SP24spinner2.setSelection(preferencias.getInt("SP24spinner2", 0));
    EditText SP24Edit5 = findViewById(R.id.EditText75);
    SP24Edit5.setText(preferencias.getString("SP24edittext5", ""));
    Spinner SP24spinner3 = findViewById(R.id.Spinner38);
    SP24spinner3.setSelection(preferencias.getInt("SP24spinner3", 0));
    EditText SP24Edit6 = findViewById(R.id.EditText74);
    SP24Edit6.setText(preferencias.getString("SP24edittext6", ""));
    Spinner SP24spinner4 = findViewById(R.id.Spinner37);
    SP24spinner4.setSelection(preferencias.getInt("SP24spinner4", 0));
    EditText SP24Edit7 = findViewById(R.id.EditText73);
    SP24Edit7.setText(preferencias.getString("SP24edittext7", ""));
    Spinner SP24spinner5 = findViewById(R.id.Spinner36);
    SP24spinner5.setSelection(preferencias.getInt("SP24spinner5", 0));
    EditText SP24Edit8 = findViewById(R.id.EditText72);
    SP24Edit8.setText(preferencias.getString("SP24edittext8", ""));
    Spinner SP24spinner6 = findViewById(R.id.Spinner26);
    SP24spinner6.setSelection(preferencias.getInt("SP24spinner6", 0));
    EditText SP24Edit9 = findViewById(R.id.EditText44);
    SP24Edit9.setText(preferencias.getString("SP24edittext9", ""));
    Spinner SP24spinner7 = findViewById(R.id.Spinner28);
    SP24spinner7.setSelection(preferencias.getInt("SP24spinner7", 0));
    EditText SP24Edit10 = findViewById(R.id.EditText46);
    SP24Edit10.setText(preferencias.getString("SP24edittext10", ""));

    sb21.setProgress(preferencias.getInt("SP25seekbar", 0));

    EditText SP25Edit1 = findViewById(R.id.EditText20);
    EditText SP25Edit2 = findViewById(R.id.EditText24);
    EditText SP25Edit3 = findViewById(R.id.EditText25);
    SP25Edit1.setText(preferencias.getString("SP25edittext1", ""));
    SP25Edit2.setText(preferencias.getString("SP25edittext2", ""));
    SP25Edit3.setText(preferencias.getString("SP25edittext3", ""));

    Spinner SP25spinner1 = findViewById(R.id.Spinner42);
    SP25spinner1.setSelection(preferencias.getInt("SP25spinner1", 0));
    EditText SP25Edit4 = findViewById(R.id.EditText78);
    SP25Edit4.setText(preferencias.getString("SP25edittext4", ""));
    Spinner SP25spinner2 = findViewById(R.id.Spinner41);
    SP25spinner2.setSelection(preferencias.getInt("SP25spinner2", 0));
    EditText SP25Edit5 = findViewById(R.id.EditText77);
    SP25Edit5.setText(preferencias.getString("SP25edittext5", ""));
    Spinner SP25spinner3 = findViewById(R.id.Spinner08);
    SP25spinner3.setSelection(preferencias.getInt("SP25spinner3", 0));
    EditText SP25Edit6 = findViewById(R.id.EditText19);
    SP25Edit6.setText(preferencias.getString("SP25edittext6", ""));
    Spinner SP25spinner4 = findViewById(R.id.Spinner07);
    SP25spinner4.setSelection(preferencias.getInt("SP25spinner4", 0));
    EditText SP25Edit7 = findViewById(R.id.EditText21);
    SP25Edit7.setText(preferencias.getString("SP25edittext7", ""));

    sb22.setProgress(preferencias.getInt("SP26seekbar", 0));

    EditText SP26Edit1 = findViewById(R.id.EditText31);
    EditText SP26Edit2 = findViewById(R.id.EditText32);
    EditText SP26Edit3 = findViewById(R.id.EditText30);
    SP26Edit1.setText(preferencias.getString("SP26edittext1", ""));
    SP26Edit2.setText(preferencias.getString("SP26edittext2", ""));
    SP26Edit3.setText(preferencias.getString("SP26edittext3", ""));

    Spinner SP26spinner1 = findViewById(R.id.Spinner09);
    SP26spinner1.setSelection(preferencias.getInt("SP26spinner1", 0));
    EditText SP26Edit4 = findViewById(R.id.EditText33);
    SP26Edit4.setText(preferencias.getString("SP26edittext4", ""));

    sb23.setProgress(preferencias.getInt("SP27seekbar", 0));

    EditText SP27Edit1 = findViewById(R.id.EditText35);
    EditText SP27Edit2 = findViewById(R.id.EditText36);
    EditText SP27Edit3 = findViewById(R.id.EditText34);
    SP27Edit1.setText(preferencias.getString("SP27edittext1", ""));
    SP27Edit2.setText(preferencias.getString("SP27edittext2", ""));
    SP27Edit3.setText(preferencias.getString("SP27edittext3", ""));

    Spinner SP27spinner1 = findViewById(R.id.Spinner12);
    SP27spinner1.setSelection(preferencias.getInt("SP27spinner1", 0));
    EditText SP27Edit4 = findViewById(R.id.EditText37);
    SP27Edit4.setText(preferencias.getString("SP27edittext4", ""));

    sb24.setProgress(preferencias.getInt("SP32seekbar", 0));

    EditText SP31Edit1 = findViewById(R.id.EditText40);
    EditText SP31Edit2 = findViewById(R.id.EditText41);
    EditText SP31Edit3 = findViewById(R.id.EditText39);
    SP31Edit1.setText(preferencias.getString("SP31edittext1", ""));
    SP31Edit2.setText(preferencias.getString("SP31edittext2", ""));
    SP31Edit3.setText(preferencias.getString("SP31edittext3", ""));

    Spinner SP31spinner1 = findViewById(R.id.Spinner13);
    SP31spinner1.setSelection(preferencias.getInt("SP31spinner1", 0));
    EditText SP31Edit4 = findViewById(R.id.EditText42);
    SP31Edit4.setText(preferencias.getString("SP31edittext4", ""));

    sb25.setProgress(preferencias.getInt("SP32seekbar", 0));

    EditText SP32Edit1 = findViewById(R.id.EditText45);
    EditText SP32Edit2 = findViewById(R.id.EditText49);
    EditText SP32Edit3 = findViewById(R.id.EditText43);
    SP32Edit1.setText(preferencias.getString("SP32edittext1", ""));
    SP32Edit2.setText(preferencias.getString("SP32edittext2", ""));
    SP32Edit3.setText(preferencias.getString("SP32edittext3", ""));

    Spinner SP32spinner1 = findViewById(R.id.Spinner46);
    SP32spinner1.setSelection(preferencias.getInt("SP32spinner1", 0));
    EditText SP32Edit4 = findViewById(R.id.EditText82);
    SP32Edit4.setText(preferencias.getString("SP32edittext4", ""));
    Spinner SP32spinner2 = findViewById(R.id.Spinner45);
    SP32spinner2.setSelection(preferencias.getInt("SP32spinner2", 0));
    EditText SP32Edit5 = findViewById(R.id.EditText81);
    SP32Edit5.setText(preferencias.getString("SP32edittext5", ""));
    Spinner SP32spinner3 = findViewById(R.id.Spinner44);
    SP32spinner3.setSelection(preferencias.getInt("SP32spinner3", 0));
    EditText SP32Edit6 = findViewById(R.id.EditText80);
    SP32Edit6.setText(preferencias.getString("SP32edittext6", ""));
    Spinner SP32spinner4 = findViewById(R.id.Spinner43);
    SP32spinner4.setSelection(preferencias.getInt("SP32spinner4", 0));
    EditText SP32Edit7 = findViewById(R.id.EditText79);
    SP32Edit7.setText(preferencias.getString("SP32edittext7", ""));
    Spinner SP32spinner5 = findViewById(R.id.Spinner15);
    SP32spinner5.setSelection(preferencias.getInt("SP32spinner5", 0));
    EditText SP32Edit8 = findViewById(R.id.EditText50);
    SP32Edit8.setText(preferencias.getString("SP32edittext8", ""));

    sb26.setProgress(preferencias.getInt("SP33seekbar", 0));

    EditText SP33Edit1 = findViewById(R.id.EditText52);
    EditText SP33Edit2 = findViewById(R.id.EditText53);
    EditText SP33Edit3 = findViewById(R.id.EditText51);
    SP33Edit1.setText(preferencias.getString("SP33edittext1", ""));
    SP33Edit2.setText(preferencias.getString("SP33edittext2", ""));
    SP33Edit3.setText(preferencias.getString("SP33edittext3", ""));

    Spinner SP33spinner1 = findViewById(R.id.Spinner47);
    SP33spinner1.setSelection(preferencias.getInt("SP33spinner1", 0));
    EditText SP33Edit4 = findViewById(R.id.EditText83);
    SP33Edit4.setText(preferencias.getString("SP33edittext4", ""));
    Spinner SP33spinner2 = findViewById(R.id.Spinner16);
    SP33spinner2.setSelection(preferencias.getInt("SP33spinner2", 0));
    EditText SP33Edit5 = findViewById(R.id.EditText54);
    SP33Edit5.setText(preferencias.getString("SP33edittext5", ""));

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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.planificacion_proyecto, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.action_settings:
        Intent intent = new Intent(Planificacion_proyecto.this,
            AboutActivity.class);
        Planificacion_proyecto.this.startActivity(intent);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
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
        } else if (nombre.equals("MA")) {
          littleText.setText("Medici�n y an�lisis");
        } else if (nombre.equals("PMC")) {
          littleText.setText("Monitorizaci�n y control del proyecto");
        } else if (nombre.equals("PP")) {
          littleText.setText("Planificaci�n del proyecto");
          view.setBackgroundColor(Color.parseColor("#87CEFA"));
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
  }

}
