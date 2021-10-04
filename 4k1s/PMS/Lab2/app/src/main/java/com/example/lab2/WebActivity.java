package com.example.lab2;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("https://www.google.com/");
    }
}