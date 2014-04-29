package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        String books = new Library(new ArrayList<String>()).books();
        System.out.println(books);
    }
}
