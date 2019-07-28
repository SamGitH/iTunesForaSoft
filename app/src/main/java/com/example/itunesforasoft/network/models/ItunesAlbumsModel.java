package com.example.itunesforasoft.network.models;

import java.util.List;

public class ItunesAlbumsModel {
    Integer resultCount;
    List<AlbumModelJS> results;

    public Integer getResultCount() {
        return resultCount;
    }

    public List<AlbumModelJS> getResults() {
        return results;
    }
}
