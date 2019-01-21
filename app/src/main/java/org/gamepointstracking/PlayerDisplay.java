package org.gamepointstracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.gamepointstracking.data.Players;

import java.util.ArrayList;

public class PlayerDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_display);
        ListView playerList = findViewById(R.id.playerListView);
        Intent intent = getIntent();
        String [] stringArray = intent.getStringArrayExtra("Players");

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(PlayerDisplay.this, 0, stringArray);
        //playerList.setAdapter(adapter);

    }
}
