package com.atomiqui.cardview.Model;

import android.widget.ImageView;

public class Postagem {
    private String title, legenda;
    private int image;

    public Postagem() {
    }

    public Postagem(String title, String legenda, int image) {
        this.title = title;
        this.legenda = legenda;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
