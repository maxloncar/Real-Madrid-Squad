package com.example.realmadridplayerdatabase;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SquadFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<PlayerData> playerList;

    SearchView searchView;

    DatabaseReference reference;

    public SquadFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_squad, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        searchView = (SearchView) view.findViewById(R.id.searchView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        playerList = new ArrayList<PlayerData>();

        reference = FirebaseDatabase.getInstance().getReference().child("Players");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                playerList.clear();
                for (DataSnapshot datasnapshot: snapshot.getChildren()){
                    PlayerData playerData = datasnapshot.getValue(PlayerData.class);
                    playerList.add(playerData);
                }
                PlayerAdapter playerAdapter = new PlayerAdapter(getContext(), playerList);
                recyclerView.setAdapter(playerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong..", Toast.LENGTH_SHORT).show();
            }
        });

        if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
        return view;
    }
    private void search(String string){
        ArrayList<PlayerData> list = new ArrayList<>();
        for (PlayerData data : playerList){
            if (data.getPlayerName().toLowerCase().contains(string.toLowerCase())){
                list.add(data);
            }
        }
        PlayerAdapter playerAdapter = new PlayerAdapter(getContext(), list);
        recyclerView.setAdapter(playerAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}

