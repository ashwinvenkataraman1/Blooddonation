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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchBloodGroup  extends Activity {
    /** Called when the activity is first created. */
	 HttpResponse response;
	HttpClient httpclient;
	String userMobile = null;
	String responseText;
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.search);
       final Button Go = (Button)findViewById(R.id.submit);
       final EditText userSearch = (EditText)findViewById(R.id.txt_search);
     //  final EditText IP = (EditText)findViewById(R.id.txt_ip);
       Go.setOnClickListener(new OnClickListener(){
       	public void onClick(View v){
       		try{
       		String searchText = userSearch.getText().toString();
       		//ServerIPAddress.setIpaddress(IP.getText().toString().trim());
       		//Toast.makeText(getApplicationContext(), searchText, Toast.LENGTH_LONG).show();
       		
       		String result = getConnection("SEARCH$"+searchText.trim());
       		if(result != null){
       			//Intent intent = new Intent(SearchBloodGroup.this,Menu.class);
       			//startActivity(intent);
       			
       			Intent intent = new Intent(SearchBloodGroup.this,ResultForm.class);
			  	 Bundle bundle = new Bundle();
   		          bundle.putString("DATA",result);
   		          intent.putExtras(bundle);
			  	  startActivity(intent);
			  	
       			//Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
       		}else{
       			Toast.makeText(getApplicationContext(), "No Data Found",10).show(); 
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
        Toast.makeText(getApplicationContext(), responseText, Toast.LENGTH_LONG).show();
         return responseText.trim();  
      }catch (Exception e){
        Toast.makeText(this, "error"+e.toString(), Toast.LENGTH_LONG).show();
        return e.toString();
     }
  }
   

}
