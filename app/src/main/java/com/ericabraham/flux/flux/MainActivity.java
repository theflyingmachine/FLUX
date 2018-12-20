package com.ericabraham.flux.flux;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private WebView WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar

        //hide notificationbar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
          //      WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen


        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webview);

        this.WebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);



//        webView.loadUrl("https://cyberboy.in");http://corpindat01.northamerica.cerner.net/SO_FLE/status
//        webView.loadUrl("https://sofle.cerner.com/SO_FLE/view_mobile.php");
        webView.loadUrl("http://corpindat01.northamerica.cerner.net/SO_FLE/view_mobile.php");
//        webView.loadUrl("https://10.182.235.218/SO_FLE/view_mobile.php");

    }

    private class WebViewClientImpl extends WebViewClient {
        public WebViewClientImpl(MainActivity mainActivity) {

        }
    }
}

