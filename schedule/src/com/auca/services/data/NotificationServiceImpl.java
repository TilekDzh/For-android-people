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
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class NotificationServiceImpl {
	
	static HttpResponse response = null;
	
	public NotificationServiceImpl() {
		
	}
	
	public static void getNotificationsForUser() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				JSONObject obj = getNotificationInfo(1L);
			}
		});
		
		thread.start();
	}
	
	private static JSONObject getNotificationInfo(Long userId) {
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
}
