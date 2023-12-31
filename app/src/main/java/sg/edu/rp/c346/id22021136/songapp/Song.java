package sg.edu.rp.c346.id22021136.songapp;

import androidx.annotation.NonNull;

public class Song {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int star;
    public Song(int id, String title, String singer, int year, int star) {
        this.id= id;
        this.title= title;
        this.singer= singer;
        this.year= year;
        this.star= star;
    }
    public static void add(Song newSong) {
    }

    public static int get(int i) {
        return i;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getSinger() { return singer;}
    public int getYear() { return year; }
    public int getStar() { return star; }

    @NonNull
    @Override
    public String toString() {
        return id + "\n" + title + "\n" + singer + "\n" + year + "\n" + star;}
}
