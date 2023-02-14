package com.atomiqui.trabalhoapsoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.fragment.EscalarFragment;
import com.atomiqui.trabalhoapsoo.fragment.HomeFragment;
import com.atomiqui.trabalhoapsoo.fragment.JogadoresFragment;
import com.atomiqui.trabalhoapsoo.padroes.mediator.MediatorPerfilJogadores;
import com.atomiqui.trabalhoapsoo.padroes.memento.Originator;
import com.atomiqui.trabalhoapsoo.objetos.Jogador;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button_home, button_escalar, button_jogadores;
    private HomeFragment homeFragment;
    private EscalarFragment escalarFragment;
    private JogadoresFragment jogadoresFragment;
    public static List<Jogador> jogadores;
    public static List<Originator.Memento> savedStates;
    public static FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        button_home         = findViewById(R.id.button_home);
        button_escalar      = findViewById(R.id.button_escalar);
        button_jogadores    = findViewById(R.id.button_jogadores);

        savedStates         = new ArrayList<>();

        homeFragment        = HomeFragment.obterInstancia ();
        escalarFragment     = EscalarFragment.obterInstancia();
        jogadoresFragment   = JogadoresFragment.obterInstancia ();
        transaction         = getSupportFragmentManager().beginTransaction();

        jogadores           = new ArrayList<Jogador>();
        criaSelecao();

        iniciaFragmentPadrao();
        OnClickListenerHome ();
        OnClickListenerEscalar ();
        OnClickListenerJogadores ();
    }

    private void iniciaFragmentPadrao() {
        transaction.add(R.id.frame_layout, homeFragment);
        transaction.commit();
    }

    private void OnClickListenerHome() {
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickListenerFragment(R.id.frame_layout, homeFragment);
            }
        });
    }

    private void OnClickListenerEscalar() {
        button_escalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickListenerFragment(R.id.frame_layout, escalarFragment);
            }
        });
    }

    private void OnClickListenerJogadores() {
        button_jogadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickListenerFragment(R.id.frame_layout, jogadoresFragment);
            }
        });
    }

    private void OnClickListenerFragment(int id_layout, Fragment fragment) {
        transaction  = getSupportFragmentManager().beginTransaction();
        transaction.replace(id_layout, fragment);
        transaction.commit();
    }

    public List<Originator.Memento> getSavedStates() {
        return savedStates;
    }

    private void criaSelecao() {
        Jogador self;
        self = new Jogador("Letícia Izidoro", "Goleira", "Corinthians", 22, R.drawable.leticiaizidoro);
        self = new Jogador("Tamires", "Defensora", "Fortuna Hjorring ", 6, R.drawable.tamiresdefensora);
        self = new Jogador("Camilinha", "Defensora", "Orlando Pride", 15, R.drawable.camilinha);
        self = new Jogador("Kathellen", "Defensora", "Bordeaux ", 14, R.drawable.kathellen);
        self = new Jogador("Mônica", "Defensora", "Corinthians", 21, R.drawable.monica);
        self = new Jogador("Andressinha", "Meia", "Portland Thorns FC", 17, R.drawable.andressinha);
        self = new Jogador("Formiga", "Meia", "Paris Saint-Germain", 8, R.drawable.formiga);
        self = new Jogador("Thaísa", "Meia", "Milan", 5, R.drawable.thaisa);
        self = new Jogador("Bia Zaneratto", "Atacante", "Incheon Hyundai", 16, R.drawable.bia);
        self = new Jogador("Raquel", "Atacante", "Sporting Huelva", 20, R.drawable.raquel);
        self = new Jogador("Debinha", "Atacante", "North Carolina Courage", 9, R.drawable.debinha);
        self = new Jogador("Ludmila", "Atacante", "Atlético de Madrid", 19, R.drawable.ludmila);
        self = new Jogador("Marta", "Atacante", "Orlando Pride", 10, R.drawable.marta);
    }

    public static FragmentTransaction getTransaction() {
        return transaction;
    }
}