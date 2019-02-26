package org.gamepointstracking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.gamepointstracking.collections.CustomSharedPreference;
import org.gamepointstracking.collections.PersonAdapter;
import org.gamepointstracking.collections.Players;
import org.gamepointstracking.collections.activities.Settings;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Players> users = new ArrayList<>();
    ListView list;
    private Gson gson;
    private CustomSharedPreference preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = findViewById(R.id.userList);
        gson = new Gson();
        preference = new CustomSharedPreference(this);
        retrieveUsers();

        setContentView(R.layout.activity_main);
    }

    public void addUserButton(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final PersonAdapter adapter = new PersonAdapter(this, users);
        list = findViewById(R.id.userList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                users.get(position);
            }
        });
        builder.setTitle(getResources().getString(R.string.addDescription));
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton(getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                users.add(new Players(input.getText().toString()));
                save(users);
            }
        });
        builder.setNegativeButton(getResources().getText(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        list.setAdapter(adapter);
        builder.show();

    }


    public void removeUserButton(View view) {
        list = findViewById(R.id.userList);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.removeDescription));
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton(getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (users.contains(input.getText().toString())) {
                    if (getIndex(input.getText().toString()) != -1) {
                        users.remove(getIndex(input.getText().toString()));
                    }
                }
            }
        });
        builder.show();
    }

    private int getIndex(String user) {
        for (Players p : users) {
            if (p.getUser().equals(user))
                return users.indexOf(p);
        }
        return -1;
    }

    private void save(ArrayList<Players> players) {
        String jsonUsers = gson.toJson(players);
        preference.saveUsers(jsonUsers);
    }

    private void retrieveUsers() {
        String jsonUsers = preference.getUsers();
        Type type = new TypeToken<List<Players>>() {
        }.getType();
        users = gson.fromJson(jsonUsers, type);
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}