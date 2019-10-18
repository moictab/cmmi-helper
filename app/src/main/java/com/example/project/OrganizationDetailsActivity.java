package com.example.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OrganizationDetailsActivity extends Activity {

  private static int RESULT_LOAD_IMAGE = 1;

  private String picturePath = "";
  private String snotas = "";
  private String snombre = "";
  private String scargo = "";
  private String scorreo = "";
  private String stelefono = "";
  private CustomSQLiteHelper helper = new CustomSQLiteHelper(this, "database",
      null, 1);
  private int posicion = 0;
  private String name;
  private String notas;

  private TextView tv2;
  private TextView tv3;
  private TextView tv4;
  private TextView tv5;
  private TextView tv6;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_organization_details);

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
      posicion = extras.getInt("posicion");
    }

    SQLiteDatabase database = helper.getWritableDatabase();
    Cursor cursor = database.rawQuery("SELECT * FROM Organizaciones", null);
    cursor.moveToFirst();

    for (int i = 0; i < posicion; i++) {
      cursor.moveToNext();
    }

    ListView listView = findViewById(R.id.listView1);
    Button btnRemove = findViewById(R.id.btn_remove);
    Button btnSave = findViewById(R.id.buttonGuardarOrganizacion);
    Button botonNuevaEvaluacion = findViewById(R.id.button3);
    Button botonAyudaCMMI = findViewById(R.id.buttonAyudaCMMI_NO);
    Button botonAnadirIcono = findViewById(R.id.buttonAnadirIcono);

    TextView tv1 = findViewById(R.id.SP11NotasNotasEdit);
    tv2 = findViewById(R.id.editText7);
    tv3 = findViewById(R.id.SP11NotasDebilidadesEdit);
    tv4 = findViewById(R.id.SP11EjemploInputText);
    tv5 = findViewById(R.id.editText5);
    tv6 = findViewById(R.id.editText6);

    tv1.setText(String.valueOf(cursor.getString(1)));
    tv1.setKeyListener(null);
    tv1.setFocusable(false);

    if (snotas.matches("")) {
      tv2.setText(String.valueOf(cursor.getString(2)));
    } else {
      tv2.setText(snotas);
    }
    if (snombre.matches("")) {
      tv3.setText(String.valueOf(cursor.getString(3)));
    } else {
      tv3.setText(snombre);
    }
    if (scargo.matches("")) {
      tv4.setText(String.valueOf(cursor.getString(4)));
    } else {
      tv4.setText(scargo);
    }
    if (scorreo.matches("")) {
      tv5.setText(String.valueOf(cursor.getString(5)));
    } else {
      tv5.setText(scorreo);
    }
    if (stelefono.matches("")) {
      tv6.setText(String.valueOf(cursor.getString(6)));
    } else {
      tv6.setText(stelefono);
    }

    name = cursor.getString(1);
    listView.setAdapter(new ItemAdapter(this, name));

    notas = cursor.getString(2);

    cursor.close();

    listView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
          long arg3) {
        // TODO Auto-generated method stub

        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor2 = database.rawQuery(
            "SELECT * FROM Evaluaciones WHERE ref_org = '" + name
                + "'", null);
        cursor2.moveToFirst();
        cursor2.moveToPosition(arg2);

        Intent intent2 = new Intent(OrganizationDetailsActivity.this,
            Plot.class);
        intent2.putExtra("indice", cursor2.getInt(0));
        OrganizationDetailsActivity.this.startActivity(intent2);
      }
    });

    botonAnadirIcono.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
        // TODO Auto-generated method stub

        snotas = tv2.getText().toString();
        snombre = tv3.getText().toString();
        scargo = tv4.getText().toString();
        scorreo = tv5.getText().toString();
        stelefono = tv6.getText().toString();

        Intent i = new Intent(
            Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        /*
         * i.putExtra("notas", tv2.getText().toString());
         * i.putExtra("nombre", tv3.getText().toString());
         * i.putExtra("cargo", tv4.getText().toString());
         * i.putExtra("correo", tv5.getText().toString());
         * i.putExtra("telefono", tv6.getText().toString());
         */

        startActivityForResult(i, RESULT_LOAD_IMAGE);
      }
    });

    botonAyudaCMMI.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(OrganizationDetailsActivity.this,
            HelpActivity.class);
        OrganizationDetailsActivity.this.startActivity(intent);

      }
    });

    botonNuevaEvaluacion.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(OrganizationDetailsActivity.this,
            NewEvaluationActivity.class);
        intent.putExtra("nombre_org", name);
        intent.putExtra("notas_org", notas);
        OrganizationDetailsActivity.this.startActivity(intent);
      }
    });

    btnSave.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        SQLiteDatabase database = helper.getWritableDatabase();
        if (database != null) {
          /*
           * database.execSQL("UPDATE Organizaciones SET logotipo_org = '"
           * + imageInByte + "',notas_org= '"
           */

          if (picturePath.matches("")) {
            database.execSQL("UPDATE Organizaciones SET notas_org= '"
                + tv2.getText().toString()
                + "',nombre_per= '"
                + tv3.getText().toString()
                + "',cargo_per= '"
                + tv4.getText().toString()
                + "',correo_per= '"
                + tv5.getText().toString()
                + "',telefono_per= '"
                + tv6.getText()
                + "' WHERE nombre_org = '" + name + "'");
            database.close();
          } else {
            database.execSQL("UPDATE Organizaciones SET logotipo_org = '"
                + picturePath
                + "', notas_org= '"
                + tv2.getText().toString()
                + "',nombre_per= '"
                + tv3.getText().toString()
                + "',cargo_per= '"
                + tv4.getText().toString()
                + "',correo_per= '"
                + tv5.getText().toString()
                + "',telefono_per= '"
                + tv6.getText()
                + "' WHERE nombre_org = '" + name + "'");
            database.close();
          }
        }

        Toast.makeText(getApplicationContext(),
            "Se han guardado las modificaciones", Toast.LENGTH_LONG)
            .show();
      }
    });

    btnRemove.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder = new AlertDialog.Builder(
            OrganizationDetailsActivity.this);
        builder.setTitle(
            "�Seguro que quieres eliminar esta organizaci�n?")
            .setMessage(
                "Esto eliminar� todos los datos de la organizaci�n y sus evaluaciones asociadas. �Est�s seguro?")
            .setCancelable(false)
            .setPositiveButton("Cancelar", null)
            .setNegativeButton("Eliminar",
                new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog,
                      int id) {
                    SQLiteDatabase database = helper
                        .getWritableDatabase();
                    if (database != null) {
                      database.execSQL("DELETE FROM Organizaciones WHERE nombre_org = '"
                          + name + "'");

                      database.execSQL("DELETE FROM Evaluaciones WHERE ref_org = '"
                          + name + "'");

                      database.close();
                    }

                    Toast.makeText(
                        getApplicationContext(),
                        "Se ha eliminado la organizaci�n",
                        Toast.LENGTH_LONG).show();

                    finish();

                    /*
                     * Intent intent = new Intent(
                     * Consultar_organizacion.this,
                     * MainActivity.class);
                     * Consultar_organizacion.this
                     * .startActivity(intent);
                     */
                  }
                });
        AlertDialog alert = builder.create();
        alert.show();
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    snotas = tv2.getText().toString();
    snombre = tv3.getText().toString();
    scargo = tv4.getText().toString();
    scorreo = tv5.getText().toString();
    stelefono = tv6.getText().toString();

    if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
        && null != data) {
      Uri selectedImage = data.getData();
      String[] filePathColumn = {MediaStore.Images.Media.DATA};

      Cursor cursor = getContentResolver().query(selectedImage,
          filePathColumn, null, null, null);
      cursor.moveToFirst();

      int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
      picturePath = cursor.getString(columnIndex);
      cursor.close();

    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.consultar_organizacion, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.action_settings:
        Intent intent = new Intent(OrganizationDetailsActivity.this,
            AboutActivity.class);
        OrganizationDetailsActivity.this.startActivity(intent);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  public void onResume() {
    super.onResume();

    SQLiteDatabase database = helper.getWritableDatabase();
    Cursor cursorOrganizaciones = database.rawQuery(
        "SELECT * FROM Organizaciones", null);
    cursorOrganizaciones.moveToFirst();

    ListView listView = findViewById(R.id.listView1);

    // name = cursorOrganizaciones.getString(1).toString(); //onresume
    listView.setAdapter(new ItemAdapter(this, name));
    listView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
          long arg3) {
        // TODO Auto-generated method stub

        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery(
            "SELECT * FROM Evaluaciones WHERE ref_org = '" + name
                + "'", null);
        cursor.moveToFirst();
        cursor.moveToPosition(arg2);

        Intent intent2 = new Intent(OrganizationDetailsActivity.this,
            Plot.class);
        intent2.putExtra("indice", cursor.getInt(0));
        cursor.close();
        OrganizationDetailsActivity.this.startActivity(intent2);

      }
    });

  }/*
   *
   * setContentView(R.layout.activity_consultar_organizacion);
   *
   * Bundle extras = getIntent().getExtras(); if (extras != null) { posicion =
   * extras.getInt("posicion"); }
   *
   * SQLiteDatabase database = helper.getWritableDatabase(); Cursor
   * cursorOrganizaciones = database.rawQuery( "SELECT * FROM Organizaciones",
   * null); cursorOrganizaciones.moveToFirst();
   *
   * for (int i = 0; i < posicion; i++) { cursorOrganizaciones.moveToNext(); }
   *
   * ListView listView1 = (ListView) findViewById(R.id.listView1);
   *
   * Button botonEliminar = (Button) findViewById(R.id.button2); Button
   * botonGuardar = (Button) findViewById(R.id.buttonGuardarOrganizacion);
   * Button botonNuevaEvaluacion = (Button) findViewById(R.id.button3); Button
   * botonAyudaCMMI = (Button) findViewById(R.id.buttonAyudaCMMI_NO); Button
   * botonAnadirIcono = (Button) findViewById(R.id.buttonAnadirIcono);
   *
   * tv1 = (TextView) findViewById(R.id.SP11NotasNotasEdit); tv2 = (TextView)
   * findViewById(R.id.editText7); tv3 = (TextView)
   * findViewById(R.id.SP11NotasDebilidadesEdit); tv4 = (TextView)
   * findViewById(R.id.SP11EjemploInputText); tv5 = (TextView)
   * findViewById(R.id.editText5); tv6 = (TextView)
   * findViewById(R.id.editText6);
   *
   * tv1.setText(String.valueOf(cursorOrganizaciones.getString(1)));
   * tv1.setKeyListener(null); tv1.setFocusable(false); if
   * (snotas.matches("")) {
   * tv2.setText(String.valueOf(cursorOrganizaciones.getString(2))); } else {
   * tv2.setText(snotas); } if (snombre.matches("")) {
   * tv3.setText(String.valueOf(cursorOrganizaciones.getString(3))); } else {
   * tv3.setText(snombre); } if (scargo.matches("")) {
   * tv4.setText(String.valueOf(cursorOrganizaciones.getString(4))); } else {
   * tv4.setText(scargo); } if (scorreo.matches("")) {
   * tv5.setText(String.valueOf(cursorOrganizaciones.getString(5))); } else {
   * tv5.setText(scorreo); } if (stelefono.matches("")) {
   * tv6.setText(String.valueOf(cursorOrganizaciones.getString(6))); } else {
   * tv6.setText(stelefono); } name =
   * cursorOrganizaciones.getString(1).toString(); listView1.setAdapter(new
   * ItemAdapter(this, name));
   *
   * ListView listView = (ListView) findViewById(R.id.listView1);
   * listView.setOnItemClickListener(new OnItemClickListener() {
   *
   * @Override public void onItemClick(AdapterView<?> arg0, View arg1, int
   * arg2, long arg3) { // TODO Auto-generated method stub
   *
   * SQLiteDatabase database = helper.getReadableDatabase(); Cursor cursor =
   * database.rawQuery( "SELECT * FROM Evaluaciones WHERE ref_org = '" + name
   * + "'", null); cursor.moveToFirst(); cursor.moveToPosition(arg2);
   *
   * Intent intent2 = new Intent(Consultar_organizacion.this, Plot.class);
   * intent2.putExtra("indice", cursor.getInt(0));
   * Consultar_organizacion.this.startActivity(intent2);
   *
   *
   * } });
   *
   * botonAnadirIcono.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View arg0) { // TODO Auto-generated method
   * stub Intent i = new Intent( Intent.ACTION_PICK,
   * android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
   * startActivityForResult(i, RESULT_LOAD_IMAGE); } });
   *
   * botonAyudaCMMI.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { Intent intent = new
   * Intent(Consultar_organizacion.this, Ayuda_CMMI.class);
   * Consultar_organizacion.this.startActivity(intent);
   *
   * } });
   *
   * botonNuevaEvaluacion.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { // TODO Auto-generated method
   * stub Intent intent = new Intent(Consultar_organizacion.this,
   * Nueva_evaluacion.class); intent.putExtra("nombre_org", name);
   * Consultar_organizacion.this.startActivity(intent); } });
   *
   * botonGuardar.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { // TODO Auto-generated method
   * stub SQLiteDatabase database = helper.getWritableDatabase(); if (database
   * != null) {
   *
   * database.execSQL("UPDATE Organizaciones SET logotipo_org = '" +
   * picturePath + "', notas_org= '" + tv2.getText().toString() +
   * "',nombre_per= '" + tv3.getText().toString() + "',cargo_per= '" +
   * tv4.getText().toString() + "',correo_per= '" + tv5.getText().toString() +
   * "',telefono_per= '" + tv6.getText() + "' WHERE nombre_org = '" + name +
   * "'"); database.close(); }
   *
   * Toast.makeText(getApplicationContext(),
   * "Se han guardado las modificaciones", Toast.LENGTH_LONG) .show();
   *
   * } });
   *
   * botonEliminar.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { // TODO Auto-generated method
   * stub AlertDialog.Builder builder = new AlertDialog.Builder(
   * Consultar_organizacion.this); builder.setTitle(
   * "�Seguro que quieres eliminar esta organizaci�n?") .setMessage(
   * "Esto eliminar� todos los datos de la organizaci�n y sus evaluaciones asociadas. �Est�s seguro?"
   * ) .setCancelable(false) .setPositiveButton("Cancelar", null)
   * .setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
   * public void onClick(DialogInterface dialog, int id) { SQLiteDatabase
   * database = helper .getWritableDatabase(); if (database != null) {
   * database.execSQL("DELETE FROM Organizaciones WHERE nombre_org = '" + name
   * + "'"); database.close(); }
   *
   * Intent intent = new Intent( Consultar_organizacion.this,
   * MainActivity.class); Consultar_organizacion.this .startActivity(intent);
   * } }); AlertDialog alert = builder.create(); alert.show(); } }); }
   */

  public class ItemAdapter extends BaseAdapter {

    public static final int ACTIVITY_CREATE = 10;
    SQLiteDatabase database = helper.getWritableDatabase();
    Cursor cursor3;
    int contador = 0;
    View view;
    TextView big;
    TextView little = null;
    Context mContext;

    ItemAdapter(Context context, String nombre_org) {
      mContext = context;
      cursor3 = database.rawQuery(
          "SELECT * FROM Evaluaciones WHERE ref_org = '" + nombre_org
              + "'", null);
      cursor3.moveToFirst();
    }

    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return cursor3.getCount();
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
        String nombreEv = cursor3.getString(1);
        String fechaEv = cursor3.getString(2);
        String notasEv = cursor3.getString(3);
        if (contador < cursor3.getCount() - 1) {
          cursor3.moveToNext();
          contador++;
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        view = layoutInflater.inflate(R.layout.list_item, null);
        big = view.findViewById(R.id.big_text);
        big.setText(nombreEv);
        little = view.findViewById(R.id.little_text);

        if (notasEv.length() == 0 || notasEv == "" || notasEv.isEmpty()) {
          little.setText(fechaEv);
        } else {
          little.setText(fechaEv + ", " + notasEv);
        }
      } else {
        view = convertView;
      }
      return view;
    }
  }

  /*
   * protected void onRestart(){ super.onRestart();
   *
   * setContentView(R.layout.activity_consultar_organizacion);
   *
   * Bundle extras = getIntent().getExtras(); if (extras != null) { posicion =
   * extras.getInt("posicion"); }
   *
   * SQLiteDatabase database = helper.getWritableDatabase(); Cursor
   * cursorOrganizaciones = database.rawQuery( "SELECT * FROM Organizaciones",
   * null); cursorOrganizaciones.moveToFirst();
   *
   * for (int i = 0; i < posicion; i++) { cursorOrganizaciones.moveToNext(); }
   *
   * ListView listView1 = (ListView) findViewById(R.id.listView1);
   *
   * Button botonEliminar = (Button) findViewById(R.id.button2); Button
   * botonGuardar = (Button) findViewById(R.id.buttonGuardarOrganizacion);
   * Button botonNuevaEvaluacion = (Button) findViewById(R.id.button3); Button
   * botonAyudaCMMI = (Button) findViewById(R.id.buttonAyudaCMMI_NO); Button
   * botonAnadirIcono = (Button) findViewById(R.id.buttonAnadirIcono);
   *
   * tv1 = (TextView) findViewById(R.id.SP11NotasNotasEdit); tv2 = (TextView)
   * findViewById(R.id.editText7); tv3 = (TextView)
   * findViewById(R.id.SP11NotasDebilidadesEdit); tv4 = (TextView)
   * findViewById(R.id.SP11EjemploInputText); tv5 = (TextView)
   * findViewById(R.id.editText5); tv6 = (TextView)
   * findViewById(R.id.editText6);
   *
   * tv1.setText(String.valueOf(cursorOrganizaciones.getString(1)));
   * tv1.setKeyListener(null); tv1.setFocusable(false); if
   * (snotas.matches("")) {
   * tv2.setText(String.valueOf(cursorOrganizaciones.getString(2))); } else {
   * tv2.setText(snotas); } if (snombre.matches("")) {
   * tv3.setText(String.valueOf(cursorOrganizaciones.getString(3))); } else {
   * tv3.setText(snombre); } if (scargo.matches("")) {
   * tv4.setText(String.valueOf(cursorOrganizaciones.getString(4))); } else {
   * tv4.setText(scargo); } if (scorreo.matches("")) {
   * tv5.setText(String.valueOf(cursorOrganizaciones.getString(5))); } else {
   * tv5.setText(scorreo); } if (stelefono.matches("")) {
   * tv6.setText(String.valueOf(cursorOrganizaciones.getString(6))); } else {
   * tv6.setText(stelefono); } name =
   * cursorOrganizaciones.getString(1).toString(); listView1.setAdapter(new
   * ItemAdapter(this, name));
   *
   * ListView listView = (ListView) findViewById(R.id.listView1);
   * listView.setOnItemClickListener(new OnItemClickListener() {
   *
   * @Override public void onItemClick(AdapterView<?> arg0, View arg1, int
   * arg2, long arg3) { // TODO Auto-generated method stub
   *
   * SQLiteDatabase database = helper.getReadableDatabase(); Cursor cursor =
   * database.rawQuery( "SELECT * FROM Evaluaciones WHERE ref_org = '" + name
   * + "'", null); cursor.moveToFirst(); cursor.moveToPosition(arg2);
   *
   * Intent intent2 = new Intent(Consultar_organizacion.this, Plot.class);
   * intent2.putExtra("indice", cursor.getInt(0));
   * Consultar_organizacion.this.startActivity(intent2);
   *
   * } });
   *
   * botonAnadirIcono.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View arg0) { // TODO Auto-generated method
   * stub Intent i = new Intent( Intent.ACTION_PICK,
   * android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
   * startActivityForResult(i, RESULT_LOAD_IMAGE); } });
   *
   * botonAyudaCMMI.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { Intent intent = new
   * Intent(Consultar_organizacion.this, Ayuda_CMMI.class);
   * Consultar_organizacion.this.startActivity(intent);
   *
   * } });
   *
   * botonNuevaEvaluacion.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { // TODO Auto-generated method
   * stub Intent intent = new Intent(Consultar_organizacion.this,
   * Nueva_evaluacion.class); intent.putExtra("nombre_org", name);
   * Consultar_organizacion.this.startActivity(intent); } });
   *
   * botonGuardar.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { // TODO Auto-generated method
   * stub SQLiteDatabase database = helper.getWritableDatabase(); if (database
   * != null) { database.execSQL("UPDATE Organizaciones SET logotipo_org = '"
   * + picturePath + "', notas_org= '" + tv2.getText().toString() +
   * "',nombre_per= '" + tv3.getText().toString() + "',cargo_per= '" +
   * tv4.getText().toString() + "',correo_per= '" + tv5.getText().toString() +
   * "',telefono_per= '" + tv6.getText() + "' WHERE nombre_org = '" + name +
   * "'"); database.close(); }
   *
   * Toast.makeText(getApplicationContext(),
   * "Se han guardado las modificaciones", Toast.LENGTH_LONG) .show();
   *
   * } });
   *
   * botonEliminar.setOnClickListener(new View.OnClickListener() {
   *
   * @Override public void onClick(View v) { // TODO Auto-generated method
   * stub AlertDialog.Builder builder = new AlertDialog.Builder(
   * Consultar_organizacion.this); builder.setTitle(
   * "�Seguro que quieres eliminar esta organizaci�n?") .setMessage(
   * "Esto eliminar� todos los datos de la organizaci�n y sus evaluaciones asociadas. �Est�s seguro?"
   * ) .setCancelable(false) .setPositiveButton("Cancelar", null)
   * .setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
   * public void onClick(DialogInterface dialog, int id) { SQLiteDatabase
   * database = helper .getWritableDatabase(); if (database != null) {
   * database.execSQL("DELETE FROM Organizaciones WHERE nombre_org = '" + name
   * + "'"); database.close(); }
   *
   * Intent intent = new Intent( Consultar_organizacion.this,
   * MainActivity.class); Consultar_organizacion.this .startActivity(intent);
   * } }); AlertDialog alert = builder.create(); alert.show(); } }); }
   */
}
