package com.tonikorin.cordova.plugin.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tonikorin.cordova.plugin.autostart.AppStarter;
import android.content.Intent;
import android.os.Handler;
 
public class BootCompletedReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, final Intent intent) {
		// Wait for hardware to init
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run()
			{
				AppStarter appStarter = new AppStarter();
				appStarter.run(context, intent, PackageManager.COMPONENT_ENABLED_STATE_ENABLED);
			}
		}, 10 * 1000);
	}
}