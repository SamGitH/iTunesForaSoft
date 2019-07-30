package com.example.itunesforasoft.network;

import com.example.itunesforasoft.network.models.ItunesAlbumsModel;
import com.example.itunesforasoft.network.models.ItunesSongsModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ItunesService {
    @GET("/lookup")
    Call<ItunesSongsModel> getSongs(
            @QueryMap Map<String, String> options
    );

    @GET("/search")
    Call<ItunesAlbumsModel> getAlbums(
            @QueryMap Map<String, String> options
    );
}
