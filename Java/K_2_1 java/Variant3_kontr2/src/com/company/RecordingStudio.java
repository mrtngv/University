package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class RecordingStudio {

    private String name;
    private List<Singer> singers;

    public RecordingStudio(String name) {
        this.name = name;
        this.singers = new ArrayList<Singer>();
    }

    public void addSinger(Singer singer) {
        if (!singers.contains(singer)) {
            this.singers.add(singer);
        }
    }

    // Task 1
    public void writeTextInRockSong(Song song, String text) throws NotAppropriateCategoryException{
        if(song.getCategory()!=Category.ROCK)
            throw new NotAppropriateCategoryException("Category not Rock");
        else
            song.addSongTitle(text);

    }

    public void writeTextInSong(Song song, String text) {
        song.addSongTitle(text);
    }



    // Task 2
    public void saveSingersInFile(String filename) {
        try(FileWriter fileWriter = new FileWriter(filename,false)){

            for(int i =0;i<singers.size();i++){
                fileWriter.append(singers.get(i).getName()+" * ");
            }

        }catch (IOException e){
            System.err.println("IO issue");
        }
    }

    // Task 3
    public void serializeSong(Song song, String filename) {
        try(FileOutputStream fos=new FileOutputStream(filename); ObjectOutputStream outputStream = new ObjectOutputStream(fos);){
            outputStream.writeObject(song);

        }catch (IOException e){
            System.err.println("IO Error");
        }
    }

    // Task 3
    public Song deserializeSong(String filename) {
        try(FileInputStream fis = new FileInputStream(filename);ObjectInputStream inputStream = new ObjectInputStream(fis);){
            Song song = (Song) inputStream.readObject();
            return song;
        }catch (ClassNotFoundException ex){
            System.err.println("Class not found");
        }catch (IOException e){
            System.err.println("IO error");
        }
        return null;
    }

    // Task 4
    public boolean readSongName(Song song, String targetString) {
        String middle_end = song.getName().substring(song.getName().length()/2);
        if(middle_end.contains(targetString))
            return true;
        return false;
    }

    // Task 5
    public void recordSongs(Singer singer) {
        new Recording_By_Singer_Thread(singer);
    }

    @Override
    public String toString() {
        return "Ide{" +
                "name='" + name + '\'' +
                ", singers=" + singers +
                '}';
    }
}

class Recording_By_Singer_Thread implements Runnable{
    Singer singer;
    Thread recordingThread;

    Recording_By_Singer_Thread(Singer singer){
        this.singer = singer;
        recordingThread = new Thread(this);
        recordingThread.start();
    }

    @Override
    public void run() {
        this.singer.recordSongs();
    }
}