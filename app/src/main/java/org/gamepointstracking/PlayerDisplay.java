package org.gamepointstracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class PlayerDisplay extends AppCompatActivity {

    Players[] players = new Players[4];
    TextView pOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_display);
        pOne = findViewById(R.id.playerOne);
        //Bundle extras = getIntent().getExtras();
       Intent intent = getIntent();

        if(intent != null) {

           Log.e("UserOne", intent.getStringExtra("userOne"));
            /* Log.e("UserTwo", extras.getString("UserTwo"));
            Log.e("userThree", extras.getString("userThree"));
            Log.e("userFour", extras.getString("userFour"));
            players[0].setUser(extras.getString("userOne"));
            pOne.setText(players[0].getUser());
            players[1].setUser(extras.getString("userTwo"));
            players[2].setUser(extras.getString("userThree"));
            players[3].setUser(extras.getString("userFour")); */
        }

    }
}
