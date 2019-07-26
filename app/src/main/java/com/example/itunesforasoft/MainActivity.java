package com.example.itunesforasoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.itunesforasoft.ui.AlbumFragment;

public class MainActivity extends AppCompatActivity {

    Fragment albumFragment = new AlbumFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction albumFragmentTran = getSupportFragmentManager().beginTransaction();
        albumFragmentTran.attach(albumFragment).commit();
    }
}
