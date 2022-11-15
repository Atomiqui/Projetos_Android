package com.atomiqui.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.atomiqui.fragments.R;
import com.atomiqui.fragments.fragment.ContatosFragment;
import com.atomiqui.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {
    private Button butt_conversas, butt_contatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Removendo a elevation da actionbar
        getSupportActionBar().setElevation(0);

        butt_conversas  = findViewById(R.id.button_conversas);
        butt_contatos   = findViewById(R.id.button_contatos);

        conversasFragment = new ConversasFragment();
        contatosFragment = new ContatosFragment();

        // Configurar o objeto para o framento (exibição padrão)
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_conteudo, conversasFragment);
        transaction.commit();

        butt_contatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_conteudo, contatosFragment);
                transaction.commit();
            }
        });

        butt_conversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_conteudo, conversasFragment);
                transaction.commit();
            }
        });
    }
}