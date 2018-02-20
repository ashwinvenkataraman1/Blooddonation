package com.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BloodDonation extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText text_ip = (EditText)findViewById(R.id.txt_server_ip);
        final Button adminButton = (Button)findViewById(R.id.bt_admin);
        final Button  userButton= (Button)findViewById(R.id.bt_user);
        final Button closeButton = (Button)findViewById(R.id.bt_close);
        adminButton.setOnClickListener(new OnClickListener(){
           	public void onClick(View v){
           		ServerIPAddress.setIpaddress(text_ip.getText().toString());
           		Intent intent = new Intent(BloodDonation.this,AddCandidate.class);
        		startActivity(intent);
    		}
    });
        userButton.setOnClickListener(new OnClickListener(){
           	public void onClick(View v){
           	ServerIPAddress.setIpaddress(text_ip.getText().toString());
        		Intent intent = new Intent(BloodDonation.this,SignIn.class);
    		     startActivity(intent);
           		//Toast.makeText(getApplicationContext(), "User section",10).show();
    		}
    });
        closeButton.setOnClickListener(new OnClickListener(){
           	public void onClick(View v){
        		finish();
    		}
    });
        
    }
}