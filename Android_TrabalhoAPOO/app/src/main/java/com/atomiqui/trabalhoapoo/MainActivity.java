package com.atomiqui.trabalhoapoo;

import static com.atomiqui.trabalhoapoo.ui.jogadores.JogadoresFragment.jogadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Menu;

import com.atomiqui.trabalhoapoo.adapter.Adapter;
import com.atomiqui.trabalhoapoo.ui.escalar.EscalarFragment;
import com.atomiqui.trabalhoapoo.ui.jogadores.Jogador;
import com.atomiqui.trabalhoapoo.ui.jogadores.JogadoresFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapoo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerJogadores;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerJogadores = findViewById(R.id.recyclerJogadores);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        criaSeleção();
        Intent intent = new Intent(this, JogadoresFragment.class);
        intent.putExtra("recyclerJogadores", (Parcelable) findViewById(R.id.recyclerJogadores));
        //startActivity(intent);
    }

    /*public void startActivity(String url) {
        Intent intent = new Intent(this, JogadoresFragment.class);
        intent.putExtra(EXTRA_URL, url);
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void criaSeleção() {
        Jogador self;
        self = new Jogador("Letícia Izidoro", "goleira", "Corinthians", 22, R.drawable.leticiaizidoro);
        self = new Jogador("Tamires", "defensora", "Fortuna Hjorring ", 6, R.drawable.tamiresdefensora);
        self = new Jogador("Camilinha", "defensora", "Orlando Pride", 15, R.drawable.camilinha);
        self = new Jogador("Kathellen", "defensora", "Bordeaux ", 14, R.drawable.kathellen);
        self = new Jogador("Mônica", "defensora", "Corinthians", 21, R.drawable.monica);
        self = new Jogador("Andressinha", "Meia", "Portland Thorns FC", 17, R.drawable.andressinha);
        self = new Jogador("Formiga", "Meia", "Paris Saint-Germain", 8, R.drawable.formiga);
        self = new Jogador("Thaísa", "Meia", "Milan", 5, R.drawable.thaisa);
        self = new Jogador("Bia Zaneratto", "Atacante", "Incheon Hyundai", 16, R.drawable.bia);
        self = new Jogador("Raquel", "Atacante", "Sporting Huelva", 20, R.drawable.raquel);
        self = new Jogador("Debinha", "Atacante", "North Carolina Courage", 9, R.drawable.debinha);
        self = new Jogador("Ludmila", "Atacante", "Atlético de Madrid", 19, R.drawable.ludmila);
        self = new Jogador("Marta", "Atacante", "Orlando Pride", 10, R.drawable.marta);
    }
}