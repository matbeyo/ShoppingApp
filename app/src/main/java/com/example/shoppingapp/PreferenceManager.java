package com.example.shoppingapp;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String PREFERENCES_FILE = "com.yourapp.preferences";
    private SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
    }

    public void setUser(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(username + "_password", password);
        editor.apply();
    }

    public boolean validateUser(String username, String password) {

        String regPassword = sharedPreferences.getString(username + "_password", "");
        return password.equals(regPassword);
    }

    public boolean isUserExist(String username) {

        return sharedPreferences.contains(username + "_password");
    }
}
