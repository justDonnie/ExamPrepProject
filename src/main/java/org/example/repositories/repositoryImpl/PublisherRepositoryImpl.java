package org.example.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.DataBaseConfig;
import org.example.entities.Publisher;
import org.example.repositories.PublisherRepository;
import org.hibernate.SessionFactory;

import java.util.List;


public class PublisherRepositoryImpl implements PublisherRepository{
    public final EntityManager entityManager=DataBaseConfig.getEntityManager();

    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long publisherId) {
        entityManager.getTransaction().begin();
       // Publisher publisher = entityManager.find(Publisher.class, publisherId);
        Publisher publisherId1 = entityManager.createQuery(" select p from Publisher p where p.id = :publisherId ", Publisher.class).setParameter("publisherId", publisherId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisherId1;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        entityManager.getTransaction().begin();
        List<Publisher> publisherList = entityManager.createQuery("select p.name from Publisher p order by p.name", Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisherList;
    }

    @Override
    public String updatePublisher(Long publisherId, Publisher newPublisher) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id = :publisherId",
                Publisher.class).setParameter("publisherId",publisherId).getSingleResult();
        publisher.setName(newPublisher.getName());
        publisher.setAddress(newPublisher.getAddress());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Publisher is successfully updated !!!";
    }

    @Override
    public String deletePublisherByName(String publisherName) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.name= :publisherName", Publisher.class).setParameter("publisherName", publisherName).getSingleResult();
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Publisher is successfully deleted !!!";
    }

}
