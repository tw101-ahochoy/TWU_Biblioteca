package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Library library = new Library(initialBooks());
        System.out.println(library.books());
    }

    private static List<String> initialBooks() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");
        return initialBooks;
    }
}
