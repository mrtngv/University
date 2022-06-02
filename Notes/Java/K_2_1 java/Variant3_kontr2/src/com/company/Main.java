package com.company;

public class Main {

    public static void main(String[] args) {

        RecordingStudio recordingStudio = new RecordingStudio("Martin's Recording Studio Industries");

        Song song1 = new Song("Fear of the dark",Category.ROCK,5.7);
        Song song2 = new Song("Phantom of the opera",Category.ROCK,6.5);
        Song song4 = new Song("Running fre",Category.ROCK,4.4);
        Song song3 = new Song("Baby",Category.POP,3.2);
        Song song5 = new Song("Miami",Category.POP,3.8);

        Singer maiden = new Singer("Iron Maiden");
        Singer bieber = new Singer("Justin Bieber");
        maiden.addSong(song1);
        maiden.addSong(song2);
        maiden.addSong(song4);
        bieber.addSong(song3);
        bieber.addSong(song5);

        recordingStudio.addSinger(maiden);
        recordingStudio.addSinger(bieber);

        //Task 1
        try {
            recordingStudio.writeTextInRockSong(song4, "e");
        }catch (NotAppropriateCategoryException e){
            System.err.println(e);
        }
        System.out.println(song4); // Running fre - Running free


        try {
            recordingStudio.writeTextInRockSong(song5, "e");
        }catch (NotAppropriateCategoryException e){ // Ще хвърли изключение защото не е рок..()
            System.err.println(e);
        }
        System.out.println(song5);

        //Task 2 :

        recordingStudio.saveSingersInFile("singers.txt");

        //Task 3:
        recordingStudio.serializeSong(song1,"song.ser"); // сериализация
        //
        Song copy_song1 = recordingStudio.deserializeSong("song.ser"); // Десериализация
        System.out.println(song1);
        System.out.println(copy_song1);

        //Task 4:
        // song 1 --> Fear of the dark
        System.out.println(recordingStudio.readSongName(song1,"dark")); // true защото dark се среща след средата
        System.out.println(recordingStudio.readSongName(song1,"Fear")); // false защото Fear не се среща след средата(а в началото)

        //Task 5: ще извикам 2 пъти функцията , променил съм recordSong в singer да чака 3 секнди във for-a за да се види по-хубаво в примера:
        //Можех и да въртя цикъл по списъка с певците , но скелета беше такъв и реших така да го направя
        recordingStudio.recordSongs(maiden);
        recordingStudio.recordSongs(bieber);

    }
}


