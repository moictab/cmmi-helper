package com.example.project;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;

public class Acerca_de extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acerca_de);
		
		int text = R.string.acerca_text;
		TextView tv = (TextView) findViewById (R.id.textView1);
		tv.setText(Html.fromHtml(getString(text)));
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acerca_de, menu);
		return true;
	}*/

}
