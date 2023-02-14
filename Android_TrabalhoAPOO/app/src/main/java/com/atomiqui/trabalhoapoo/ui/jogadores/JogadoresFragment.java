package com.atomiqui.trabalhoapoo.ui.jogadores;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapoo.MainActivity;
import com.atomiqui.trabalhoapoo.R;
import com.atomiqui.trabalhoapoo.adapter.Adapter;
import com.atomiqui.trabalhoapoo.databinding.FragmentJogadoresBinding;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class JogadoresFragment extends Fragment {
    private RecyclerView recyclerJogadores;
    public static List<Jogador> jogadores = new ArrayList<Jogador>();

    private FragmentJogadoresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        JogadoresViewModel jogadoresViewModel =
                new ViewModelProvider(this).get(JogadoresViewModel.class);

        binding = FragmentJogadoresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    private void configRecycler() {
        Intent intent = null;
        try {
            intent = getIntent("");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        recyclerJogadores = intent.getParcelableExtra("recyclerJogadores");
        Adapter adapter = new Adapter(JogadoresFragment.jogadores);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerJogadores.setHasFixedSize(true);
        recyclerJogadores.setLayoutManager(layoutManager);
        recyclerJogadores.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}