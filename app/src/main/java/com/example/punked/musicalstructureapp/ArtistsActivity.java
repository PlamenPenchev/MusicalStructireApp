package com.example.punked.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
/**Activity which holds the different artists*/
public class ArtistsActivity extends AppCompatActivity {
    /**Preparing an array which will hold our data*/
    private ArrayList<String> artistsList = new ArrayList<String>();
    private SongDB songs;
    private Button goBackTop;
    private String selectedArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        /**Loading the data from the DB and filling up the ArrayList*/
        songs = new SongDB(this.getApplicationContext());
        artistsList = songs.getOnlyArtists();
        /**A Button to go to the previous activity*/
        goBackTop = (Button) findViewById(R.id.go_back_artists_top);
        goBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**Loading up the data to the Custom Adapter and providing the List View*/
        ArtistAdapter artistAdapter = new ArtistAdapter(this, artistsList);
        ListView listView = (ListView) findViewById(R.id.artist_list);
        listView.setAdapter(artistAdapter);
        /**Setting up an OnItemClickListener so when the User taps on an artist he will be navigated
         * to the songs of the chosen artist*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedArtist = (String) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ArtistsActivity.this, ArtistDetailsActivity.class);
                intent.putExtra("artistName",selectedArtist);
                startActivity(intent);
            }
        });
    }
}
