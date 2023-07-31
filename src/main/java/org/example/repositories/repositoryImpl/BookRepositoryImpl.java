package org.example.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.DataBaseConfig;
import org.example.entities.Author;
import org.example.entities.Book;
import org.example.repositories.BookRepository;

public class BookRepositoryImpl implements BookRepository {
    private final EntityManager entityManager = DataBaseConfig.getEntityManager();
    @Override
    public String saveBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Book is successfully saved !!!";
    }

    @Override
    public String updateBookAuthor(Long bookId, Author author) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        if (book!=null){
            book.setAuthor(author);
            entityManager.getTransaction();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author is successfully updated from Book !!!";
    }
}
