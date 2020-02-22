package com.wcmc.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webview);
        String URL="https://akshaygelani.site";
        webView.loadUrl(URL);
        webView.getSettings().setJavaScriptEnabled(true);

        this.setTitle(URL);

    }
}
