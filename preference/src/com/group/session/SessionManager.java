package com.group.session;

import java.util.HashMap;

import com.example.session.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
	// Shared Preferences
		SharedPreferences pref;
		Editor editor;
		Context _context;
		 Constant myconstants;
		
	
		public SessionManager(Context context){
			this._context = context;
			pref = _context.getSharedPreferences("myconstants.KEY_PREFS_NAME", 0);
			editor = pref.edit();
		}
		
		/**
		 * Create login session
		 * */
		public void createLoginSession(String password, String email){
			editor.putBoolean(myconstants.IS_LOGIN, true);
			editor.putString(myconstants.KEY_EMAIL, email);
			editor.putString(myconstants.KEY_PASSWORD, password);
		
			editor.commit();
		}	
		public void checkLogin(){
			if(!this.isLoggedIn()){
				Intent i = new Intent(_context, LoginActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				_context.startActivity(i);
			}
			
		}
		
		public HashMap<String, String> getUserDetails(){
			HashMap<String, String> user = new HashMap<String, String>();
			user.put(myconstants.KEY_HM_EMAIL, pref.getString(myconstants.KEY_EMAIL, null));
			user.put(myconstants.KEY_HM_PASSWORD, pref.getString(myconstants.KEY_PASSWORD, null));
			
			return user;
		}
		public void logoutUser(){
			editor.clear();
			editor.commit();
			Intent i = new Intent(_context, LoginActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			_context.startActivity(i);
		}
		
		public boolean isLoggedIn(){
			return pref.getBoolean(myconstants.IS_LOGIN, false);
		}

}
