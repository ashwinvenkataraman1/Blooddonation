package com.android;

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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCandidate extends Activity{
	
	  HttpResponse response;
		HttpClient httpclient;
		String location = null;
		String responseText;
		
		
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.register);
	        final Button addnew = (Button)findViewById(R.id.submit);
	        final EditText lbl_uname = (EditText)findViewById(R.id.txt_uname);
	        final EditText lbl_pass = (EditText)findViewById(R.id.txt_pass);
	        final EditText lbl_dob = (EditText)findViewById(R.id.txt_dob);
	        final EditText lbl_age = (EditText)findViewById(R.id.txt_age);
	        final EditText lbl_sex = (EditText)findViewById(R.id.txt_sex);
	        final EditText lbl_bloodgroup = (EditText)findViewById(R.id.txt_bloodgroup);
	        final EditText lbl_mobileNo = (EditText)findViewById(R.id.txt_mno);
	        final EditText lbl_lastdate = (EditText)findViewById(R.id.txt_last_date);
	         final EditText lbl_lat = (EditText)findViewById(R.id.txt_location);
	         lbl_lat.setVisibility(View.INVISIBLE);
	     
	        try{
	        	location = getGPS("GPS");
	        	if(location !=null){
	        		lbl_lat.setText(location);
	        		
	        	}else{
	        		lbl_lat.setText("");
	        		Toast.makeText(getApplicationContext(), "No GPS Value",Toast.LENGTH_SHORT).show();
	        	}
	        	
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        	System.out.println(ex);
	        }
	      	        
	                     
	        addnew.setOnClickListener(new OnClickListener(){
	        	public void onClick(View v){
	        		String uname = lbl_uname.getText().toString();
	        		String pass = lbl_pass.getText().toString();
	        		String age = lbl_age.getText().toString();
	        		String sex = lbl_sex.getText().toString();
	        		String dob = lbl_dob.getText().toString();
	        		String bloodgroup = lbl_bloodgroup.getText().toString();
	        		
	        		String mobileNo = lbl_mobileNo.getText().toString();
	        		String lastdate = lbl_lastdate.getText().toString();
	        		
	        		String lat = lbl_lat.getText().toString();
	        
	        		try{
	        			 String data = "ADD$"+uname+"$"+pass+"$"+dob+"$"+age+"$"+sex+"$"+bloodgroup+"$"+mobileNo+"$"+lastdate+"$"+lat;
	        		String result = getConnection(data);
	        		if(result.trim().intern() == "ADDED"){
	        			Intent intent = new Intent(AddCandidate.this,SignIn.class);
	        			startActivity(intent);
	        		}else{
	        			Toast.makeText(getApplicationContext(), "Not added...",10).show();
	        		}
	        			
	        		}catch(Exception ex){
	        			ex.printStackTrace();
	        			System.out.println(ex);
	        			
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
		
		
		public String getGPS(String message){
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
  
	/* public  String executeHttpPost(String uname,String pass,String dob,String age,String sex,String bloodgroup,String lat) throws Exception {
		   	//This method  for HttpConnection  
			    try {
			    	HttpClient client = new DefaultHttpClient();

			        HttpPost request = new HttpPost("http://"+ServerIPAddress.getIpaddress()+":7000/");

			        List<NameValuePair> value=new ArrayList<NameValuePair>();
			        String data = "ADD$"+uname+"$"+pass+"$"+dob+"$"+age+"$"+sex+"$"+bloodgroup+"$"+lat; 
			        value.add(new BasicNameValuePair("UNAME",data));
			       /* value.add(new BasicNameValuePair("PASS",pass));
			        value.add(new BasicNameValuePair("DOB",dob));
			        value.add(new BasicNameValuePair("AGE",age));
			        value.add(new BasicNameValuePair("SEX",sex));
			        value.add(new BasicNameValuePair("BLOODGROUP",bloodgroup));
			        value.add(new BasicNameValuePair("LAT",lat));*/
			      
			   /*     UrlEncodedFormEntity entity=new UrlEncodedFormEntity(value);
			        request.setEntity(entity);
			        response = client.execute(request);
			        HttpEntity entity1 = response.getEntity();
			        responseText = EntityUtils.toString(entity1);
			       System.out.println("after sending :"+request.toString());
			       String myList = responseText.trim();
			      // ArrayList<String> myList = new ArrayList<String>(Arrays.asList(responseText.split(",")));
		         //  Toast.makeText(getApplicationContext(), "Feature List..."+myList.toString(), 10).show();
			       Log.v("Error", myList);
		           return myList;
			     }catch(Exception e){System.out.println("Exp="+e);}
		    	  return null;
			}*/

}
