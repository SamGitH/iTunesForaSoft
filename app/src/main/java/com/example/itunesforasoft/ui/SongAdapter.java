package com.example.itunesforasoft.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{

    private List<Song> songs;

    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_item, viewGroup, false);
        return new SongAdapter.SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder viewHolder, int i) {
        Song song = songs.get(i);
        viewHolder.bind(song);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    static final class SongViewHolder extends RecyclerView.ViewHolder {

        private final TextView trackNumber;
        private final TextView songName;
        private final TextView time;
        private Song song;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            trackNumber = itemView.findViewById(R.id.si_song_number);
            songName = itemView.findViewById(R.id.si_song_name);
            time = itemView.findViewById(R.id.si_time);
        }

        private void bind(@NonNull Song song) {
            this.song = song;
            trackNumber.setText(song.trackNumber.toString());
            songName.setText(song.trackName);
            time.setText(song.time);
        }

    }

}
