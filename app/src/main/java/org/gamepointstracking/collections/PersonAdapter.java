package org.gamepointstracking.collections;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.gamepointstracking.R;
import org.gamepointstracking.collections.activities.ProfileCustomization;

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
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        final View items = inflater.inflate(R.layout.adapter_player, parent, false);
        final ImageView imageView = items.findViewById(R.id.userImage);
        final ImageView background = items.findViewById(R.id.userBackground);
        TextView username = items.findViewById(R.id.username);
        TextView score = items.findViewById(R.id.score);
        Button plusButton = items.findViewById(R.id.plusButton);
        Button minusButton = items.findViewById(R.id.minusButton);
        final Button custom = items.findViewById(R.id.customButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.get(position).incrementScore();
                notifyDataSetChanged();


            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.get(position).decrementScore();
                notifyDataSetChanged();

            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProfileCustomization dialog = new ProfileCustomization(context);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
                final ImageView firstBackground = dialog.findViewById(R.id.firstImage);
                final ImageView secondBackground = dialog.findViewById(R.id.secondImage);
                final ImageView thirdBackground = dialog.findViewById(R.id.thirdImage);
                final ImageView fourthBackground = dialog.findViewById(R.id.fourthImage);
                final ImageView firstUser = dialog.findViewById(R.id.fifthImage);
                final ImageView secondUser = dialog.findViewById(R.id.sixthImage);
                final ImageView thirdUser = dialog.findViewById(R.id.seventhImage);
                final ImageView fourthUser = dialog.findViewById(R.id.eightImage);
                final ImageView displayBackground = dialog.findViewById(R.id.displayBackground);
                final ImageView displayImage = dialog.findViewById(R.id.displayImage);
                final Button dismiss = dialog.findViewById(R.id.lockSettings);
                final Button changeUser = dialog.findViewById(R.id.changeUser);
                changeUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Set username");
                        final EditText input = new EditText(context);
                        input.setInputType(InputType.TYPE_CLASS_TEXT);
                        builder.setView(input);
                        builder.setPositiveButton(context.getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                values.get(position).setUser(input.getText().toString());
                            }
                        });
                        builder.setNegativeButton(context.getResources().getText(R.string.cancel), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    }
                });
                final Button setPpoints = dialog.findViewById(R.id.setPoints);
                setPpoints.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle(context.getResources().getText(R.string.setPoints));
                        final EditText input = new EditText(context);
                        input.setInputType(InputType.TYPE_CLASS_TEXT);
                        builder.setView(input);
                        builder.setPositiveButton(context.getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                values.get(position).setPoints(Integer.parseInt(input.getText().toString()));
                            }
                        });
                        builder.setNegativeButton(context.getResources().getText(R.string.cancel), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    }
                });
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        notifyDataSetChanged();
                    }
                });
                firstBackground.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayBackground.setImageResource(R.color.coldBlue);
                        imageView.setImageResource(R.color.coldBlue);
                        notifyDataSetChanged();
                    }
                });
                secondBackground.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayBackground.setImageResource(R.color.colorAccent);
                        imageView.setImageResource(R.color.colorAccent);
                        notifyDataSetChanged();
                    }
                });
                thirdBackground.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayBackground.setImageResource(R.color.colorPrimaryDark);
                        imageView.setImageResource(R.color.colorPrimaryDark);
                        notifyDataSetChanged();

                    }
                });
                fourthBackground.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayBackground.setImageResource(R.color.warmBlue);
                        imageView.setImageResource(R.color.warmBlue);
                        notifyDataSetChanged();
                    }
                });
                firstUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayImage.setImageResource(R.drawable.user);
                        background.setImageResource(R.drawable.user);
                        notifyDataSetChanged();
                    }
                });
            secondUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayImage.setImageResource(R.drawable.soccer_user);
                    background.setImageResource(R.drawable.soccer_user);
                    notifyDataSetChanged();
                }
            });
            thirdUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayImage.setImageResource(R.drawable.user_veganshoes);
                    background.setImageResource(R.drawable.user_veganshoes);
                    notifyDataSetChanged();
                }
            });
            fourthUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayImage.setImageResource(R.drawable.userguard);
                    background.setImageResource(R.drawable.userguard);
                    notifyDataSetChanged();
                }
            });
            }


        });
        username.setText(values.get(position).getUser());
        score.setText(context.getResources().getString(R.string.score) + ": " + values.get(position).getScore());
        //imageView.setImageResource(R.drawable.user);
        //background.setImageResource(R.color.red);
        return items;
    }
}
