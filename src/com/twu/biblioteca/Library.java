package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manderso on 4/29/14.
 */
public class Library {

    private List<String> books;

    public Library(List<String> initialBooks) {

        this.books = initialBooks;
    }

    public String books() {
        if (books.size() == 0){
            return "";
        }

        List<String> otherBooks = new ArrayList<String>(books);
        String bookNames = otherBooks.remove(0);

        for (String book : otherBooks) {
            bookNames += "\n" + book;
        }
        return bookNames;
    }
}
