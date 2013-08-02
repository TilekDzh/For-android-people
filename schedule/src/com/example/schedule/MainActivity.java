package com.example.schedule;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.Application;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

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
        
	}


}
