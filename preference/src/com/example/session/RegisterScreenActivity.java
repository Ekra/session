package com.example.session;

import com.group.session.Constant;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterScreenActivity extends ActionBarActivity implements OnClickListener {
	//declare
	EditText etemail,etpassword,etusername;
	Button btnsubmit;
  
   Constant myconstants;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		//initilization
		etemail = (EditText) findViewById(R.id.etemail);
		etpassword = (EditText) findViewById(R.id.etpassword);
		etusername= (EditText) findViewById(R.id.etusername);
		btnsubmit= (Button) findViewById(R.id.btnsubmit);
		btnsubmit.setOnClickListener(this);
		
		myconstants = new Constant();
		
		
	}


	@Override
	public void onClick(View v) {
		
		SharedPreferences pref = getApplicationContext().getSharedPreferences("myconstants.KEY_PREFS_NAME", 0); // 0 - for private mode
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("username",etusername.getText().toString());
		editor.putString("password",etpassword.getText().toString());
		editor.putString("email",etemail.getText().toString());
		
		editor.commit();
		
		Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
		startActivity(intent);
		
	}

	}
