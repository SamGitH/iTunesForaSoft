package com.example.itunesforasoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.itunesforasoft.ui.AlbumFragment;
import com.example.itunesforasoft.ui.ListFragment;

public class MainActivity extends AppCompatActivity {

    Fragment listFragment = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentTransaction listFragmentTran =
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, listFragment).commit();
//        albumFragmentTran.attach(albumFragment).commit();
    }
}
