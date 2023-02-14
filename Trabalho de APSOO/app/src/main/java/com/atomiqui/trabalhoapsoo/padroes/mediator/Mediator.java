package com.atomiqui.trabalhoapsoo.padroes.mediator;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapsoo.objetos.Jogador;

public interface Mediator {
    void abrePerfil(View view, Jogador jogador);
}
