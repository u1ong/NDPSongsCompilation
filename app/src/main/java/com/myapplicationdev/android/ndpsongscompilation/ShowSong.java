package com.myapplicationdev.android.ndpsongscompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSong extends AppCompatActivity {

    ListView lv;
    ArrayList<Songs> songList;
    ArrayAdapter adapter;
    Button btnStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = (ListView) this.findViewById(R.id.lv);
        btnStars = (Button) this.findViewById(R.id.btnShowList);

        DBHelper dbh = new DBHelper(this);
        songList = dbh.getAllSongs();
        dbh.close();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ShowSong.this, ShowSong.class);
                i.putExtra("song", songList.get(position));
                startActivity(i);
            }
        });

        btnStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowSong.this);
                songList.clear();
                songList.addAll(dbh.getAllSongsByStars(5));
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(this);
        songList.clear();
        songList.addAll(dbh.getAllSongs());
        dbh.close();
        adapter.notifyDataSetChanged();
    }
}