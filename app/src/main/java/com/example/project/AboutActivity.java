package com.example.project;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        int text = R.string.acerca_text;
        TextView tv = findViewById(R.id.textView1);
        tv.setText(Html.fromHtml(getString(text)));
    }
}
