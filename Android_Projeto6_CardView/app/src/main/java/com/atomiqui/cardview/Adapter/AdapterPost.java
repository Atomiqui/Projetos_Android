package com.atomiqui.cardview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.cardview.R;

public class AdapterPost extends RecyclerView.Adapter <AdapterPost.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*View itemList = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_post,
                parent,
                false
        );
        return new MyViewHolder(itemList);
         */

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.post_title.setText("Texto teste");
        //holder.post_imagem.setImageResource(R.drawable.ic_favorite_24);
        //holder.post_legenda.setText("Texto teste");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //private TextView post_title, post_legenda;
        //private ImageView post_imagem;

        public MyViewHolder(@NonNull View itemList) {
            super(itemList);
            /*this.post_title = itemList.findViewById(R.id.text_Title);
            this.post_imagem = itemList.findViewById(R.id.imageView);
            this.post_legenda = itemList.findViewById(R.id.text_Legenda);*/
        }
    }
}
