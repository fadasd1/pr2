package de.bht.pr2.lab03;
import de.bht.pr2.lab03.classes.AudioBook;
import de.bht.pr2.lab03.classes.BookType;
import de.bht.pr2.lab03.classes.EBook;
import de.bht.pr2.lab03.classes.RegBook;
import de.bht.pr2.lab03.classes.Book;
import de.bht.pr2.lab03.store.BookStore;

import java.util.*;

public class BookMain {

    static List<Book> bookList;

    public static void main(String[] args) {
        List<String> soldBooksList = BookStore.getSoldBooks();
        bookList = new ArrayList<>();
        fromSoldToObjectList(soldBooksList);
        System.out.println(calculateBookSum(bookList, BookType.REGBOOK) + "€ regBook");
        System.out.println(calculateBookSum(bookList, BookType.EBOOK) + "€ eBook");
        System.out.println(calculateBookSum(bookList, BookType.AUDIOBOOK) + "€ audioBook");
        System.out.println(calculateBookSum(bookList, BookType.BOOK) + "€ Book");
        System.out.println(tolino3Counter(bookList) + " Tolino 3 counter");
        System.out.println(countStreaming(bookList));
        printUniqueBook(bookList);
    }

    public static boolean fromSoldToObjectList(List<String> soldBooksList) {
        final String SEPARATOR = ";";
        boolean added = false;
        for(String s : soldBooksList) {
            String[] array = s.split(SEPARATOR);
            String title = array[0];
            BookType type = bookTypeFinder(array[1]);
            float price = Float.parseFloat(array[2]);
            int releaseDate = Integer.parseInt(array[3]);
            switch(array.length) {
                case 4 -> {
                    bookList.add(new RegBook(title, type, price, releaseDate));
                    added = true;
                }
                case 5 -> {
                    String tolino_playMode = array[4];
                    char firstChar = tolino_playMode.charAt(0);
                    if(firstChar >= 48 && firstChar <= 57 ) {
                        int tolinoVersion = Integer.parseInt(tolino_playMode);
                        bookList.add(new EBook(title, type, price, releaseDate, tolinoVersion));
                        added = true;
                    } else {
                        bookList.add(new AudioBook(title, type, price, releaseDate, tolino_playMode));
                        added = true;
                    }
                }
            }
        }
        return added;
    }

    public static BookType bookTypeFinder(String s) {
        BookType result = null;
        switch(s) {
			case "Buch" -> result = BookType.REGBOOK;
			case "Ebuch" -> result = BookType.EBOOK;
			case "Hoerbuch" -> result = BookType.AUDIOBOOK;
		}
		return result;
    }

    public static float calculateBookSum(List<Book> list, BookType type) {
        float sum = 0;
        if(type == BookType.BOOK) {
            for (Book b : list)
                sum += b.getPrice();
            return sum;
        }
        for(Book b : list) {
            if(b.getType().equals(type))
                sum += b.getPrice();
        }
        return sum;
    }

    public static int tolino3Counter(List<Book> list) {
        int result = 0;
        for(Book b : list) {
            if(b.getType() == BookType.EBOOK) {
                EBook e = (EBook) b;
                if(e.getTolinoVersion() == 3) result++;
            }
        }
        return result;
    }

    public static Map<String, Integer> countStreaming(List<Book> list) {
        Map<String, Integer> map = new HashMap<>();
        for(Book b : list) {
            if(b.getType() == BookType.AUDIOBOOK) {
                AudioBook a = (AudioBook) b;
                map.put(a.getPlayMode(), map.getOrDefault(a.getPlayMode(), 0) + 1);
            }
        }
        return map;
    }

        public static void printUniqueBook(List<Book> list) {
            Set<Book> seenSet = new HashSet<>();
            StringBuilder reg = new StringBuilder();
            StringBuilder e = new StringBuilder();
            StringBuilder a = new StringBuilder();
            int countReg = 0, countE = 0, countAudio = 0;

            for (Book b : list) {
                if (!seenSet.contains(b)) {
                    seenSet.add(b);
                    switch (b.getType()) {
                        case REGBOOK -> {
                            reg.append("Buch: ").append(b.getTitel()).append("(").append(b.getReleaseDate()).append(")\n");
                            countReg++;
                        }
                        case EBOOK -> {
                            e.append("Ebuch: ").append(b.getTitel()).append("(").append(b.getReleaseDate()).append(")\n");
                            countE++;
                        }
                        case AUDIOBOOK -> {
                            a.append("Hörbuch: ").append(b.getTitel()).append("(").append(b.getReleaseDate()).append(")\n");
                            countAudio++;
                        }
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            result.append("Bücher Anzahl: ").append(countReg).append("\n").append(reg).append("\n").append("Ebücher Anzahl: ").append(countE).append("\n").append(e).append("\n").append("Hörbücher Anzahl: ").append(countAudio).append("\n").append(a);

            System.out.println(result);
        }

    }

