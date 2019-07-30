package com.example.itunesforasoft.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesforasoft.MainActivity;
import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.network.Search;

import java.util.ArrayList;
import java.util.List;

import static com.example.itunesforasoft.MainActivity.albumList;
//import static com.example.itunesforasoft.MainActivity.songs;

public class ListFragment extends Fragment implements View.OnClickListener {

//    public static final String ALBUM_LIST = "ALBUM_LIST";
    //private List<Album> albumList = new ArrayList<>();

    private final int BUT_SEARCH = R.id.fl_bt;
    //private final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);;
//    private Search search;

    private EditText editText;
    private RecyclerView recyclerView;
    private Button searchButton;
    private static TextView searchInfo;

    private final AlbumAdapter albumAdapter = new AlbumAdapter(MainActivity.albumList, new AlbumAdapter.Listener() {//new ArrayList<Album>()
        @Override
        public void onAlbumClicked(Album album) {
            //Search.loadSongs(album.collectionId);
            Bundle arg = new Bundle();
            Fragment albumFragment = new AlbumFragment();
            //album.setSongs(songs);//new
            arg.putParcelable(AlbumFragment.ALBUM, album);
            albumFragment.setArguments(arg);
            //FragmentManager fragmentManager = getFragmentManager();
            getFragmentManager().beginTransaction().replace(R.id.activity_main, albumFragment).commit();
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
//        Bundle args = getArguments();
//        int size = args.getInt(ALBUM_LIST);
//        for (int i = 0; i < size; i++) {
//            Album album = args.getParcelable(ALBUM_LIST);
//            albumList.add(album);
//
//        }
        findViews(view);
        bind();
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(mLayoutManager);

    }

    private void findViews(View view){
        editText = view.findViewById(R.id.fl_et);
        recyclerView = view.findViewById(R.id.fl_rv);
        searchButton = view.findViewById(BUT_SEARCH);
        searchInfo = view.findViewById(R.id.fl_tv);
    }

    private void bind (){
        //editText.setText(MainActivity.ms);
        recyclerView.setAdapter(albumAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchButton.setOnClickListener(this);
        searchInfo.setText("Start search");
    }

    public static void setSearchInfo(){
        if (albumList.isEmpty())
            searchInfo.setText("No matches found");
        else
            searchInfo.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == BUT_SEARCH) {
//            searchButton.startAnimation(animAlpha);
            String albumKey;
            albumKey = editText.getText().toString();
            albumKey = albumKey.replace("\n", "");
            albumKey = albumKey.replace(" ", "+");
            Search.loadAlbums(albumKey, albumAdapter);
//            albumAdapter.notifyDataSetChanged();
        }
    }
}
