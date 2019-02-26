package org.gamepointstracking.collections.activities;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import org.gamepointstracking.R;

public class ProfileCustomization extends Dialog implements android.view.View.OnClickListener {


    public ProfileCustomization(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_icon);
    }

    @Override
    public void onClick(View v) {
        Button b = findViewById(R.id.lockSettings);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
