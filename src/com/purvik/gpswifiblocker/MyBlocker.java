package com.purvik.gpswifiblocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class MyBlocker extends BroadcastReceiver {
	WifiManager wifi;
	LocationManager location;
	GpsStatus gpsStat;
	
	

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if((intent.getAction()).equals("android.intent.action.BOOT_COMPLETED"))
		{
			wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
			if (wifi.isWifiEnabled()) {
				wifi.setWifiEnabled(false);
				Toast.makeText(context, "Wifi Switched Off", Toast.LENGTH_LONG).show();
			} else {
				wifi.setWifiEnabled(true);
				Toast.makeText(context, "Wifi Switched On", Toast.LENGTH_LONG).show();
			}
		}
		/*
		else if((intent.getAction()).equals("com.purvik.GPS_STATE"))
		{
			gpsStat = location.getGpsStatus(null);//location.isProviderEnabled(LocationManager.GPS_PROVIDER);
			if (gpsStat) {
			
				
			} else {

			}
			
		}
		*/
	}
}
