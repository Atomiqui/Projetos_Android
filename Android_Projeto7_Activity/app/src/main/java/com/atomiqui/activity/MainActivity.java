package com.atomiqui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_enviar = findViewById(R.id.button_enviar);

        button_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Minha INTENÇÃO é ir para essa activity                    essa aqui
                Intent intent = new Intent(getApplicationContext(), SecondaryActivity.class);

                // Passar os dados:
                intent.putExtra("title", "Test Title");
                intent.putExtra("subtitle", "test Subtitle");

                // Passando um objeto
                // objeto deve implementar (implements) Serializable para poder ser passado
                User user = new User("Alisson", "email", "03395741001");
                intent.putExtra("user", user);

                // Abrindo outra activity
                startActivity(intent);
            }
        });
    }
}