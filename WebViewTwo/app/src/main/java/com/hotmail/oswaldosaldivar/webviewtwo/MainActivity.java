package com.hotmail.oswaldosaldivar.webviewtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.web);

        String url = "file:///android_asset/video.html";

        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.loadUrl(url);
        web.setWebViewClient(new WebViewClient()
        {
                             public boolean shouldOverrideUrlLoading(WebView view, String url){
                                 return  false;
                             }
                             }

        );
    }
}
