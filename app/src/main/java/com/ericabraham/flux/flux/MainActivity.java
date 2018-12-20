package com.ericabraham.flux.flux;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout mySwipeRefreshLayout;
    String url ="http://corpindat01.northamerica.cerner.net/SO_FLE/view_mobile.php";

//    private WebView WebView;
    private WebView view;
    private boolean doubleBackToExitPressedOnce;

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

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);





        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipe);

        view=(WebView) this.findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setDisplayZoomControls(false);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl(url);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        view.reload();
                        mySwipeRefreshLayout.setRefreshing(false);
                        }

                }
        );

    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        view.loadUrl(url);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    private class WebViewClientImpl extends WebViewClient {
        public WebViewClientImpl(MainActivity mainActivity) {

        }
    }
}

