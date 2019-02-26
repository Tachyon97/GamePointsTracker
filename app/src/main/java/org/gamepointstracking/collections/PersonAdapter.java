package org.gamepointstracking;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Players> {
    private Context context;
    private ArrayList<Players> values;
    private LayoutInflater inflater;

    public PersonAdapter(Context context, ArrayList<Players> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View items = inflater.inflate(R.layout.adapter_player, parent, false);
        ImageView imageView = items.findViewById(R.id.userImage);
        TextView username = items.findViewById(R.id.username);
        TextView score = items.findViewById(R.id.score);
        Button plusButton = items.findViewById(R.id.plusButton);
        Button minusButton = items.findViewById(R.id.minusButton);
        Button custom = items.findViewById(R.id.customButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.get(position).incrementScore();
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.get(position).decrementScore();
            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //builder.setAdapter();
            }
        });
        username.setText(values.get(position).getUser());
        score.setText(context.getResources().getString(R.string.score) + ": " + values.get(position).getScore());
        imageView.setImageResource(R.drawable.user);
        return items;
    }

}
