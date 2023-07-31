package org.example.services.serviceImpl;

import org.example.entities.Author;
import org.example.entities.Book;
import org.example.repositories.BookRepository;
import org.example.repositories.repositoryImpl.BookRepositoryImpl;
import org.example.services.BookService;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public String saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public String updateBookAuthor(Long bookId, Author author) {
        bookRepository.updateBookAuthor(bookId,author);
        return "Book successfully updated";
    }
}
