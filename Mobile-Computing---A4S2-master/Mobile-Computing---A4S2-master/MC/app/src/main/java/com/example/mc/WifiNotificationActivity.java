package com.example.mc;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WifiNotificationActivity extends AppCompatActivity
{
    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        appContext = this.getApplicationContext();
        setContentView(R.layout.activity_wifi_notification);
        checkForWifi();
        Button button = findViewById(R.id.checkButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkForWifi();
            }
        });
    }



    public void checkForWifi()
    {
        ConnectivityManager cm = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting()&&
                activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;

        TextView textView = findViewById(R.id.wifiNotificationText);
        if(isConnected)
        {
            textView.setTextColor(Color.GREEN);
            textView.setText("Your wifi is currently turned on and you are connected to a network.");
        }
        else
        {
            textView.setText("Your wifi is currently turned off.");
            textView.setTextColor(Color.RED);
        }
    }
}
