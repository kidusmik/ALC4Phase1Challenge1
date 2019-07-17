package com.kidus.alc4phase1challenge1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    private class ALCwebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error){
            AlertDialog.Builder builder = new AlertDialog.Builder(AboutALCActivity.this);
            String errorMessage = "SSL Certificate error found, which is unsafe " +
                    "and will leave you vulnerable to attacks, " +
                    "do you want to continue anyway?";
            String errorTitle = "SSL Certificate Error";
            builder.setTitle(errorTitle);
            builder.setMessage(errorMessage);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.proceed();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.cancel();
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webALC = (WebView) findViewById(R.id.web_about_alc);
        webALC.setWebViewClient(new ALCwebViewClient());
        String ALCurl = "https://andela.com/alc";
        webALC.loadUrl(ALCurl);
    }
}