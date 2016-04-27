package com.tonikorin.cordova.plugin.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tonikorin.cordova.plugin.autostart.AppStarter;
import android.os.Handler;

 
public class PackageReplacedReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(final Context context, final Intent intent) {
		// Wait for hardware to init
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run()
			{
				AppStarter appStarter = new AppStarter();
				appStarter.run(context, intent, AppStarter.BYPASS_USERPRESENT_MODIFICATION );
			}
		}, 10 * 1000);
    }
}
