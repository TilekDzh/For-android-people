package com.example.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Group extends Activity {
	
	final String NAME = "name";
	final String PHOTO = "photo";
	ListView grouplist;
	final String YEAR="senior";
	final String DEP="SFW";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);
        final TextView teachText = (TextView) findViewById(R.id.teach);
        teachText.setText("Some Text");
        final TextView roomText = (TextView) findViewById(R.id.room);
        roomText.setText("Some Text");
        final TextView timeText = (TextView) findViewById(R.id.time);
        timeText.setText("Some Text");
       
        
        String[] texts = { "somename 1", "somename 2", "somename 3",
                "somename 4", "somename 5","somename 5","somename 5","somename 5","somename 5"
                ,"somename 5","somename 5","somename 5"}; 
        int photo = R.drawable.ic_launcher; 
        ArrayList<Map<String, Object>> groupdata = new ArrayList<Map<String, Object>>(
                texts.length);
            Map<String, Object> ma;
            for (int i = 0; i < texts.length; i++) {
              ma = new HashMap<String, Object>();
              ma.put(NAME, texts[i]);
              ma.put(PHOTO, photo);
              ma.put(DEP, texts[i]);
              ma.put(YEAR, texts[i]);
              groupdata.add(ma);
            }
            String[] fromgroup = { NAME,PHOTO,DEP,YEAR };
            int[] togroup = { R.id.namegroup, R.id.phot,R.id.dep,R.id.year};
            SimpleAdapter mydapter = new SimpleAdapter(this, groupdata, R.layout.group_item,
                    fromgroup, togroup);
            grouplist = (ListView) findViewById(R.id.listgroup);
            grouplist.setAdapter(mydapter);
        
        
	}
}
