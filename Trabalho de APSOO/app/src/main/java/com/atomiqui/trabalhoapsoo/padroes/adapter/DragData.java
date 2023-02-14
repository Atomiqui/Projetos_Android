package com.atomiqui.trabalhoapsoo.padroes.adapter;

import com.atomiqui.trabalhoapsoo.objetos.Jogador;

public class DragData {

    public final Jogador item;
    public final int width;
    public final int height;

    public DragData(Jogador item, int width, int height) {
        this.item= item;
        this.width = width;
        this.height = height;
    }

}