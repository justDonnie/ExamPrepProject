package org.example.services.serviceImpl;

import org.example.entities.Author;
import org.example.repositories.AuthorRepository;
import org.example.repositories.repositoryImpl.AuthorRepositoryImpl;
import org.example.services.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository = new AuthorRepositoryImpl();
    @Override
    public Author saveAuthor(Author author) {
        authorRepository.saveAuthor(author);
        return author;
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.getAuthorById(authorId);
    }

    @Override
    public String deleteAuthorById(Long authorId) {
        return authorRepository.deleteAuthorById(authorId);
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        authorRepository.updateAuthor(authorId,newAuthor);
        return "";
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        authorRepository.assignAuthorToPublisher(authorId,publisherId);
        return "Author is successfully assigned!";
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        return authorRepository.getAuthorsByPublisherId(publisherId);
    }
}
