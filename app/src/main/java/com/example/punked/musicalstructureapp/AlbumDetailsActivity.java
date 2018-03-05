package com.example.punked.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/**This activity displays and plays the songs of the chosen album only*/
public class AlbumDetailsActivity extends AppCompatActivity {
    private ArrayList<Song> songArrayList = new ArrayList<Song>();
    private SongDB songDB;
    private String albumSearched;
    private Button goBackTop;
    private ImageButton playPause;
    private ImageView nowPlayingCover;
    private ImageView nextSong;
    private ImageView previousSong;
    private int position;
    private int lastPosition;
    private Song selectedSong;
    private boolean playing;
    private TextView nowPlayingTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        /**Loading the data from the DB and filling up the ArrayList with the provided info from
         * the previous activity*/
        songDB = new SongDB(this.getApplicationContext());
        Intent intent = getIntent();
        albumSearched = intent.getStringExtra("albumName");
        songArrayList = songDB.getSongsByAlbum(albumSearched);
        /**Setting up the playing to false so we can use it later to manage the currently playing songs*/
        playing = false;
        /**Connecting the views for the currently playing bar*/
        nowPlayingCover = (ImageView) findViewById(R.id.now_playing_cover);
        nowPlayingTitle = (TextView) findViewById(R.id.now_playing_song_name);
        playPause = (ImageButton) findViewById(R.id.playing_current_song);
        nextSong = (ImageView) findViewById(R.id.next_song);
        previousSong = (ImageView) findViewById(R.id.previuous_song);
        /**Loading up the data to the Custom Adapter and providing the List View*/
        SongAdapter songAdapter = new SongAdapter(this, songArrayList);
        final ListView listView = (ListView) findViewById(R.id.song_list);
        listView.setAdapter(songAdapter);
        /**A Button to go to the previous activity*/
        this.goBackTop = (Button) findViewById(R.id.go_back_songs_top);
        this.goBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**Setting up an OnItemClickListener so when the User taps on a song it will start playing
         * and the currently playing bar will be populated*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSong = (Song) adapterView.getItemAtPosition(i);
                lastPosition = adapterView.getCount() -1;
                position = i;
                playing = false;
                setPlayPause(playPause);
                /**If the chosen song does not have an album cover photo
                 * we will display the default cover, else we load it's own*/
                if (selectedSong.getAlbumCover() == null) {
                    nowPlayingCover.setImageResource(R.drawable.def_cover);
                } else {
                    nowPlayingCover.setImageBitmap(selectedSong.getAlbumCover());
                }
                nowPlayingTitle.setText(selectedSong.getTitle());
            }
        });
        /**Since selecting a song starts auto play we need to provide the functionality to the button itself*/
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPlayPause(playPause);
            }
        });
        /**Selecting the next song on the list to start playing*/
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedSong != null){
                    if(position ==lastPosition){
                        selectedSong = (Song) listView.getItemAtPosition(0);
                        position =0;
                    }else {
                        selectedSong = (Song) listView.getItemAtPosition(position + 1);
                        position++;
                    }
                    playing = false;
                    setPlayPause(playPause);
                    if (selectedSong.getAlbumCover() == null) {
                        nowPlayingCover.setImageResource(R.drawable.def_cover);
                    } else {
                        nowPlayingCover.setImageBitmap(selectedSong.getAlbumCover());
                    }
                    nowPlayingTitle.setText(selectedSong.getTitle());
                }
            }
        });
        /**Selecting the previous song on the list to start playing*/
        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedSong != null){
                    if (position ==0){
                        selectedSong = (Song) listView.getItemAtPosition(lastPosition);
                        position = lastPosition;
                    }else {
                        selectedSong = (Song) listView.getItemAtPosition(position - 1);
                        position--;
                    }
                    playing = false;
                    setPlayPause(playPause);
                    if (selectedSong.getAlbumCover() == null) {
                        nowPlayingCover.setImageResource(R.drawable.def_cover);
                    } else {
                        nowPlayingCover.setImageBitmap(selectedSong.getAlbumCover());
                    }
                    nowPlayingTitle.setText(selectedSong.getTitle());
                }
            }
        });
    }
    /**Toggle method to load the play and pause images for the button*/
    public void setPlayPause(ImageButton playPause){
        if (!playing) {
            playPause.setImageResource(android.R.drawable.ic_media_pause);
            playing = true;
        } else {
            playPause.setImageResource(android.R.drawable.ic_media_play);
            playing = false;
        }
    }
}
