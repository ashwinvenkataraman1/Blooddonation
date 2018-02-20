package com.android;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.StringTokenizer;

public class DonarDetails extends Activity{
	
	
	 HttpResponse response;
		HttpClient httpclient;
		String userMobile = null;
		String responseText;
	 public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.result);
	    TextView result = (TextView)findViewById(R.id.query);
	    String uname = ServerIPAddress.getUname();
	    String reply = getConnection("DETAILS$"+uname);
	    if(reply!=null && reply.startsWith("DETAILS")){
	    	StringTokenizer stringToken = new StringTokenizer(reply,",");
	    	stringToken.nextToken();
	    	while(stringToken.hasMoreTokens()){
	    	   result.append(stringToken.nextToken()+"\n");
	    	}
	    	
	    }else{
	    	Toast.makeText(getApplicationContext(), "No Details Available",Toast.LENGTH_LONG).show();
	    }
	    
	    
	 }
	 
	 
	 public String getConnection(String message){
		    try {
	    	httpclient = new DefaultHttpClient();
	    	HttpGet httpget = new HttpGet("http://"+ServerIPAddress.getIpaddress()+":7000/"+message);
	        response = httpclient.execute(httpget);
	        HttpEntity entity = response.getEntity();
	        responseText = EntityUtils.toString(entity);
	        Toast.makeText(getApplicationContext(), responseText, Toast.LENGTH_LONG).show();
	         return responseText.trim();  
	      }catch (Exception e){
	        Toast.makeText(this, "error"+e.toString(), Toast.LENGTH_LONG).show();
	        return e.toString();
	     }
	  }

}
