package com.example.session;

import com.group.session.SessionManager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity implements OnClickListener {

	 EditText txtEmail, txtPassword;
	    Button btnLogin;
	    SessionManager session;
	    
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
         
        // Session Manager
        session = new SessionManager(getApplicationContext());               
         
        // Email, Password input text
        txtEmail = (EditText) findViewById(R.id.txtemail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
         
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        }


	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	case R.id.btnLogin:
		// Get username, password from EditText
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        if(txtEmail.getText().toString().equals("") &&txtPassword .getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else if (txtEmail.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter the email", Toast.LENGTH_SHORT).show();
        }
        else if (txtPassword.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter the password", Toast.LENGTH_SHORT).show();
        }
    
        else if (!txtEmail.getText().toString().equals(txtEmail)) {
            Toast.makeText(getApplicationContext(), "Please enter the correct email", Toast.LENGTH_SHORT).show();
        }
        else if (!txtPassword.getText().toString().equals(txtPassword)) {
            Toast.makeText(getApplicationContext(), "Please enter the correct password", Toast.LENGTH_SHORT).show();
        }
       
        else if(txtEmail.getText().toString().equals("") && txtPassword.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        break;

	default:
		break;
	}
		
	}
}
