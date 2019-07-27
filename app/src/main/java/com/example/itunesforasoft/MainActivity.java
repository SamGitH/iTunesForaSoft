package com.example.itunesforasoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.ui.AlbumFragment;
import com.example.itunesforasoft.ui.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Fragment listFragment = new ListFragment();

    public static List<Album> albumList= new ArrayList<Album>();

    void createAlbumList(){
        albumList.add(new Album("Sam",
                "Easy life1",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
        albumList.add(new Album("Sam",
                "Easy life2",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
        albumList.add(new Album("Sam",
                "Easy life3",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
        albumList.add(new Album("Sam",
                "Easy life4",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
        albumList.add(new Album("Sam",
                "Easy life5",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
        albumList.add(new Album("Sam",
                "Easy life6",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
        albumList.add(new Album("Sam",
                "Easy life7",
                "https://i.imgur.com/KLaSJHQ.jpg",
                "1999",
                "Rock"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createAlbumList();
//        Bundle arg = new Bundle();
//        arg.putParcelableArrayList("ALBUM_LIST", albumList);

        setContentView(R.layout.activity_main);
//        FragmentTransaction listFragmentTran =
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, listFragment).commit();
//        albumFragmentTran.attach(albumFragment).commit();
    }
}
