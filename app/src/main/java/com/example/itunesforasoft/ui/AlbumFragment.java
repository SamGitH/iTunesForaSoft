package com.example.itunesforasoft.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Album;
import com.squareup.picasso.Picasso;

public class AlbumFragment extends Fragment {

    public static final String ALBUM = "ALBUM";
    private Album album;

    private TextView collectionName;
    private TextView artistName;
    private TextView releaseDate;
    private TextView primaryGenreName;
    private ImageView albumArt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Bundle args = getArguments();
        album = args.getParcelable(ALBUM);

        findViews(view);
        bind();

//        text = args.getString(TEXT_KEY);
//
//        View layout = view.findViewById(R.id.aut_fragment);
//        TextView textView = view.findViewById(R.id.aut_fragment_text);
//
//        textView.setText(text);
    }

    private void findViews(View view){
        collectionName = view.findViewById(R.id.fa_tv_album_name);
        artistName = view.findViewById(R.id.fa_tv_artist_name);
        releaseDate = view.findViewById(R.id.fa_tv_date);
        primaryGenreName = view.findViewById(R.id.fa_tv_genre_name);
        albumArt = view.findViewById(R.id.fa_iv);
    }

    private void bind (){
        collectionName.setText(album.collectionName);
        artistName.setText(album.artistName);
        releaseDate.setText(album.releaseDate);
        primaryGenreName.setText(album.primaryGenreName);
        Picasso.get().load(album.artworkUrl100).into(albumArt);
    }
}
