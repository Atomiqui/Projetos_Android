package com.atomiqui.trabalhoapsoo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.objetos.Jogador;
import com.atomiqui.trabalhoapsoo.padroes.mediator.MediatorPerfilJogadores;

public class PerfilAcitivity extends AppCompatActivity {

    MediatorPerfilJogadores mediatorPerfilJogadores;

    private ImageView imagePerfilJogador;
    private TextView textPerfilNome, textPerfilPosicao, textPerfilCamisa;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_perfil);

        imagePerfilJogador = findViewById (R.id.imagePerfilJogador);
        textPerfilNome = findViewById (R.id.textPerfilNome);
        textPerfilPosicao = findViewById (R.id.textPerfilPosicao);
        textPerfilCamisa = findViewById (R.id.textPerfilCamisa);
        buttonVoltar = findViewById (R.id.buttonVoltar);

        carregaInfos ();
        listenerVoltar ();
    }

    private void carregaInfos() {
        Bundle bundle = getIntent().getExtras();
        Jogador jogador = (Jogador) bundle.get("jogador");

        imagePerfilJogador.setImageResource (jogador.getImage ());
        textPerfilNome.setText (jogador.getName ());
        textPerfilPosicao.setText ("Posição: " + jogador.getPosition ());
        textPerfilCamisa.setText ("Camisa: " + jogador.getNumCamisa ());
    }

    private void listenerVoltar () {
        buttonVoltar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                finish ();
            }
        });
    }
}