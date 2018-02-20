package com.android;

import java.util.StringTokenizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultForm extends Activity{
	
	 public void onCreate(Bundle savedInstanceState){
			
   	 super.onCreate(savedInstanceState);
   	 Bundle bundle = this.getIntent().getExtras();
 	      String message = bundle.getString("DATA");
 	      StringTokenizer stringToken = new StringTokenizer(message,",");
 	      
  	     setContentView(R.layout.result);
  	     
  	   TextView result = (TextView)findViewById(R.id.query);
  	   result.append("RESULT\n");
  	 result.append("\n");
  	   stringToken.nextToken();
  	     while(stringToken.hasMoreTokens()){
  	    	//result.append("Person Name :"+(String)stringToken.nextToken()+"\n");
  	    	result.append("Phone No :"+(String)stringToken.nextToken()+"\n");
  	     }
 	      
 	      
  	      
  	   //Toast.makeText(getApplicationContext(), message,20).show();
  	  // final TextView filename = (TextView)findViewById(R.id.query);
  	  // filename.setText(message);
  	   
	 }
   	 

}
