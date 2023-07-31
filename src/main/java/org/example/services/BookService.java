package org.example.services;

import org.example.entities.Book;
import org.example.entities.Publisher;

import java.util.Map;

public interface BookService {
    String  saveBook(Book book);

    String updateBookAuthor(Long bookId, Long authorId);

    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId);

    String deleteBookByAuthorId( Long authorId);
}
