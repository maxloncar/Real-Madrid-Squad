package com.example.realmadridplayerdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView playerDescription;
    ImageView playerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        playerDescription = findViewById(R.id.tvDetailDescription);
        playerImage = findViewById(R.id.ivDetailPlayer);

        Intent intent = this.getIntent();
        String description = intent.getExtras().getString("PlayerDescription");
        String image = intent.getExtras().getString("PlayerImage");

        playerDescription.setText(description);
        Picasso.get().load(image).into(playerImage);
    }

}
