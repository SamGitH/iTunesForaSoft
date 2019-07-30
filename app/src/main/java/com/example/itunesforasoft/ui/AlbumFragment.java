package com.example.itunesforasoft.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesforasoft.MainActivity;
import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.models.Song;
import com.example.itunesforasoft.network.Search;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//import static com.example.itunesforasoft.MainActivity.songs;

public class AlbumFragment extends Fragment implements View.OnClickListener{

    public static final String ALBUM = "ALBUM";
    private Album album;

    private final int BUT_BACK = R.id.fa_bt;
    public static final ArrayList <Song> songs = new ArrayList<>();

    private TextView collectionName;
    private TextView artistName;
    private TextView primaryGenreNameAndDate;
    private ImageView albumArt;
    private TextView trackCount;
    private Button backButton;
    private RecyclerView recyclerView;

    private final SongAdapter songAdapter = new SongAdapter(songs);

    //    private ScrollView scrollView;
//    private static LinearLayout linearLayout;
//    private static View itemSong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Bundle args = getArguments();
        album = args.getParcelable(ALBUM);
        Search.loadSongs(album.collectionId, songAdapter);
        findViews(view);
        bind();

//        View itemSongz = getLayoutInflater().inflate(R.layout.song_item, null);
//        itemSong = itemSongz;
//        text = args.getString(TEXT_KEY);
//
//        View layout = view.findViewById(R.id.aut_fragment);
//        TextView textView = view.findViewById(R.id.aut_fragment_text);
//
//        textView.setText(text);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == BUT_BACK) {
            Fragment listFragment = new ListFragment();
            getFragmentManager().beginTransaction().replace(R.id.activity_main, listFragment).commit();
        }
    }

    private void findViews(View view){
        collectionName = view.findViewById(R.id.fa_tv_album_name);
        artistName = view.findViewById(R.id.fa_tv_artist_name);
        primaryGenreNameAndDate = view.findViewById(R.id.fa_tv_genre_name_and_date);
        albumArt = view.findViewById(R.id.fa_iv);
//        scrollView = view.findViewById(R.id.fa_sv);
//        linearLayout = view.findViewById(R.id.fa_ll);
        trackCount = view.findViewById(R.id.fa_info);
        backButton = view.findViewById(BUT_BACK);
        recyclerView = view.findViewById(R.id.fa_rv);
    }

    private void bind (){
        collectionName.setText(album.collectionName);
        artistName.setText(album.artistName);
        primaryGenreNameAndDate.setText(album.primaryGenreName + ", " + album.releaseDate);

        recyclerView.setAdapter(songAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String strSong;
        if(album.trackCount == 1)
            strSong = " Song";
        else
            strSong = " Songs";
        trackCount.setText(album.trackCount.toString() + strSong);

        Picasso.get().load(album.artworkUrl100).into(albumArt);

        backButton.setOnClickListener(this);
    }

//    public static void bindSongs(){
//        for (int i = 0; i < songs.size(); i++) {
//            TextView songName = itemSong.findViewById(R.id.si_song_name);
//            TextView time = itemSong.findViewById(R.id.si_time);
//            songName.setText(songs.get(i).trackNumber + " " + songs.get(i).trackName);
//            time.setText(songs.get(i).time);
//            linearLayout.addView(itemSong);
//        }
//    }

}
