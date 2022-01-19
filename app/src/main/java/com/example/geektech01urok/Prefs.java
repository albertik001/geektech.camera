package com.example.geektech01urok;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class Prefs {

    public final static String PHOTO_PROFIL = "photo_profil_key";
    public final static String USERNAME = "user_nama_key";
    public final static String MAIN = "intent_main";
    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    public void setImageProfil(Uri uri) {
        preferences.edit().putString(PHOTO_PROFIL, uri.toString()).apply();
    }

    public String getImageUser() {
        return preferences.getString(PHOTO_PROFIL, "");
    }

    public void setUserName(String username) {
        preferences.edit().putString(USERNAME, username).apply();
    }

    public String getUserName() {
        return preferences.getString(USERNAME, "null");
    }
    public void saveMainCreate(){
        preferences.edit().putBoolean(MAIN, true).apply();
    }
    public void saveMainCreate2(){
        preferences.edit().putBoolean(MAIN, false).apply();
    }
    public boolean isMainCreate(){
        return preferences.getBoolean(MAIN, false);
    }
}
