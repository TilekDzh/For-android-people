package com.auca.services.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.util.Log;

public class ScheduleServiceImpl {
	
	static HttpResponse response = null;
	
	public ScheduleServiceImpl() {
		
	}
	
	public static void testThreadUnsafeMethods() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				JSONObject obj = getSchedulenInfo(1L);
			}
		});
		
		thread.start();
	}
	
	public static JSONObject getNotificationInfo(Long userId) {
    	try {
    	    HttpClient client = new DefaultHttpClient();
    	    String url = "http://auca.comli.com/userService.php?id=" + userId;
    	    HttpGet get = new HttpGet(url);
    	    HttpResponse responseGet = client.execute(get);  
    	    HttpEntity resEntityGet = responseGet.getEntity();
    	    String res = EntityUtils.toString(resEntityGet);
    	    return new JSONObject(res);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	public static JSONObject getSchedulenInfo(Long userId) {
		try {
	        HttpClient client = new DefaultHttpClient();  
	        String postURL = "http://auca.comli.com/functions.php";
	        HttpPost post = new HttpPost(postURL); 
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("method", "get_course_info"));
	            params.add(new BasicNameValuePair("id", userId.toString()));
	            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
	            post.setEntity(ent);
	            HttpResponse responsePOST = client.execute(post);  
	            HttpEntity resEntity = responsePOST.getEntity();  
	            String res = EntityUtils.toString(resEntity);
	            if (resEntity != null) {    
	                Log.i("RESPONSE ", res);
	            }
	    	    return new JSONObject(res);
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
