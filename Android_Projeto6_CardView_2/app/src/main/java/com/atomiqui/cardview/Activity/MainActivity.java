package com.atomiqui.cardview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.atomiqui.cardview.Adapter.AdapterPost;
import com.atomiqui.cardview.Model.Postagem;
import com.atomiqui.cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Postagem> postagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Definir um layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // para fazer o efeito de ir passando pro lado
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // para passar pra cima/baixo igual feed

        // GridLayout
        // Da pra por duas colunas (fazer uma galeria)
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // Definir um adapter
        postagens = new ArrayList<Postagem>();
        this.makePosts();
        recyclerView.setAdapter(new AdapterPost(postagens));
    }

    public void makePosts() {
        for (int i = 0; i < 10; i++) {
            Postagem post;

            if(i%2 == 0) {
                post = new Postagem("Nome"+i, "legenda"+i, R.drawable.imagem1);
            }
            else {
                post = new Postagem("Nome"+i, "legenda"+i, R.drawable.imagem2);
            }

            this.postagens.add(post);
        }
    }
}