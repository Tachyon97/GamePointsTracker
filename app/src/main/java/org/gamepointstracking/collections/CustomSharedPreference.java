package org.gamepointstracking.collections;

import android.content.Context;
import android.content.SharedPreferences;

public class CustomSharedPreference {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;
    int PRIVATE_MODE = 0;

    private static String PREF_NAME = "pref";
    private static String USERS = "users";

    public CustomSharedPreference(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void saveUsers(String userList) {
        editor.putString(USERS, userList);
        editor.commit();
    }
    public String getUsers() {
        return preferences.getString(USERS, "");
    }

}
