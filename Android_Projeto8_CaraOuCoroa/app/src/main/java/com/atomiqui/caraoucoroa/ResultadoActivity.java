package com.atomiqui.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private Button button_voltar;
    private ImageView image_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        button_voltar   = findViewById(R.id.button_voltar);
        image_resultado = findViewById(R.id.image_resultado);

        mostraResultado();

        button_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // encerra essa view
                finish();
            }
        });
    }

    public void mostraResultado() {
        // Recupera os dados
        Bundle bundle = getIntent().getExtras();

        // Recebe 0 ou 1, então a posição 0 é cara e 1 coroa
        int[] imgs = {R.drawable.moeda_cara, R.drawable.moeda_coroa};
        image_resultado.setImageResource(imgs[bundle.getInt("resultado")]);
    }
}