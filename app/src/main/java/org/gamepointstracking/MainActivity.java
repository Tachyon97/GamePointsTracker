package org.gamepointstracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.gamepointstracking.data.PlayerCount;
import org.gamepointstracking.data.Players;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText fieldInputOne, fieldInputTwo, fieldInputThree, fieldInputFour;
    public Players[] players = new Players[4];
    public PlayerCount count = new PlayerCount();
    ArrayList<String> loadout = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldInputOne = findViewById(R.id.usernameOne);
        fieldInputTwo = findViewById(R.id.usernameTwo);
        fieldInputThree = findViewById(R.id.usernameThree);
        fieldInputFour = findViewById(R.id.usernameFour);


    }

    public void onClick(View view) {
        PlayerManager();
        try {
            Intent intent = new Intent(this, PlayerDisplay.class);
            intent.putExtra("Players", loadout);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    private void PlayerManager() {
        if (fieldInputOne.getText().length() > 1) {
            players[0] = new Players(fieldInputOne.getText().toString());
            count.incrementCount();
            loadout.add(players[0].toString());
            log(players[0].getUser() + " successfully loaded");
        }
        if (fieldInputTwo.getText().length() > 1) {
            players[1] = new Players(fieldInputTwo.getText().toString());
            count.incrementCount();
            loadout.add(players[1].toString());
            log(players[1].getUser() + " successfully loaded");

        }
        if (fieldInputThree.getText().length() > 1) {
            players[2] = new Players(fieldInputThree.getText().toString());
            count.incrementCount();
            loadout.add(players[2].toString());
            log(players[2].getUser() + " successfully loaded");
        }
        if (fieldInputFour.getText().length() > 1) {
            players[3] = new Players(fieldInputFour.getText().toString());
            count.incrementCount();
            loadout.add(players[3].toString());
            log(players[3].getUser() + " successfully loaded");
        }
    }


    void log(String str) {
        System.out.println(str);
    }
}