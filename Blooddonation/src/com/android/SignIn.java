package com.android;

import java.util.StringTokenizer;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class SignIn extends Activity {
    /** Called when the activity is first created. */
	 HttpResponse response;
	HttpClient httpclient;
	String userMobile = null;
	String responseText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
      final Button Go = (Button)findViewById(R.id.submit);
      final EditText uname = (EditText)findViewById(R.id.txt_uname);
      final EditText pass = (EditText)findViewById(R.id.txt_pass);
     
      Go.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String userName = uname.getText().toString();
        		String password = pass.getText().toString();
        		
        		
        		String reply = getConnection("LI$"+userName+"$"+password);
        		if(reply !=null && reply.intern() == "VALID"){
        			ServerIPAddress.setUname(userName);
        			Intent intent = new Intent(SignIn.this,UserMenu.class);
        			startActivity(intent);
        		}else{
        			Toast.makeText(getApplicationContext(), "Invalid username and password",10).show(); 
        		}
        	}
        });
    }
    
    
	public String getConnection(String message){
	    try {
    	httpclient = new DefaultHttpClient();
    	HttpGet httpget = new HttpGet("http://"+ServerIPAddress.getIpaddress()+":7000/"+message);
        response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        responseText = EntityUtils.toString(entity);
         return responseText.trim();  
      }catch (Exception e){
        Toast.makeText(this, "error"+e.toString(), Toast.LENGTH_LONG).show();
        return e.toString();
     }
  }
    

	
 }