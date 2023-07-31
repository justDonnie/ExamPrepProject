package org.example.services;

import org.example.entities.Author;
import org.example.entities.Publisher;

import java.util.List;

public interface AuthorService{
    Author saveAuthor(Author author);

    Author getAuthorById( Long authorId);

    String deleteAuthorById(Long authorId);

    String updateAuthor(Long authorId, Author newAuthor);

    String assignAuthorToPublisher(Long authorId, Long publisherId);

    List<Author> getAuthorsByPublisherId(Long publisherId);
}
