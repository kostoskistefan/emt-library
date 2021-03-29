package mk.ukim.finki.library.services;

import mk.ukim.finki.library.models.Author;
import mk.ukim.finki.library.models.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService
{
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> createAuthor(AuthorDto authorDto);

    Optional<Author> updateAuthor(Long id, AuthorDto authorDto);

    void deleteAuthor(Long id);
}
