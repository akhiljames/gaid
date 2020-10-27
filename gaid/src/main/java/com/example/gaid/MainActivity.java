package com.example.gaid;

import android.os.RemoteException;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.akhiljames.gaid.GaidUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String tag = "GAID-example";

        GaidUtil.getAdInfo(getApplicationContext(), new GaidUtil.GaidListener() {
            @Override
            public void onSuccess(GaidUtil.AdIdInfo info) {
                String adId = info.getAdId();
                boolean adTrackingEnabled = info.isAdTrackingEnabled();
                Log.v(tag, "Gaid: "+adId+" & isAdTrackingEnabled: "+adTrackingEnabled);
            }

            @Override
            public void onException(Exception exception) {
                Log.e(tag, exception.getMessage());
                exception.printStackTrace();
            }
        });
    }
}
