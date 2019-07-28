package com.example.itunesforasoft.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkModule {

    private static final String BASE_URL = "https://itunes.apple.com";
    public static ItunesService getItunesService(){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        return retrofit.create(ItunesService.class);
    }
}
