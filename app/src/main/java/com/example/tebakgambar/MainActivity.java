package com.example.tebakgambar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tebakgambar.adapter.ListGambarAdapter;
import com.example.tebakgambar.model.Gambar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvGambar;
    private ArrayList<Gambar> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGambar = findViewById(R.id.rv_gambar);
        rvGambar.setHasFixedSize(true);

        list.addAll(getListGambar());
        showRecycleList();
    }

    public ArrayList<Gambar> getListGambar(){
        String[] dataGambar = getResources().getStringArray(R.array.data_gambar);
        String[] namaGambar = getResources().getStringArray(R.array.nama_gambar);

        ArrayList<Gambar> listGambar = new ArrayList<>();
        for (int i = 0; i < dataGambar.length; i++){
            Gambar gambar = new Gambar();
            gambar.setImageUrl(dataGambar[i]);
            gambar.setName(namaGambar[i]);

            listGambar.add(gambar);
        }
        return listGambar;
    }

    private void showRecycleList(){
        rvGambar.setLayoutManager(new GridLayoutManager(this, 2));

        ListGambarAdapter listGambarAdapter = new ListGambarAdapter(list);
        rvGambar.setAdapter(listGambarAdapter);
    }
}