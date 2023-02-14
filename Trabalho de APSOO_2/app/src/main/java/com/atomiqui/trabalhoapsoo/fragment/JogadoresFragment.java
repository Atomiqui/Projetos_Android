package com.atomiqui.trabalhoapsoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.activity.MainActivity;
import com.atomiqui.trabalhoapsoo.activity.PerfilAcitivity;
import com.atomiqui.trabalhoapsoo.objetos.Jogador;
import com.atomiqui.trabalhoapsoo.padroes.adapter.AdapterJogadores;
import com.atomiqui.trabalhoapsoo.padroes.mediator.MediatorPerfilJogadores;
import com.atomiqui.trabalhoapsoo.recycler.RecyclerItemClickListener;

public class JogadoresFragment extends Fragment {

    MediatorPerfilJogadores mediatorPerfilJogadores;
    private static JogadoresFragment instancia = new JogadoresFragment();

    private JogadoresFragment () { mediatorPerfilJogadores = new MediatorPerfilJogadores (); }

    public static synchronized JogadoresFragment obterInstancia() {
        return instancia;
    }

    private RecyclerView recyclerJogadores;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogadores, container, false);
        criaRecyclerJogadores(view);
        itemTouchListener();

        return view;
    }

    private void criaRecyclerJogadores(View view) {
        recyclerJogadores = view.findViewById(R.id.recycler_jogadores);
        AdapterJogadores adapterJogadores = AdapterJogadores.obterInstancia ();
        adapterJogadores.setCont (false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerJogadores.setHasFixedSize(true);
        recyclerJogadores.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerJogadores.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.HORIZONTAL));
        recyclerJogadores.setLayoutManager(layoutManager);
        recyclerJogadores.setAdapter(adapterJogadores);
    }

    private void itemTouchListener() {
        recyclerJogadores.addOnItemTouchListener(new RecyclerItemClickListener (getContext (), recyclerJogadores,
            new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Jogador jogador = MainActivity.jogadores.get(position);

                    mediatorPerfilJogadores.abrePerfil (view, jogador);
                }

                @Override
                public void onLongItemClick(View view, int position) { }

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { }
            }));
    }
}