package com.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity{
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu);
	        final Button addnewLaw = (Button)findViewById(R.id.register);
	              
	        addnewLaw.setOnClickListener(new OnClickListener(){
	        	public void onClick(View v){
	        		Intent intent = new Intent(Menu.this,AddCandidate.class);
	        		startActivity(intent);
	        	}
	        });
	    }
     
	 }
