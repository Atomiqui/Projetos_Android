package com.atomiqui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.recyclerview.R;
import com.atomiqui.recyclerview.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View film_item = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_adapter, parent, false);
        return new MyViewHolder(film_item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);

        holder.film_name.setText(filme.getTitle());
        holder.film_genre.setText(filme.getGenre());
        holder.film_year.setText(filme.getYear());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView film_name, film_genre, film_year;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            film_name   = itemView.findViewById(R.id.text_title);
            film_genre  = itemView.findViewById(R.id.text_genre);
            film_year   = itemView.findViewById(R.id.text_year);
        }
    }
}
