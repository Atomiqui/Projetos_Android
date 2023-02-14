package com.atomiqui.trabalhoapsoo.padroes.mediator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.atomiqui.trabalhoapsoo.activity.PerfilAcitivity;
import com.atomiqui.trabalhoapsoo.objetos.Jogador;

public class MediatorPerfilJogadores extends AppCompatActivity implements Mediator {

    public MediatorPerfilJogadores () {
    }

    @Override
    public void abrePerfil(View view, Jogador jogador) {

        Intent intent = new Intent(view.getContext (), PerfilAcitivity.class);
        intent.putExtra("jogador", jogador);
        view.getContext ().startActivity(intent);
    }
}
