package de.bht.pr2.lab03.classes;

import java.util.Objects;

public abstract class Book {
// Formate:
    // Buch:     Titel ; Typ des Buches ; Preis ; Auflage
    // Ebuch:    Titel ; Typ des Buches ; Preis ; Auflage ; Tolino-Version
    // Hoerbuch: Titel ; Typ des Buches ; Preis ; Auflage ; Abspielmodus

    //data.add("Kingsbridge - Der Morgen einer neuen Zeit;Ebuch;19.99;2020;3");
    protected String titel;
    protected BookType type;
    protected float price;
    protected int releaseDate;

    public Book(String titel, BookType type, float price, int releaseDate) {
        this.titel= titel;
        this.type = type;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Book b = (Book) o;
        boolean finalCheck = this.titel.equals(b.titel) && Objects.equals(this.type, b.type) && this.price == b.price && this.releaseDate == b.releaseDate;
        return finalCheck;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(titel, type, price, releaseDate);
        return result;
    }


    @Override
    public String toString() {
        return "Book{" +
                "titel='" + titel + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

}
