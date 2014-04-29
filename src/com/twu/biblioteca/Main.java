package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new BibliotecaController(System.out, new Library(initialBooks())).start();
    }
    private static List<String> initialBooks() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");
        return initialBooks;
    }

}
