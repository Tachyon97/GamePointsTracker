package org.gamepointstracking.collections.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import org.gamepointstracking.R;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void setSwedish(View view) {
    }

    public void setEnglish(View view) {

    }

    public void resetSavedData(View view) {
    }
}
