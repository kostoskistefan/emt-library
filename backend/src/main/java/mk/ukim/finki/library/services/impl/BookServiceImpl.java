package mk.ukim.finki.library.services.impl;

import mk.ukim.finki.library.models.Author;
import mk.ukim.finki.library.models.Book;
import mk.ukim.finki.library.models.dto.BookDto;
import mk.ukim.finki.library.models.exceptions.AuthorNotFoundException;
import mk.ukim.finki.library.models.exceptions.BookNotFoundException;
import mk.ukim.finki.library.repositories.AuthorRepository;
import mk.ukim.finki.library.repositories.BookRepository;
import mk.ukim.finki.library.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookServiceImpl implements BookService
{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository)
    {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll()
    {
        return this.bookRepository.findByOrderByIdAsc();
    }

    @Override
    public Optional<Book> findById(Long id)
    {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> takeBook(Long id)
    {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        if(book.getAvailableCopies() > 0)
            book.setAvailableCopies(book.getAvailableCopies() - 1);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> createBook(BookDto bookDto)
    {
        Author author = this.authorRepository
                .findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        Book book = new Book(
                bookDto.getName(),
                bookDto.getCategory(),
                author,
                bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> updateBook(Long id, BookDto bookDto)
    {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author = this.authorRepository
                .findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> updateAvailableCopies(Long id, Integer availableCopies)
    {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setAvailableCopies(availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id)
    {
        this.bookRepository.deleteById(id);
    }
}
