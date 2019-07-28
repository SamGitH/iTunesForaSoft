package com.example.itunesforasoft.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Album;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private List <Album> albums;
    private final Listener onAlbumClickListener;

    public AlbumAdapter(List<Album> albums, Listener onAlbumClickListener) {
        this.albums = albums;
        this.onAlbumClickListener = onAlbumClickListener;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_item, viewGroup, false);
        return new AlbumViewHolder(view, onAlbumClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder viewHolder, int i) {
        Album album = albums.get(i);
        viewHolder.bind(album);
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public interface Listener{
        void onAlbumClicked(Album album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    static final class AlbumViewHolder extends RecyclerView.ViewHolder {

        private final TextView collectionName;
        private final TextView artistName;
        private final TextView primaryGenreNameAndDate;
        private final ImageView albumArt;
        private Album album;

        public AlbumViewHolder(@NonNull View itemView, final Listener onAlbumClickListener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAlbumClickListener.onAlbumClicked(album);
                }
            });

            collectionName = itemView.findViewById(R.id.ai_tv_album_name);
            artistName = itemView.findViewById(R.id.ai_tv_artist_name);
            primaryGenreNameAndDate =itemView.findViewById(R.id.ai_tv_genre_name_and_date);
            albumArt = itemView.findViewById(R.id.ai_iv);

        }

        private void bind(@NonNull Album album) {
            this.album = album;
            collectionName.setText(album.collectionName);
            artistName.setText(album.artistName);
            primaryGenreNameAndDate.setText(album.primaryGenreName + ", " + album.releaseDate);
            Picasso.get().load(album.artworkUrl100).into(albumArt);
        }

    }
}
