package com.example.multitask;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Fifth extends AppCompatActivity {
    ToggleButton t1,t2,t3;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        t1=(ToggleButton) findViewById(R.id.toggleButton);
        t2=(ToggleButton) findViewById(R.id.toggleButton2);
        t3=(ToggleButton) findViewById(R.id.toggleButton3);
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if(bluetoothAdapter.isEnabled())
        {
            t1.setChecked(true);
        }
        else
        {
            t1.setChecked(false);
        }

        if (wifiManager.isWifiEnabled()) {
            t2.setChecked(true);
        } else {
            t2.setChecked(false);
        }
        t2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(Fifth.this, "Wifi Disabled", Toast.LENGTH_SHORT).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(Fifth.this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
   }
}

