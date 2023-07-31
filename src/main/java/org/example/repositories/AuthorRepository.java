package org.example.repositories;

import org.example.entities.Author;

import java.util.List;

public interface AuthorRepository {
    Author saveAuthor(Author author);

    Author getAuthorById(Long authorId);

    String deleteAuthorById(Long authorId);

    String updateAuthor(Long authorId, Author newAuthor);

    String assignAuthorToPublisher(Long authorId, Long publisherId);

    List<Author> getAuthorsByPublisherId(Long publisherId);

}
