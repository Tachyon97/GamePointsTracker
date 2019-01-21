package org.gamepointstracking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.gamepointstracking.data.PlayerDataManagement;
import org.gamepointstracking.data.Players;

public class MainActivity extends AppCompatActivity {

    EditText fieldInputOne, fieldInputTwo, fieldInputThree, fieldInputFour;
    PlayerDataManagement management = new PlayerDataManagement();

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
        log("There are currently: " + management.count.getCount() + " players registered");
        if(management.count.getCount() != 0)
            management.count.setCount(0);
    }

    private void PlayerManager() {
        if (fieldInputOne.getText().length() > 1) {
            management.players[0] = new Players(fieldInputOne.getText().toString());
            management.count.incrementCount();
            log(management.players[0].getUser() + " successfully loaded");
        }
        if (fieldInputTwo.getText().length() > 1) {
            management.players[1] = new Players(fieldInputTwo.getText().toString());
            management.count.incrementCount();
            log(management.players[1].getUser() + " successfully loaded");
        }
        if (fieldInputThree.getText().length() > 1) {
            management.players[2] = new Players(fieldInputThree.getText().toString());
            management.count.incrementCount();
            log(management.players[2].getUser() + " successfully loaded");
        }
        if (fieldInputFour.getText().length() > 1) {
            management.players[3] = new Players(fieldInputFour.getText().toString());
            management.count.incrementCount();
            log(management.players[3].getUser() + " successfully loaded");
        }
    }


    void log(String str) {
        System.out.println(str);
    }
}