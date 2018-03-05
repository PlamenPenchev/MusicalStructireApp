package com.example.punked.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Punked on 3/4/2018.
 */
/**Custom Adapter to populate the List View for the Titles*/
public class TitleAdapter extends ArrayAdapter {
    public TitleAdapter(Context context, ArrayList<Song> songArrayList){
        super(context,0,songArrayList);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView ==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.title_list_item, parent, false);
        }
        /**Getting hold of the current item and setting the appropriate values for the current view*/
        Song currentSong = (Song) getItem(position);
        TextView currentAlbum = (TextView) listItemView.findViewById(R.id.title_list_item_name);
        currentAlbum.setText(currentSong.getTitle());
        return listItemView ;
    }
}
