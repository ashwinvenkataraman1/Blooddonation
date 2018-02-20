package com.android;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UserMenu extends Activity {
    /** Called when the activity is first created. */
	 HttpResponse response;
	HttpClient httpclient;
	String userMobile = null;
	String responseText;
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.usermenu);
       final Button blooddonar = (Button)findViewById(R.id.btn_bd);
       final Button bloodrecipient = (Button)findViewById(R.id.btn_br);
       
       blooddonar.setOnClickListener(new OnClickListener(){
       	public void onClick(View v){
       		Intent intent = new Intent(UserMenu.this,DonarDetails.class);
       		startActivity(intent);
       	}
       });
       
       bloodrecipient.setOnClickListener(new OnClickListener(){
          	public void onClick(View v){
          		Intent intent = new Intent(UserMenu.this,SearchBloodGroup.class);
          		startActivity(intent);
          	}
          });
   }

}
