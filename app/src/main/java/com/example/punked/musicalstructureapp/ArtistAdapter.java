package com.example.punked.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Punked on 3/4/2018.
 */
/**Custom Adapter to populate the List View for the Artists*/
public class ArtistAdapter extends ArrayAdapter {
    public ArtistAdapter(Context context, ArrayList<String> artists){
        super(context, 0 , artists);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.artist_list_item, parent, false);
        }
        /**Getting hold of the current item and setting the appropriate values for the current view*/
        String currentSong = (String) getItem(position);
        TextView artistName = listItemView.findViewById(R.id.artist_list_item_name);
        artistName.setText(currentSong);
        return listItemView ;
    }

}
