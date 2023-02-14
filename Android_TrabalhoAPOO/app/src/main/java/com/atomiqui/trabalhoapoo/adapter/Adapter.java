package com.atomiqui.trabalhoapoo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapoo.R;
import com.atomiqui.trabalhoapoo.ui.jogadores.Jogador;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.MyViewHolder> {
    private List<Jogador> jogadores;

    public Adapter(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jogador_nome, jogador_posicao, jogador_camisa;
        ImageView jogador_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            jogador_nome = itemView.findViewById(R.id.textNomeJogador);
            jogador_posicao = itemView.findViewById(R.id.textPosicaoJogador);
            jogador_camisa = itemView.findViewById(R.id.textCamisaJogador);
            jogador_image = itemView.findViewById(R.id.imageJogador);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View jogador = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_adapter, parent, false);
        return new MyViewHolder(jogador);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Jogador jogador = jogadores.get(position);

        holder.jogador_nome.setText(jogador.getName());
        holder.jogador_posicao.setText(jogador.getPosition());
        holder.jogador_camisa.setText(jogador.getNumCamisa());
        holder.jogador_image.setImageResource(jogador.getImage());
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }
}
