package de.bht.pr2.lab03.classes;

public class AudioBook extends Book {
    protected String playMode;
    public AudioBook(String titel, BookType type, float price, int releaseDate, String playMode) {
        super(titel, type, price, releaseDate);
        this.playMode = playMode;
    }

    public String getPlayMode() {
        return playMode;
    }

    public void setPlayMode(String playMode) {
        this.playMode = playMode;
    }
}
