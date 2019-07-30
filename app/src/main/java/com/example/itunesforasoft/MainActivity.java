package com.example.itunesforasoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.ui.ListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Album> albumList = new ArrayList<>();//Лист альбомов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startListFragment();
    }

    private void startListFragment(){//Запуск фрагмента с листом альбомов
        Fragment listFragment = new ListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, listFragment).commit();
    }
}
