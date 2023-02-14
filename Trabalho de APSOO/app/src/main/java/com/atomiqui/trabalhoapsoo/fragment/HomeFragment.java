package com.atomiqui.trabalhoapsoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.padroes.adapter.AdapterHome;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerFormacoes;

    private static HomeFragment instancia = new HomeFragment();

    private HomeFragment () {}

    public static synchronized HomeFragment obterInstancia() {
        return instancia;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        criaRecyclerHome(view);

        return view;
    }

    private void criaRecyclerHome(View view) {
        recyclerFormacoes = view.findViewById(R.id.recycler_home);

        // TODO mudar para singleton
        AdapterHome adapterHome = AdapterHome.obterInstancia ();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (getContext());
        recyclerFormacoes.setHasFixedSize(true);
        recyclerFormacoes.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerFormacoes.setLayoutManager(layoutManager);
        recyclerFormacoes.setAdapter(adapterHome);
    }

    public void atualizaRecycler() {
        recyclerFormacoes.requestLayout ();
    }
}