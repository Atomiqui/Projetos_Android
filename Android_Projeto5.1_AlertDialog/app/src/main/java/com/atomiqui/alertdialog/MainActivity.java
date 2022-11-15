package com.atomiqui.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button butt_alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt_alertDialog = findViewById(R.id.butt_alertDialog);

        butt_alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_AlertDialog();
            }
        });
    }

    private void call_AlertDialog() {
        // instanciar o alertDialog
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // cocngi title and message
        alertDialog.setTitle("AlertDialog Title");
        alertDialog.setMessage("Message of this AlertDialog");
        alertDialog.setCancelable(false);

        // config positive or negative action
        alertDialog.setPositiveButton("Sim!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //toast
            }
        });

        alertDialog.setNegativeButton("Não!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        // create and show the alertDialog
        alertDialog.create();
        alertDialog.show();
    }
}