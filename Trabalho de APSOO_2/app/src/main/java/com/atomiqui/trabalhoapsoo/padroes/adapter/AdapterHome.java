package com.atomiqui.trabalhoapsoo.padroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.activity.MainActivity;
import com.atomiqui.trabalhoapsoo.fragment.EscalarFragment;
import com.atomiqui.trabalhoapsoo.fragment.HomeFragment;
import com.atomiqui.trabalhoapsoo.padroes.memento.Originator;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter <AdapterHome.MyViewHolder> {
    private List<Originator.Memento> savedStates;
    private FragmentTransaction transaction;

    private static AdapterHome instancia = new AdapterHome();

    private AdapterHome () {
        // TODO usar um padrão pra trocar informações
        this.savedStates = MainActivity.savedStates;
        this.transaction = MainActivity.getTransaction();
    }

    public static synchronized AdapterHome obterInstancia() {
        return instancia;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textAnnotation;
        Button buttonAbrir, buttonExcluir;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textName        = itemView.findViewById(R.id.textName);
            textAnnotation  = itemView.findViewById(R.id.textAnnotation);
            buttonAbrir     = itemView.findViewById(R.id.buttonAbrir);
            buttonExcluir   = itemView.findViewById (R.id.buttonExcluir);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_adapter, parent, false);
        return new AdapterHome.MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Originator.Memento memento = savedStates.get(position);

        holder.textName.setText(memento.getName ());
        holder.textAnnotation.setText (memento.getAnnotation ());
        holder.buttonAbrir.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                abreEscalacao(view, memento);
            }
        });

        holder.buttonExcluir.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                savedStates.remove (memento);
                HomeFragment.obterInstancia ().atualizaRecycler();
            }
        });
    }

    @Override
    public int getItemCount() {
        return savedStates.size ();
    }

    private void abreEscalacao(View view, Originator.Memento memento) {
        EscalarFragment escalarFragment = EscalarFragment.obterInstancia ();
        escalarFragment.setGetSavedState (memento.getSavedState ());
        Toast.makeText (view.getContext (), "Escalação carregada.\nAbra a aba de escalar!", Toast.LENGTH_LONG).show ();
    }
}
