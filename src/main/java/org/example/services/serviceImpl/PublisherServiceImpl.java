package org.example.services.serviceImpl;

import org.example.entities.Publisher;
import org.example.repositories.PublisherRepository;
import org.example.repositories.repositoryImpl.PublisherRepositoryImpl;
import org.example.services.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long publisherId) {
        return publisherRepository.getPublisherById(publisherId);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.getAllPublishers();
    }

    @Override
    public String updatePublisher(Long publisherId, Publisher newPublisher) {
        publisherRepository.updatePublisher(publisherId,newPublisher);
        return "Publisher is successfully updated !!!";
    }

    @Override
    public String deletePublisherByName(String publisherName) {
        publisherRepository.deletePublisherByName(publisherName);
        return "Publisher is successfully deleted !!!";
    }
}
