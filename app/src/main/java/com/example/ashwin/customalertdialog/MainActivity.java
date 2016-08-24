package com.example.ashwin.customalertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //setting dialog title
        TextView title = new TextView(this);
        title.setText(R.string.dialog_title);
        title.setTextColor(Color.BLACK);
        //title.setGravity(Gravity.CENTER);
        title.setPadding(75, 75, 75, 10);
        title.setTextSize(20);

        alertDialogBuilder.setCustomTitle(title);

        //setting dialog message
        TextView message = new TextView(this);
        message.setText(R.string.dialog_text);
        message.setTextColor(Color.BLACK);
        message.setPadding(75, 75, 75, 25);  //left, top, right, bottom
        message.setLineSpacing(0, 1.2f);     //sum, multiplier
        message.setTextSize(18);

        alertDialogBuilder.setView(message);

        //setting positive button
        alertDialogBuilder.setPositiveButton("ALLOW", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                //OK
                Toast.makeText(getApplicationContext(), "Yippie, you allowed", Toast.LENGTH_SHORT).show();
            }
        });

        //setting negative button
        alertDialogBuilder.setNegativeButton("DENY", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //CANCEL
                Toast.makeText(getApplicationContext(), "Oops, you denied", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        //setting dialog width and height
        alertDialog.getWindow().setLayout(400, 400);

        //showing alert dialog
        alertDialog.show();

        //changing button text colors
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#00A298"));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#00A298"));

        //setting button text to bold
        alertDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        alertDialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE).setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        //changing button padding
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setPadding(50, 50, 55, 65);
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setPadding(50, 50, 55, 65);

    }

}
