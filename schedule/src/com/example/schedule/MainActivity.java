package com.example.schedule;



import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import com.auca.services.data.NotificationServiceImpl;

public class MainActivity extends TabActivity {

	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Resources res = getResources();
        Intent Mon = new Intent(this,Monday.class);
        
        Intent Thu = new Intent(this,Thursday.class);
        TabHost mTabHst = getTabHost();
        mTabHst.addTab(mTabHst.newTabSpec("Monday")
                .setIndicator("Monday")
                .setContent(Mon));
        
        mTabHst.addTab(mTabHst.newTabSpec("Thursday")
                .setIndicator("Thursday")
                .setContent(Thu));
        mTabHst.setCurrentTab(0);
        
        new NotificationServiceImpl().getNotificationsForUser(); 
	}


}
