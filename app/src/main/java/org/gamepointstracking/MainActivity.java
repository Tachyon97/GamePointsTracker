package org.gamepointstracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText fieldInputOne, fieldInputTwo, fieldInputThree, fieldInputFour;
    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldInputOne = findViewById(R.id.usernameOne);
        fieldInputTwo = findViewById(R.id.usernameTwo);
        fieldInputThree = findViewById(R.id.usernameThree);
        fieldInputFour = findViewById(R.id.usernameFour);
        Button b = findViewById(R.id.button);

       // intent= new Intent(this, PlayerDisplay.class);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                Intent intent = new Intent(a.getContext(), PlayerDisplay.class);
               // Log.e("User", fieldInputOne.getText().toString());
                intent.putExtra(fieldInputOne.getText().toString(), "userOne");
                intent.putExtra(fieldInputTwo.getText().toString(), "userTwo");
                intent.putExtra(fieldInputThree.getText().toString(), "userThree");
                intent.putExtra(fieldInputFour.getText().toString(), "userFour");
                startActivity(intent);
            }
        });

    }
}