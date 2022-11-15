package com.atomiqui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private TextView text_title, text_subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        text_title      = findViewById(R.id.text_title);
        text_subtitle   = findViewById(R.id.text_subTitle);

        // Recuperar os dados
        Bundle dados = getIntent().getExtras();
        /* Ao inves de fazer isso:
        String title = dados.get("title").toString();
        ou isso:
        String title2 = dados.getString("title");*/

        // Preferi fazer isso:
        text_title.setText(dados.getString("title"));
        text_subtitle.setText(dados.getString("subtitle"));

        // Agora pegando um objeto
        User user = (User) dados.getSerializable("user");
        text_title.setText(user.getNome());
        text_subtitle.setText(user.getEmail());
    }
}