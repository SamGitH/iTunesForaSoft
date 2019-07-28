package com.example.itunesforasoft.network.models;

import java.util.List;

public class ItunesSongsModel {
    Integer resultCount;
    List<SongModelJS> results;

    public Integer getResultCount() {
        return resultCount;
    }

    public List<SongModelJS> getResults() {
        return results;
    }
}
