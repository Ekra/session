package com.group.session;

import android.R.string;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class userfunction {
	
	Constant myconstants;
    SharedPreferences pref;
    Editor editor;
    Context _context;
    string email; string password;
    string username;

    
    public userfunction(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(myconstants.KEY_PREFS_NAME, 0);
        editor = pref.edit();
       
    }
	

}
