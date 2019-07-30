package com.example.itunesforasoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.network.models.AlbumModelJS;
import com.example.itunesforasoft.network.models.ItunesAlbumsModel;
import com.example.itunesforasoft.models.Song;
import com.example.itunesforasoft.network.models.ItunesSongsModel;
import com.example.itunesforasoft.network.models.SongModelJS;
import com.example.itunesforasoft.ui.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Fragment listFragment = new ListFragment();
    //public static String ms;

    public static ArrayList<Album> albumList = new ArrayList<>();
//    public static ArrayList<Song> songs = new ArrayList<>();

//    void createAlbumList(){
//
//        for (int i = 0; i < 20; i++) {
//            songs.add(new Song("Song" + i, i, i));
//        }
//        for (int i = 0; i < 20; i++) {
//            albumList.add(new Album("Sam",
//                    "Easy life"+i,
//                    "https://i.imgur.com/KLaSJHQ.jpg",
//                    "1999",
//                    "Rock",
//                    songs.size(),
//                    songs));
//        }
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //loadAlbums();
        //createAlbumList();
        //loadSongs();

        setContentView(R.layout.activity_main);

        //test();

        startListFragment();


    }

//    private void loadAlbums(){
//
//        Map<String, String> data = new HashMap<>();
//        data.put("entity", "album");
//        data.put("term", "bon+jovi");
//        App.getItunesService().getAlbums(data).enqueue(new Callback<ItunesAlbumsModel>() {
//            @Override
//            public void onResponse(Call<ItunesAlbumsModel> call, Response<ItunesAlbumsModel> response) {
////                ms = call.request().url().toString();
//                for (AlbumModelJS albumModelJS : response.body().getResults()){
//                    //songs.add(new Song( songModelJS.getTrackName(), songModelJS.getTrackNumber(), songModelJS.getTrackTimeMillis()));
//                    albumList.add(new Album(albumModelJS.getArtistName(),
//                            albumModelJS.getCollectionName(),
//                            albumModelJS.getArtworkUrl100(),
//                            albumModelJS.getReleaseDate(),
//                            albumModelJS.getPrimaryGenreName(),
//                            albumModelJS.getTrackCount(),
//                            songs));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ItunesAlbumsModel> call, Throwable t) {
//
//            }
//        });
//    }

//    private void loadSongs(){
//
//        Map<String, String> data = new HashMap<>();
//        data.put("entity", "song");
//        data.put("id", "1423284802");
//        App.getItunesService().getSongs(data).enqueue(new Callback<ItunesSongsModel>() {
//            @Override
//            public void onResponse(Call<ItunesSongsModel> call, Response<ItunesSongsModel> response) {
////                ms = call.request().url().toString();
//                for (SongModelJS songModelJS : response.body().getResults()){
//                    songs.add(new Song( songModelJS.getTrackName(), songModelJS.getTrackNumber(), songModelJS.getTrackTimeMillis()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ItunesSongsModel> call, Throwable t) {
//
//            }
//        });
//    }

    private void startListFragment(){
//        Bundle arg = new Bundle();
        Fragment listFragment = new ListFragment();
//        arg.putInt(ListFragment.ALBUM_LIST, albumList.size());
//        for (int i = 0; i < albumList.size(); i++) {
//            arg.putParcelable(ListFragment.ALBUM_LIST, albumList.get(i));
//            listFragment.setArguments(arg);
//        }
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, listFragment).commit();
    }

//    private void test(){
//        Map<String, String> data = new HashMap<>();
//        data.put("entity", "album");
//        data.put("term", "bon+jovi");
//        ms = App.getItunesService().getAlbums(data).toString();
//    }
}
