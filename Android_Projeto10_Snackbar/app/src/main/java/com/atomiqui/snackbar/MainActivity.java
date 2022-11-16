package com.atomiqui.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button button_abrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_abrir = findViewById(R.id.button_abrir);

        button_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(
                        view, "botão pressionado", Snackbar.LENGTH_INDEFINITE
                ).setAction("Sim", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Ações a clicar no "sim"
                    }
                }).setActionTextColor(getResources().getColor(R.color.white)).show();

                // Para fechar a snackbar da pra usar o método dismiss();
            }
        });
    }
}