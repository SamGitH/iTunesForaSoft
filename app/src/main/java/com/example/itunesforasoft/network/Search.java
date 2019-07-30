package com.example.itunesforasoft.network;

import com.example.itunesforasoft.App;
import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.models.Song;
import com.example.itunesforasoft.network.models.AlbumModelJS;
import com.example.itunesforasoft.network.models.ItunesAlbumsModel;
import com.example.itunesforasoft.network.models.ItunesSongsModel;
import com.example.itunesforasoft.network.models.SongModelJS;
import com.example.itunesforasoft.ui.AlbumAdapter;
import com.example.itunesforasoft.ui.AlbumFragment;
import com.example.itunesforasoft.ui.ListFragment;
import com.example.itunesforasoft.ui.SongAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.itunesforasoft.MainActivity.albumList;
import static com.example.itunesforasoft.ui.AlbumFragment.songs;

public class Search {

    public static void loadAlbums(String key, final AlbumAdapter albumAdapter){
        Map<String, String> data = new HashMap<>();
        data.put("entity", "album");
        data.put("term", key);
        albumList.clear();
        App.getItunesService().getAlbums(data).enqueue(new Callback<ItunesAlbumsModel>() {
            @Override
            public void onResponse(Call<ItunesAlbumsModel> call, Response<ItunesAlbumsModel> response) {
                for (AlbumModelJS albumModelJS : response.body().getResults()){
                    String date = "";//new
                    for (int i = 0; i < 4; i++)
                        date += albumModelJS.getReleaseDate().charAt(i);
                    albumList.add(new Album(albumModelJS.getArtistName(),
                            albumModelJS.getCollectionId(),
                            albumModelJS.getCollectionName(),
                            albumModelJS.getArtworkUrl100(),
                            date,
                            albumModelJS.getPrimaryGenreName(),
                            albumModelJS.getTrackCount(),
                            new ArrayList<Song>()));
                }
                ListFragment.setSearchInfo();
                albumAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ItunesAlbumsModel> call, Throwable t) {

            }
        });
    }

    public static void loadSongs(Integer id, final SongAdapter songAdapter){

        Map<String, String> data = new HashMap<>();
        data.put("entity", "song");
        data.put("id", id.toString());
        songs.clear();
        App.getItunesService().getSongs(data).enqueue(new Callback<ItunesSongsModel>() {
            @Override
            public void onResponse(Call<ItunesSongsModel> call, Response<ItunesSongsModel> response) {
                for (int i = 1; i < response.body().getResultCount(); i++) {
                    songs.add(new Song( response.body().getResults().get(i).getTrackName(),
                            response.body().getResults().get(i).getTrackNumber(),
                            getTime(response.body().getResults().get(i).getTrackTimeMillis())));
                }
                songAdapter.notifyDataSetChanged();
            }
            private String getTime(Integer seconds){
                seconds /= 1000;//new
                Integer minutes = seconds / 60;
                seconds %= 60;
                String time;
                if(minutes == 0)
                    time = "0:";
                else
                    time = minutes.toString() + ":";
                if(seconds < 10)
                    time += "0" + seconds.toString();
                else
                    time += seconds.toString();
                return time;
            }

            @Override
            public void onFailure(Call<ItunesSongsModel> call, Throwable t) {

            }
        });
    }
}
