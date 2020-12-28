package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class HelpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        WebView mWebView = findViewById(R.id.webView1);
        mWebView.loadUrl("file:///android_asset/ejemplo.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ayuda__cmmi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(HelpActivity.this, AboutActivity.class);
            HelpActivity.this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
