package com.atomiqui.trabalhoapoo.ui.jogadores;

import android.widget.ImageView;

public class Jogador {
    private String name, position, team;
    private int numCamisa, image;

    public Jogador(String name, String position, String team, int numCamisa, int image) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.numCamisa = numCamisa;
        this.image = image;
        JogadoresFragment.jogadores.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(int numCamisa) {
        this.numCamisa = numCamisa;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
