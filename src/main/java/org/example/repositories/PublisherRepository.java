package org.example.repositories;

import org.example.entities.Publisher;

import java.util.List;

public interface PublisherRepository {
    Publisher savePublisher(Publisher publisher);

    Publisher getPublisherById(Long publisherId);

    List<Publisher> getAllPublishers();
    String updatePublisher(Long publisherId, Publisher publisher);

    String deletePublisherByName(String publisherName);
}
