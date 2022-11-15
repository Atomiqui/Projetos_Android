package com.atomiqui.cardview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atomiqui.cardview.Model.Postagem;
import com.atomiqui.cardview.R;

import java.util.List;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.MyViewHolder> {
    private List<Postagem> postagens;

    public AdapterPost() {

    }

    public AdapterPost(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.post_layout,
                parent, false
        );

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(postagens != null) {
            Postagem post = postagens.get(position);

            holder.post_title.setText(post.getTitle());
            holder.post_legenda.setText(post.getLegenda());
            holder.post_image.setImageResource(post.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView post_title, post_legenda;
        private ImageView post_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            post_title = itemView.findViewById(R.id.text_title);
            post_image = itemView.findViewById(R.id.imageView);
            post_legenda = itemView.findViewById(R.id.text_legenda);
        }
    }
}
