package com.example.itunesforasoft.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Album;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private static final String ALBUM_LIST = "ALBUM_LIST";


    private final AlbumAdapter albumAdapter = new AlbumAdapter(new ArrayList<Album>(), new AlbumAdapter.Listener() {
        @Override
        public void onAlbumClicked(Album album) {
//            Intent intent = new Intent(ReportsActivity.this, ReportActivity.class);
//            intent.putExtra("Report", report);
//            startActivity(intent);
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = view.findViewById(R.id.fl_rv);
        recyclerView.setAdapter(albumAdapter);

    }

}
