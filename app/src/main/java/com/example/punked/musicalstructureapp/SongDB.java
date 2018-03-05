package com.example.punked.musicalstructureapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by Punked on 3/4/2018.
 */
/**This class is setting the Database for the app. An ArrayList of Songs is created and records are
 * added manually. Furthermore methods are provided to access the data sorted for the needs of the app*/
public class SongDB {
    private ArrayList<Song> songs = new ArrayList<Song>();
    private Set<Song> songsOrderredNoDuplicates = new HashSet<Song>();
    Context ctx;
    private Bitmap tdgCover;
    private Bitmap sotyCover;
    private Bitmap starsetCover;
    private Bitmap bbCover;

    public SongDB(Context context) {
        ctx = context;
        tdgCover = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.tdg_cover);
        bbCover = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.bb_cover);
        sotyCover = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.soty_cover);
        starsetCover = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.starset_cover);
        /**Adding records*/
        songs.add(new Song("Never Too Late",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Animal I Have Become",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Pain",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Wake Up",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("I Hate Everything About You",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Riot",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Over And Over",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Scared",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Running Away",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Time Of Dying",
                "Three Days Grace",
                "One X",
                tdgCover));
        songs.add(new Song("Diary Of Jane",
                "Breaking Benjamin",
                "Phobia",
                bbCover));
        songs.add(new Song("Dance With The Devil",
                "Breaking Benjamin",
                "Phobia",
                bbCover));
        songs.add(new Song("Breath",
                "Breaking Benjamin",
                "Phobia",
                bbCover));
        songs.add(new Song("And The Hero Will Drown",
                "Story Of The Year",
                "Page Avenue",
                sotyCover));
        songs.add(new Song("Until The Day I Die",
                "Story Of The Year",
                "Page Avenue",
                sotyCover));
        songs.add(new Song("Gravity Of You",
                "Starset",
                "Vessels",
                starsetCover));
        songs.add(new Song("Into The Unknown",
                "Starset",
                "Vessels",
                starsetCover));
    }
    /**Getter for the songs*/
    public ArrayList<Song> getSongs() {
        return songs;
    }
    /**Using the HashSet to save and load the list in order to get rid of the duplicates if any*/
    public ArrayList<Song> getSongsNoDuplicates() {
        for (Song item : songs) {
            songsOrderredNoDuplicates.add(item);
        }
        ArrayList<Song> songsNoDuplicates = new ArrayList<Song>();
        songsNoDuplicates.addAll(songsOrderredNoDuplicates);
        return songsNoDuplicates;
    }
    /**Using TreeSet to get the artists ordered without duplicate records and return the data*/
    public ArrayList<String> getOnlyArtists() {
        TreeSet<String> getArtistsNoDuplicates = new TreeSet<String>();
        for (Song item : songs) {
            getArtistsNoDuplicates.add(item.getArtist());
        }
        ArrayList<String> artistsOnly = new ArrayList<String>();
        artistsOnly.addAll(getArtistsNoDuplicates);
        return artistsOnly;
    }
    /**Using TreeSet to get the albums ordered without duplicate records*/
    public ArrayList<String> getOnlyAlbums() {
        TreeSet<String> getAlbumsNoDuplicates = new TreeSet<String>();
        for (Song item : songs) {
            getAlbumsNoDuplicates.add(item.getAlbum());
        }
        ArrayList<String> artistsOnly = new ArrayList<String>();
        artistsOnly.addAll(getAlbumsNoDuplicates);
        return artistsOnly;
    }
    /**Method to return the songs by an artist provided as a parameter*/
    public ArrayList<Song> getSongsByArtist(String artistName) {
        ArrayList<Song> songsByArtist = new ArrayList<Song>();
        for (Song item : songs) {
            if (item.getArtist().equals(artistName)) {
                songsByArtist.add(item);
            }
        }
        return songsByArtist;
    }
    /**Method to return the songs by an album provided as a parameter*/
    public ArrayList<Song> getSongsByAlbum(String albumName) {
        ArrayList<Song> songsByAlbum = new ArrayList<Song>();
        for (Song item : songs) {
            if (item.getAlbum().equals(albumName)) {
                songsByAlbum.add(item);
            }
        }
        return songsByAlbum;
    }

}
