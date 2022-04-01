package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView web;
    String url;
    TextView browse;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button3);
        browse = findViewById(R.id.editTextTextPersonName);
        web = findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.google.fi");

    }
    public void executeJavascript(View v) {

        web.evaluateJavascript("javascript:shoutOut()", null);
    }
    public void JavascriptInitialize(View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void browseWeb(View v) {
        url=browse.getText().toString();
        if (url.equals("index.html")){
            web.loadUrl("file:///android_asset/index.html");
            executeJavascript(v);
        }
        else {
            web.loadUrl("http://"+url);
        }

    }

    public void refreshPage(View v) {
        if (url.length()==0){
            url="www.google.fi";
        }
        if (url.equals("index.html")){
            return;
        }
        web.loadUrl("http://"+url);
    }
    public void nextPage(View v){
        if (web.canGoForward()){
            web.goForward();
        }
        else{
            return;
        }
    }
    public void previousPage(View v){
        if (web.canGoBack()){
            web.goBack();
        }
        else{
            return;
        }
    }
}