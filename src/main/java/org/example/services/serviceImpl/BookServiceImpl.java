package org.example.services.serviceImpl;

import org.example.entities.Book;
import org.example.entities.Publisher;
import org.example.repositories.BookRepository;
import org.example.repositories.repositoryImpl.BookRepositoryImpl;
import org.example.services.BookService;

import java.util.Map;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public String saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public String updateBookAuthor(Long bookId, Long authorId) {
        bookRepository.updateBookAuthor(bookId, authorId);
        return "Book successfully updated";
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        return bookRepository.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        bookRepository.deleteBookByAuthorId(authorId);
        return "";
    }
}
