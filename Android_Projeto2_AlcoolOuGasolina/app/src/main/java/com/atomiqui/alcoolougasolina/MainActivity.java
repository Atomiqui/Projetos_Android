package com.atomiqui.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText TextInput_Alcool, TextInput_Gasolina;
    private Button Butt_Calcular;
    private TextView Text_Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInput_Alcool    = findViewById(R.id.TextInput_Alcool);
        TextInput_Gasolina  = findViewById(R.id.TextInput_Gasolina);
        Butt_Calcular       = findViewById(R.id.Butt_Calcular);
        Text_Resultado      = findViewById(R.id.Text_Resultado);

        Butt_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valAlcool       = TextInput_Alcool.getText().toString();
                String valGasolina     = TextInput_Gasolina.getText().toString();

                if(validaCampos(valAlcool, valGasolina)) {
                    calcCombustivel(Float.parseFloat(valAlcool), Float.parseFloat(valGasolina));
                }
                else
                {
                    Text_Resultado.setText("Preencha todos os campos!");
                }
            }
        });
    }

    private boolean validaCampos(String alcool, String gasolina) {
        return !(alcool == null || alcool.equals("") || gasolina == null || gasolina.equals(""));
    }

    private void calcCombustivel(float alcool, float gasolina) {
        String resultado = "Melhor usar ";

        if(alcool/gasolina >= 0.7) {
            resultado = resultado + "Gasolina.";
        }
        else {
            resultado = resultado + "Álcool.";
        }

        Text_Resultado.setText("" + resultado);
    }
}