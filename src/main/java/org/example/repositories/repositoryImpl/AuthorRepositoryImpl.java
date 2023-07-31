package org.example.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.DataBaseConfig;
import org.example.entities.Author;
import org.example.entities.Publisher;
import org.example.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    private final EntityManager entityManager = DataBaseConfig.getEntityManager();
    @Override
    public Author saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);

//        Query query = entityManager.createNativeQuery("""
//                insert into authors values (first_name = ?,last_name = ?, email = ?,date_of_birth = ?, country = ?, gender = ?)
//                """);

        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public Author getAuthorById(Long authorId) {
        entityManager.getTransaction().begin();
      //  Author author = entityManager.createQuery("select a from Author a where a.id=:authorId", Author.class).setParameter("authorId", authorId).getSingleResult();
        Author author = entityManager.find(Author.class, authorId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public String deleteAuthorById(Long authorId) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, authorId);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author.getLastName()+" is successfully deleted!!!";
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        entityManager.getTransaction().begin();
     //   Author author = entityManager.createQuery("select a from Author a where a.id=:authorId", Author.class).setParameter("authorId", authorId).getSingleResult();
        Author author = entityManager.find(Author.class, authorId);
        author.setFirstName(newAuthor.getFirstName());
        author.setLastName(newAuthor.getLastName());
        author.setEmail(newAuthor.getEmail());
        author.setDateOfBirth(newAuthor.getDateOfBirth());
        author.setCountry(newAuthor.getCountry());
        author.setGender(newAuthor.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author is successfully updated !!!";
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        entityManager.getTransaction().begin();
        List<Author>authors = new ArrayList<>();
        List<Publisher>publishers = new ArrayList<>();
        Author author = entityManager.find(Author.class, authorId);
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        authors.add(author);
        publishers.add(publisher);

        publisher.setAuthor(authors);
        author.setPublishers(publishers);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author is successfully assigned!";
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        List<Author> authors = entityManager.createQuery("select a from Author a join a.publishers p where p.id = :publisherId", Author.class).setParameter("publisherId", publisherId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return authors;
    }


}
