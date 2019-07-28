package com.example.itunesforasoft.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    public String trackName;
    public Integer trackNumber;
    public Integer trackTimeMillis;

    public Song(String trackName, Integer trackNumber, Integer trackTimeMillis) {
        this.trackName = trackName;
        this.trackNumber = trackNumber;
        this.trackTimeMillis = trackTimeMillis;
    }

    public Song(Parcel in){
        trackName = in.readString();
        trackNumber = in.readInt();
        trackTimeMillis = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(trackName);
        dest.writeInt(trackNumber);
        dest.writeInt(trackTimeMillis);
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {

        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };


}
