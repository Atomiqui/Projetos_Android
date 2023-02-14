package com.atomiqui.trabalhoapsoo.padroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.trabalhoapsoo.R;
import com.atomiqui.trabalhoapsoo.activity.MainActivity;
import com.atomiqui.trabalhoapsoo.objetos.Jogador;

import java.util.List;

public class AdapterJogadores extends RecyclerView.Adapter <AdapterJogadores.MyViewHolder> {
    private List<Jogador> jogadores;
    private boolean cont;

    private static AdapterJogadores instancia = new AdapterJogadores();

    private AdapterJogadores () {
        // TODO usar um padrão pra trocar informações
        this.jogadores = MainActivity.jogadores;
    }

    public static synchronized AdapterJogadores obterInstancia() {
        return instancia;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jogador_nome, jogador_posicao, jogador_camisa;
        ImageView jogador_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            if(cont) {
                jogador_image = itemView.findViewById(R.id.image_miniatura);
                //jogador_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                jogador_nome = itemView.findViewById(R.id.textNomeJogador);
                jogador_posicao = itemView.findViewById(R.id.textPosicaoJogador);
                jogador_camisa = itemView.findViewById(R.id.textCamisaJogador);
                jogador_image = itemView.findViewById(R.id.imageJogador);
                jogador_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(cont) {
            View jogador = LayoutInflater.from(parent.getContext()).inflate(R.layout.miniaturas_adapter, parent, false);
            final MyViewHolder holder = new MyViewHolder(jogador);
            final View shape = holder.jogador_image;
            holder.itemView.setOnLongClickListener(v -> {
                final Jogador item = jogadores.get(holder.getAdapterPosition());
                final DragData state = new DragData(item, shape.getWidth(), shape.getHeight());
                final DragShadowBuilder shadow = new DragShadowBuilder(shape);
                ViewCompat.startDragAndDrop(shape, null, shadow, state, 0);
                return true;
            });
            return holder;
        }
        else {
            View jogador = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_adapter, parent, false);
            return new MyViewHolder(jogador);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Jogador jogador = jogadores.get(position);

        if(cont) {
            holder.jogador_image.setImageResource(jogador.getImage());
        }
        else {
            holder.jogador_nome.setText(jogador.getName());
            holder.jogador_posicao.setText(jogador.getPosition());
            holder.jogador_camisa.setText("Camisa " + jogador.getNumCamisa());
            holder.jogador_image.setImageResource(jogador.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }

    public void setCont(boolean cont) {
        this.cont = cont;
    }
}