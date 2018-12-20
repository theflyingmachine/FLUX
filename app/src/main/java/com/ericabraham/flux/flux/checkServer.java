package com.ericabraham.flux.flux;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by EK055891 on 19-Dec-18.
 */
class checkServer extends AsyncTask<String, Void, Integer> {

    Splash splash = new Splash();

    Context context;
    private static final String TAG = "checkServer";

    public checkServer(Context context) {
        this.context=context;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        int temp=0;
        try {
            URL url = new URL("http://corpindat01.northamerica.cerner.net/SO_FLE/status");
//            URL url = new URL("http://corpindat01.northamerica.cerner.net/SO_FLE/status");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            Log.d(TAG, "getResponse: "+conn.getResponseCode());
            conn.setConnectTimeout(1000*10);
            temp=conn.getResponseCode();

        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer s) {
        super.onPostExecute(s);
        int temp=0;
        if (s==200){
//                splash.gotoMainActivity();
            Intent i = new Intent(context, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
//
            // close this activity
            splash.finish();
        }else{
            Intent i = new Intent(context, Error.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
//
            // close this activity
            splash.finish();
        }
    }
}