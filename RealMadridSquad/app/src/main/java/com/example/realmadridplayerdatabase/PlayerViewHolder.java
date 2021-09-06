package com.example.realmadridplayerdatabase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerViewHolder extends RecyclerView.ViewHolder {

    ImageView ivPlayer, ivCountry;
    TextView tvName, tvPosition, tvBirthDate, tvBirthPlace, tvHeight, tvDescription;
    CardView cardView;

    public PlayerViewHolder(View itemView) {
        super(itemView);
        ivPlayer = itemView.findViewById(R.id.ivPlayer);
        ivCountry = itemView.findViewById(R.id.ivCountry);
        tvName = itemView.findViewById((R.id.tvName));
        tvPosition = itemView.findViewById((R.id.tvPosition));
        tvBirthDate = itemView.findViewById(R.id.tvBirthDate);
        tvBirthPlace = itemView.findViewById(R.id.tvBirthPlace);
        tvHeight = itemView.findViewById(R.id.tvHeight);
        tvDescription = itemView.findViewById(R.id.tvDescription);
        cardView = itemView.findViewById(R.id.cardView);
    }
}
