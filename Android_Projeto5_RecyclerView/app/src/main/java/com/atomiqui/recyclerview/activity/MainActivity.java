package com.atomiqui.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.atomiqui.recyclerview.R;
import com.atomiqui.recyclerview.RecyclerItemClickListener;
import com.atomiqui.recyclerview.adapter.Adapter;
import com.atomiqui.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_filmes;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_filmes = findViewById(R.id.recycler_filmes);

        // Listagem de filmes
        this.makeFilms();

        // Adapter
        Adapter adapter = new Adapter(listaFilmes);

        // LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recycler_filmes.setHasFixedSize(true);
        recycler_filmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycler_filmes.setLayoutManager(layoutManager);
        recycler_filmes.setAdapter(adapter);

        // Evento de  Click
        recycler_filmes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recycler_filmes,
            new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Filme film = listaFilmes.get(position);
                    Toast.makeText(getApplicationContext(), film.getTitle() + " Pressionado.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onLongItemClick(View view, int position) {
                    Filme film = listaFilmes.get(position);
                    Toast.makeText(getApplicationContext(), film.getTitle() + " Pressionado click longo.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }
        }));
    }

    public void makeFilms(){
        for(int i = 0; i < 20; i++) {
            Filme film = new Filme("Filme"+i, "genero", "200"+i);
            listaFilmes.add(film);
        }
    }
}