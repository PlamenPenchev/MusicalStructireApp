package com.example.punked.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Punked on 3/3/2018.
 */
/**Custom Adapter to populate the List View for the Songs with corresponding picture, title and artist.*/
public class SongAdapter extends ArrayAdapter {
    public SongAdapter(Activity context, ArrayList<Song> songsArray){
        super(context,0,songsArray);
    }
    @Override
    public View getView(int position, View contextView, ViewGroup parent){
        View listItemView = contextView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        /**Getting hold of the current item and setting the appropriate values for the current view*/
        Song currentSong = (Song) getItem(position);
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song_title);
        songTitle.setText(currentSong.getTitle());
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name);
        artistName.setText(currentSong.getArtist());
        ImageView albumCover = (ImageView) listItemView.findViewById(R.id.cover);
        albumCover.setImageBitmap(currentSong.getAlbumCover());

        return listItemView;
    }
}
