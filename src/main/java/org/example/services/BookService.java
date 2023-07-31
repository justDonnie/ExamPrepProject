package org.example.services;

import org.example.entities.Author;
import org.example.entities.Book;

public interface BookService {
    String  saveBook(Book book);

    String updateBookAuthor(Long bookId, Author author);
}
