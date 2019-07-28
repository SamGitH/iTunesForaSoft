package com.example.itunesforasoft;

import android.app.Application;

import com.example.itunesforasoft.network.ItunesService;
import com.example.itunesforasoft.network.NetWorkModule;

public class App extends Application {
    private final static ItunesService itunesService = NetWorkModule.getItunesService();

    @Override
    public void onCreate(){
        super.onCreate();
    }

    public static ItunesService getItunesService(){ return itunesService;}
}
