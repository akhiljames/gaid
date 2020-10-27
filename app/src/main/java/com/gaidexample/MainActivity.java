package com.gaidexample;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.github.akhiljames.gaid.GaidUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GAID-Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            GaidUtil.AdIdInfo gaid = GaidUtil.getGoogleAdIdInfo(getApplicationContext());
            Log.v(TAG, gaid.getAdId());
        } catch (RemoteException e) {
            Log.v(TAG, e.toString());
            e.printStackTrace();
        }

    }
}