package org.example.services;

import org.example.entities.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);

    Publisher getPublisherById(Long publisherId);

    List<Publisher> getAllPublishers();

    String updatePublisher(Long publisherId, Publisher publisher);

    String deletePublisherByName(String publisherName);
}
