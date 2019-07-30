package com.example.itunesforasoft.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesforasoft.MainActivity;
import com.example.itunesforasoft.R;
import com.example.itunesforasoft.models.Album;
import com.example.itunesforasoft.network.Search;

import static com.example.itunesforasoft.MainActivity.albumList;

//Фрагмент с листом альбомов
public class ListFragment extends Fragment implements View.OnClickListener {

    private final int BUT_SEARCH = R.id.fl_bt;
    public enum InfoText {//Состояния информационной строки
        START,
        EMPTY,
        NO_MATCH,
        INTERNET
    }

    private EditText editText;
    private RecyclerView recyclerView;
    private Button searchButton;
    private static TextView searchInfo;

    //Запускаем фрагмент с альбомом и передаём туда альбом
    private final AlbumAdapter albumAdapter = new AlbumAdapter(MainActivity.albumList, new AlbumAdapter.Listener() {
        @Override
        public void onAlbumClicked(Album album) {
            Bundle arg = new Bundle();
            Fragment albumFragment = new AlbumFragment();
            arg.putParcelable(AlbumFragment.ALBUM, album);
            albumFragment.setArguments(arg);
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().replace(R.id.activity_main, albumFragment).commit();
            }
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            findViews(view);
        }
        bind();
    }

    private void findViews(View view){
        editText = view.findViewById(R.id.fl_et);
        recyclerView = view.findViewById(R.id.fl_rv);
        searchButton = view.findViewById(BUT_SEARCH);
        searchInfo = view.findViewById(R.id.fl_tv);
    }

    private void bind (){
        recyclerView.setAdapter(albumAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchButton.setOnClickListener(this);
        if (albumList.isEmpty())
            setSearchInfo(InfoText.START);
        else
            setSearchInfo(InfoText.EMPTY);
    }

    public static void setSearchInfo(InfoText info){
        switch (info){
            case START:
                searchInfo.setText("Start search");
                break;
            case EMPTY:
                searchInfo.setText("");
                break;
            case NO_MATCH:
                searchInfo.setText("No matches found");
                break;
            case INTERNET:
                searchInfo.setText("Failed to load data, check your internet connection");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        //По нажатию на кнопку поиска собираем информацию из edittext парсим и передаём в loeder, для загрузки альбомов.
        if(v.getId() == BUT_SEARCH) {
            String albumKey;
            albumKey = editText.getText().toString();
            albumKey = albumKey.replace("\n", "");
            albumKey = albumKey.replace(" ", "+");
            Search.loadAlbums(albumKey, albumAdapter);
        }
    }
}
