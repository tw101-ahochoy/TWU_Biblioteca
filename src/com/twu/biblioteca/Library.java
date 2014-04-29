package com.twu.biblioteca;

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
        return books.get(0);
    }
}
