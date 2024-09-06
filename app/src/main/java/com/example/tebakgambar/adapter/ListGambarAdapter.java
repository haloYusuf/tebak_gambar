package com.example.tebakgambar.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tebakgambar.DetailActivity;
import com.example.tebakgambar.R;
import com.example.tebakgambar.model.Gambar;

import java.util.ArrayList;

public class ListGambarAdapter extends RecyclerView.Adapter<ListGambarAdapter.ListViewHolder> {

    private ArrayList<Gambar> listGambar;

    public ListGambarAdapter(ArrayList<Gambar> listGambar) {
        this.listGambar = listGambar;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tebak_gambar, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Gambar gambar = listGambar.get(position);
        Glide.with(holder.itemView.getContext()).load(gambar.getImageUrl()).into(holder.imgView);

        holder.cdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gambar gambar = listGambar.get(position);
                Intent moveDetail = new Intent(view.getContext(), DetailActivity.class);
                moveDetail.putExtra(DetailActivity.EXTRA_GAMBAR, gambar);
                view.getContext().startActivity(moveDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGambar.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        CardView cdView;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.iv_gambar);
            cdView = itemView.findViewById(R.id.card_image);
        }
    }
}
