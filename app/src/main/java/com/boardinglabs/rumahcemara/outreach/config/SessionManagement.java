package com.boardinglabs.rumahcemara.outreach.config;


import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.boardinglabs.rumahcemara.outreach.LoginActivity;
import com.boardinglabs.rumahcemara.outreach.MainActivity;

public class SessionManagement {

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "RumahCemaraPref";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_NAME = "name";
    public static final String KEY_FULL_NAME = "fullname";
    public static final String KEY_ID = "id";
    public static final String KEY_PHONE = "phonenumber";
    public static final String KEY_IMG_URL = "picture";
    public static final String KEY_IMG_TOKEN = "token";
    public static final String KEY_GROUP_ID = "group_id";
    public static final String KEY_LANGUAGE_ID = "language_id";
    public static final String NOTIFICATION = "notification";
    public static final String STATUS_ONLINE = "status_online";

    // Constructor
    public SessionManagement(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public void createLoginSession(String name, String fullname, String id, String phonenumber, String picture, String token, String group_id){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_FULL_NAME, fullname);
        editor.putString(KEY_ID, id);
        editor.putString(KEY_PHONE, phonenumber);
        editor.putString(KEY_IMG_URL, picture);
        editor.putString(KEY_IMG_TOKEN, token);
        editor.putString(KEY_GROUP_ID, group_id);
        // commit changes
        editor.commit();
    }

    public void setLanguage(int language) {
        editor.putInt(KEY_LANGUAGE_ID, language);
        editor.commit();
    }

    public int getLanguage() {
        int languageId;
        languageId = pref.getInt(KEY_LANGUAGE_ID, 0);
        return languageId;
    }

    public void setNotification(int notification) {
        editor.putInt(NOTIFICATION, notification);
        editor.commit();
    }

    public int getNotification() {
        int notification;
        notification = pref.getInt(NOTIFICATION, 0);
        return notification;
    }

    public void setStatusOnline(int statusOnline) {
        editor.putInt(STATUS_ONLINE, statusOnline);
        editor.commit();
    }

    public int getStatusOnline() {
        int statusOnline;
        statusOnline = pref.getInt(STATUS_ONLINE, 0);
        return statusOnline;
    }

    public void checkLogin(){
        // Check login status
        if(this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_FULL_NAME, pref.getString(KEY_FULL_NAME, null));
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_PHONE, pref.getString(KEY_PHONE, null));
        user.put(KEY_IMG_URL, pref.getString(KEY_IMG_URL, null));
        user.put(KEY_IMG_TOKEN, pref.getString(KEY_IMG_TOKEN, null));
        user.put(KEY_GROUP_ID, pref.getString(KEY_GROUP_ID, null));
        // return user
        return user;
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
