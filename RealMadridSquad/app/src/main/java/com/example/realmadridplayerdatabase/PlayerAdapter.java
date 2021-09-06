package com.example.realmadridplayerdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerViewHolder> {

    private Context context;
    private List<PlayerData> playerList;

    public PlayerAdapter(Context context, List<PlayerData> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlayerViewHolder holder, int position) {
        holder.tvName.setText(playerList.get(position).getPlayerName());
        holder.tvPosition.setText(playerList.get(position).getPlayerPosition());
        holder.tvBirthDate.setText(playerList.get(position).getPlayerBirthDate());
        holder.tvBirthPlace.setText(playerList.get(position).getPlayerBirthPlace());
        holder.tvHeight.setText(playerList.get(position).getPlayerHeight());
        holder.tvDescription.setText(playerList.get(position).getPlayerDescription());

        Picasso.get().load(playerList.get(position).getPlayerCountry()).into(holder.ivCountry);
        Picasso.get().load(playerList.get(position).getPlayerImage()).into(holder.ivPlayer);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("PlayerImage", playerList.get(holder.getAdapterPosition()).getPlayerImage());
                intent.putExtra("PlayerDescription", playerList.get(holder.getAdapterPosition()).getPlayerDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
