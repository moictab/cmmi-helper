package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

public class MainActivity extends Activity {

    private static final String POSITION = "POSITION";
    private static final String DATABASE = "DATABASE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        GridView gvOrganizations = findViewById(R.id.gvOrganizations);
        gvOrganizations.setAdapter(new ImageAdapter(this));
        gvOrganizations.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this, OrganizationDetailsActivity.class);
                intent.putExtra(POSITION, position);
                MainActivity.this.startActivity(intent);
            }
        });

        FloatingActionButton fabNewOrganization = findViewById(R.id.fabNewOrganization);
        fabNewOrganization.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewOrganizationActivity.class);
                startActivity(intent);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        CustomSQLiteHelper helper = new CustomSQLiteHelper(MainActivity.this, DATABASE, null, 1);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Organizaciones", null);
        boolean bol = cursor.moveToFirst();
        int contador = 0;

        View v;
        ImageView iv;
        TextView tv = null;
        Context context;

        ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return cursor.getCount();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Bitmap myBitmap = null;

            if (convertView == null) {
                String organizationName = cursor.getString(1);
                File imagePath = new File(cursor.getString(0));

                if (imagePath.exists()) {
                    myBitmap = BitmapFactory.decodeFile(imagePath.getAbsolutePath());
                }

                if (contador < cursor.getCount() - 1) {
                    cursor.moveToNext();
                    contador++;
                }

                LayoutInflater li = getLayoutInflater();
                v = li.inflate(R.layout.icon, null);
                tv = v.findViewById(R.id.icon_text);
                tv.setText(organizationName);
                iv = v.findViewById(R.id.icon_image);

                if (myBitmap != null) {
                    iv.setImageBitmap(myBitmap);
                } else {
                    iv.setImageResource(R.drawable.cmmi_icon);
                }

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

}
