package com.example.itunesforasoft.network;

import com.example.itunesforasoft.App;
import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.models.Song;
import com.example.itunesforasoft.network.models.AlbumModelJS;
import com.example.itunesforasoft.network.models.ItunesAlbumsModel;
import com.example.itunesforasoft.network.models.ItunesSongsModel;
import com.example.itunesforasoft.network.models.SongModelJS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.itunesforasoft.MainActivity.albumList;

public class Search {

    public static void loadAlbums(String key){
        Map<String, String> data = new HashMap<>();
        data.put("entity", "album");
        data.put("term", key);
        albumList.clear();
        App.getItunesService().getAlbums(data).enqueue(new Callback<ItunesAlbumsModel>() {
            @Override
            public void onResponse(Call<ItunesAlbumsModel> call, Response<ItunesAlbumsModel> response) {
                for (AlbumModelJS albumModelJS : response.body().getResults()){
                    String date = new String();//new
                    for (int i = 0; i < 4; i++)
                        date += albumModelJS.getReleaseDate().charAt(i);

                    albumList.add(new Album(albumModelJS.getArtistName(),
                            albumModelJS.getCollectionName(),
                            albumModelJS.getArtworkUrl100(),
                            date,
                            albumModelJS.getPrimaryGenreName(),
                            albumModelJS.getTrackCount()));
                }
            }

            @Override
            public void onFailure(Call<ItunesAlbumsModel> call, Throwable t) {

            }
        });
    }

    public static ArrayList<Song> loadSongs(Integer id){

        Map<String, String> data = new HashMap<>();
        data.put("entity", "song");
        data.put("id", id.toString());
        final ArrayList<Song> songs = new ArrayList<>();
        App.getItunesService().getSongs(data).enqueue(new Callback<ItunesSongsModel>() {
            @Override
            public void onResponse(Call<ItunesSongsModel> call, Response<ItunesSongsModel> response) {
                for (SongModelJS songModelJS : response.body().getResults()){
                    Integer seconds = songModelJS.getTrackTimeMillis()/1000;//new
                    String time;
                    songs.add(new Song( songModelJS.getTrackName(), songModelJS.getTrackNumber(), songModelJS.getTrackTimeMillis()));
                }
            }

            @Override
            public void onFailure(Call<ItunesSongsModel> call, Throwable t) {

            }
        });

        return songs;
    }
}
