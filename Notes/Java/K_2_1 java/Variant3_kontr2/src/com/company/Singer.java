package com.company;

import java.util.ArrayList;
import java.util.List;

public class Singer {
    private String name;
    private List<Song> songs;

    public Singer(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public String getName(){
        return this.name;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void recordSongs() {
        try {
            for (Song song : songs) {
                System.out.println("Recording ... " + song);
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){
            System.err.println("Interupted error");
        }

    }

    @Override
    public String toString() {
        return "Creator{" +
                "name='" + name + '\'' +
                '}';
    }
}