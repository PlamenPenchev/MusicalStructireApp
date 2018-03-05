package com.example.punked.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

/**Activity which holds the different titles as a list. The idea is to just browse it like a list.*/
public class TitlesActivity extends AppCompatActivity {
    private ArrayList<Song> songArrayList;
    private SongDB songDB;
    private Button goBackTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titles);
        /**Loading the data from the DB and filling up the ArrayList*/
        songDB = new SongDB(this.getApplicationContext());
        songArrayList = songDB.getSongsNoDuplicates();
        /**A Button to go to the previous activity*/
        goBackTop = (Button) findViewById(R.id.go_back_titles_top);
        goBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**Loading up the data to the Custom Adapter and providing the List View*/
        TitleAdapter titleAdapter = new TitleAdapter(this, songArrayList);
        ListView listView = findViewById(R.id.titles_list);
        listView.setAdapter(titleAdapter);
    }
}
