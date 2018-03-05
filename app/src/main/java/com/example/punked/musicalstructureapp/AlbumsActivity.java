package com.example.punked.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import java.util.ArrayList;

/**This activity displays the albums in a as a list and provides the user with teh opportunity to
 * select and album as a category and browse the songs within it.*/
public class AlbumsActivity extends AppCompatActivity {
    private ArrayList<String> albums = new ArrayList<String>();
    private SongDB songDB;
    private Button goBackTop;
    private String selectedAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        /**Loading the data from the DB and filling up the ArrayList*/
        songDB = new SongDB(this.getApplicationContext());
        albums = songDB.getOnlyAlbums();
        /**A Button to go to the previous activity*/
        goBackTop = (Button) findViewById(R.id.go_back_albums_top);
        goBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**Loading up the data to the Custom Adapter and providing the Grid View*/
        ArrayAdapter<String> albumsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, albums);
        GridView gridView = (GridView) findViewById(R.id.albums_grid);
        gridView.setAdapter(albumsAdapter);
        /**Setting up an OnItemClickListener so when the User taps on an artist he will be navigated
         * to the songs of the chosen album*/

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedAlbum = (String) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(AlbumsActivity.this, AlbumDetailsActivity.class);
                intent.putExtra("albumName",selectedAlbum);
                startActivity(intent);
            }
        });

    }
}
