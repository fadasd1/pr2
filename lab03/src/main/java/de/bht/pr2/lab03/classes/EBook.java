package de.bht.pr2.lab03.classes;

public class EBook extends Book {
    protected int tolinoVersion;
    public EBook(String titel, BookType type, float price, int releaseDate, int tolinoVersion) {
        super(titel, type, price, releaseDate);
        this.tolinoVersion = tolinoVersion;
    }

    public int getTolinoVersion() {
        return tolinoVersion;
    }

    public void setTolinoVersion(int tolinoVersion) {
        this.tolinoVersion = tolinoVersion;
    }
}
