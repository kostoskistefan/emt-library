package mk.ukim.finki.library.services;

import mk.ukim.finki.library.models.Book;
import mk.ukim.finki.library.models.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> takeBook(Long id);

    Optional<Book> createBook(BookDto bookDto);

    Optional<Book> updateBook(Long id, BookDto bookDto);

    Optional<Book> updateAvailableCopies(Long id, Integer availableCopies);

    void deleteBook(Long id);
}
