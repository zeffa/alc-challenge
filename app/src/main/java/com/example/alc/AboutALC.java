package com.example.alc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AboutALC extends AppCompatActivity {
    private static final String ANDELA_ABOUT_URL = "https://andela.com/alc/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setElevation(0);
        }
        WebView aboutAlcView = findViewById(R.id.about_alc_view);
        ProgressBar progressBar = findViewById(R.id.progress_circular);
        aboutAlcView.getSettings().setJavaScriptEnabled(true);
        aboutAlcView.getSettings().setDomStorageEnabled(true);
        aboutAlcView.setWebViewClient(new WBClient(progressBar));
        aboutAlcView.loadUrl(ANDELA_ABOUT_URL);
    }

    private class WBClient extends WebViewClient {
        private ProgressBar progressBar;

        private WBClient(ProgressBar progressBar){
            this.progressBar = progressBar;
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
