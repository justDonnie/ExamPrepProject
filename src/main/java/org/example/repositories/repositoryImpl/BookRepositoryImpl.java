package org.example.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.DataBaseConfig;
import org.example.entities.Book;
import org.example.entities.Publisher;
import org.example.repositories.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String updateBookAuthor(Long bookId, Long authorId) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);

        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author is successfully updated from Book !!!";
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Map<Book,Publisher> map = new HashMap<>();
        Book book = entityManager.find(Book.class, bookId);
        Publisher publisher = book.getPublisher();
        map.put(book,publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return map;
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("select b from Book b join Author a on b.author.id= :authorId", Book.class).setParameter("authorId", authorId).getResultList();
        entityManager.remove(books);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Book is successfully deleted !!!";
    }
}
