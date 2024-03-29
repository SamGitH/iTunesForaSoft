package com.example.itunesforasoft.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Album implements Parcelable {

    public String artistName;
    public Integer collectionId;
    public String collectionName;
    public String artworkUrl100;
    public String releaseDate;
    public String primaryGenreName;
    public Integer trackCount;

    public Album(String artistName, Integer collectionId, String collectionName, String artworkUrl100, String releaseDate, String primaryGenreName, Integer trackCount) {
        this.artistName = artistName;
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.artworkUrl100 = artworkUrl100;
        this.releaseDate = releaseDate;
        this.primaryGenreName = primaryGenreName;
        this.trackCount = trackCount;
    }

    public Album (Parcel in){
        artistName = in.readString();
        collectionId = in.readInt();
        collectionName = in.readString();
        artworkUrl100 = in.readString();
        releaseDate = in.readString();
        primaryGenreName = in.readString();
        trackCount = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(artistName);
        dest.writeInt(collectionId);
        dest.writeString(collectionName);
        dest.writeString(artworkUrl100);
        dest.writeString(releaseDate);
        dest.writeString(primaryGenreName);
        dest.writeInt(trackCount);
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>(){

        @Override
        public Album createFromParcel(Parcel source) {
            return new Album(source);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}
