package com.example.punked.musicalstructureapp;

import android.graphics.Bitmap;

/**
 * Created by Punked on 3/3/2018.
 */
/**This is the model class. It models a Song with fields for artis, title, album and cover photo*/
public class Song {
    private String title;
    private String artist;
    private String album;
    private Bitmap albumCover;

    public Song(String title, String artist, String album, Bitmap albumCover){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.albumCover = albumCover;
    }
    /**Provided getters for each property of the class*/
    public String getTitle(){
        return this.title;
    }
    public String getArtist(){
        return this.artist;
    }
    public String getAlbum(){
        return this.album;
    }
    public Bitmap getAlbumCover(){
        return albumCover;
    }
}
