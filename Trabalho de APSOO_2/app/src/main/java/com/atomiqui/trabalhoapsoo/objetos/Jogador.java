package com.atomiqui.trabalhoapsoo.objetos;

import com.atomiqui.trabalhoapsoo.activity.MainActivity;

import java.io.Serializable;

public class Jogador implements Serializable {
    private String name, position, team;
    private int numCamisa, image;

    public Jogador(String name, String position, String team, int numCamisa, int image) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.numCamisa = numCamisa;
        this.image = image;
        MainActivity.jogadores.add(this);
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

    public int getNumCamisa() {
        return numCamisa;
    }

    public int getImage() {
        return image;
    }
}
