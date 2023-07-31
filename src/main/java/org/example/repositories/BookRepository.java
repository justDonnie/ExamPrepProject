package org.example.repositories;

import org.example.entities.Author;
import org.example.entities.Book;

public interface BookRepository {
    String saveBook(Book book);

    String updateBookAuthor(Long bookId, Author author);
}
