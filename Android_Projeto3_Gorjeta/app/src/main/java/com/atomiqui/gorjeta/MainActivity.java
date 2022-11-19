package com.atomiqui.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText textInput_valor;
    private TextView text_porcent, text_exibeGorjeta, text_exibeTotal, text_aviso;
    private SeekBar seekBar_porcent;
    private double totalInicial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput_valor     = findViewById(R.id.textInput_valor);
        text_porcent        = findViewById(R.id.text_porcent);
        text_exibeGorjeta   = findViewById(R.id.text_exibeGorjeta);
        text_exibeTotal     = findViewById(R.id.text_exibeTotal);
        text_aviso          = findViewById(R.id.text_aviso);
        seekBar_porcent     = findViewById(R.id.seekBar_porcent);

        seekBar_porcent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                double gorjeta, porcentagem = seekBar.getProgress();

                try {
                    totalInicial = Double.parseDouble(textInput_valor.getText().toString());
                    gorjeta = (porcentagem/100)*totalInicial;

                    DecimalFormat df = new DecimalFormat("#.00");

                    text_porcent.setText( porcentagem + "%");
                    text_exibeGorjeta.setText("R$ " + df.format(gorjeta));
                    text_exibeTotal.setText("R$ " + df.format(totalInicial+gorjeta));

                    text_aviso.setText("");
                }
                catch (Exception e) {
                    seekBar_porcent.setProgress(0);
                    text_porcent.setText("0%");
                    text_exibeGorjeta.setText("");
                    text_exibeTotal.setText("");
                    text_aviso.setText("Insira um valor válido!");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}