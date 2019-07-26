package com.example.itunesforasoft.models;

public class Album {

    public String artistName;
    public String collectionName;
    public String artworkUrl100;
    public String releaseDate;
    public String primaryGenreName;

    public Album(String artistName, String collectionName, String artworkUrl100, String releaseDate, String primaryGenreName) {
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.artworkUrl100 = artworkUrl100;
        this.releaseDate = releaseDate;
        this.primaryGenreName = primaryGenreName;
    }
}
