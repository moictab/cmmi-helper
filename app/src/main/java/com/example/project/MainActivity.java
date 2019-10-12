package com.example.project;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	GestorSQLiteHelper gestor = new GestorSQLiteHelper(this, "databasefile",
			null, 1);

	protected void onCreate(Bundle savedInstanceState) {

		setTitle("Inicio");

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GridView grid = (GridView) findViewById(R.id.gridView1);
		grid.setAdapter(new ImageAdapter(this));

		Button buttonNuevaOrganizacion = (Button) findViewById(R.id.buttonNuevaOrganizacion);
		Button buttonAyudaCMMI = (Button) findViewById(R.id.buttonAyudaCMMI_AM);

		buttonNuevaOrganizacion.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						Nueva_organizacion.class);
				MainActivity.this.startActivity(intent);
			}
		});

		buttonAyudaCMMI.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Ayuda_CMMI.class);
				MainActivity.this.startActivity(intent);
			}
		});

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this,
						Consultar_organizacion.class);
				intent.putExtra("posicion", position);
				MainActivity.this.startActivity(intent);
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {

		SQLiteDatabase database = gestor.getWritableDatabase();
		Cursor cursor = database.rawQuery("SELECT * FROM Organizaciones", null);
		boolean bol = cursor.moveToFirst();
		int contador = 0;
		View v;
		ImageView iv;
		TextView tv = null;

		Context mContext;
		public static final int ACTIVITY_CREATE = 10;

		public ImageAdapter(Context context) {
			mContext = context;
		}

		@Override
		public int getCount() {
			return cursor.getCount();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			Bitmap myBitmap = null;

			if (convertView == null) {
				String nombreOrg = cursor.getString(1);
				File imgFile = new File(cursor.getString(0));

				if (imgFile.exists()) {
					myBitmap = BitmapFactory.decodeFile(imgFile
							.getAbsolutePath());
				}

				if (contador < cursor.getCount() - 1) {
					cursor.moveToNext();
					contador++;
				}
				LayoutInflater li = getLayoutInflater();
				v = li.inflate(R.layout.icon, null);
				tv = (TextView) v.findViewById(R.id.icon_text);
				tv.setText(nombreOrg);
				iv = (ImageView) v.findViewById(R.id.icon_image);

				if (myBitmap != null) {
					iv.setImageBitmap(myBitmap);
				} else {
					iv.setImageResource(R.drawable.cmmi_icon);
				}
				// iv.setImageBitmap(image)

			} else {
				v = convertView;
			}

			return v;
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent intent = new Intent(MainActivity.this, Acerca_de.class);
			MainActivity.this.startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void onResume() {
		super.onResume();
		setTitle("Inicio");

		setContentView(R.layout.activity_main);

		GridView grid = (GridView) findViewById(R.id.gridView1);
		grid.setAdapter(new ImageAdapter(this));

		Button buttonNuevaOrganizacion = (Button) findViewById(R.id.buttonNuevaOrganizacion);
		Button buttonAyudaCMMI = (Button) findViewById(R.id.buttonAyudaCMMI_AM);

		buttonNuevaOrganizacion.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						Nueva_organizacion.class);
				MainActivity.this.startActivity(intent);
			}
		});

		buttonAyudaCMMI.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Ayuda_CMMI.class);
				MainActivity.this.startActivity(intent);
			}
		});

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this,
						Consultar_organizacion.class);
				intent.putExtra("posicion", position);
				MainActivity.this.startActivity(intent);
			}
		});
	}

}