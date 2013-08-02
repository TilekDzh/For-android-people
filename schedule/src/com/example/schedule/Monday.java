package com.example.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;



public class Monday extends ListActivity {
	final String SUB = "subject";
	final String TO = "to";
	final String DATE = "date";
	final String IMAGE = "imge";
	ListView lvSimple;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sche_list);

        
        String[] texts = { "sometext 1", "sometext 2", "sometext 3",
                "sometext 4", "sometext 5",};
        int img = R.drawable.ic_launcher; 
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                texts.length);
            Map<String, Object> m;
            for (int i = 0; i < texts.length; i++) {
              m = new HashMap<String, Object>();
              m.put(SUB, texts[i]);
              m.put(TO, texts[i]);
              m.put(IMAGE, img);
              m.put(DATE, texts[i]);
              data.add(m);
            }
            
            String[] from = { SUB, TO,DATE,
                    IMAGE };
            int[] to = { R.id.subject, R.id.to, R.id.date, R.id.img };
            SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.sche_list_item,
                    from, to);
            lvSimple = (ListView) findViewById(android.R.id.list);
            lvSimple.setAdapter(sAdapter);
            lvSimple.setOnItemClickListener(new OnItemClickListener() {
            	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
            			Intent murat = new Intent(getBaseContext(),Group.class);
            			startActivity(murat);
        		}
                
                
                
                
			});
	}
}


