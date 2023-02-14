package com.atomiqui.trabalhoapsoo.fragment;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.padroes.adapter.AdapterJogadores;
import com.atomiqui.trabalhoapsoo.padroes.adapter.DragData;

import java.util.List;

public interface EscalarAux {

    static void carregaCampo(View view, List<View> miniaturas) {
        CardView campo = view.findViewById(R.id.cardView);
        for (View miniatura : miniaturas) {
            final View shape = LayoutInflater.from(
                    view.getContext()).inflate(R.layout.miniaturas_adapter, campo, false);
            shape.setBackground (miniatura.getBackground ());
            shape.setX(miniatura.getX ());
            shape.setY(miniatura.getY ());
            shape.getLayoutParams().width = miniatura.getWidth ();
            shape.getLayoutParams().height = miniatura.getHeight ();
            campo.addView(shape);
        }
    }

    static void criaRecyclerJogadores(View view) {
        RecyclerView recyclerJogadores;
        recyclerJogadores = view.findViewById(R.id.recycler_miniaturas);
        AdapterJogadores adapterJogadores = AdapterJogadores.obterInstancia ();
        adapterJogadores.setCont (true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (view.getContext (), LinearLayoutManager.HORIZONTAL, false);
        recyclerJogadores.setHasFixedSize(true);
        recyclerJogadores.setLayoutManager(layoutManager);
        recyclerJogadores.setAdapter(adapterJogadores);
    }

    static void createAlertDialog(View view, String title, String messege) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle(title);
        alertDialog.setMessage(messege);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { /*no action*/ }
        });
        alertDialog.create();
        alertDialog.show();
    }

    static boolean validaShape(View view, DragData state, List<View> miniaturas) {
        for (View miniatura:miniaturas) {
            if(miniatura.getId () == state.item.getImage()) {
                createAlertDialog(view,"Jogador já está em campo!", "Use outro, todos querem jogar!");
                return true;
            }
        }
        return false;
    }
}
