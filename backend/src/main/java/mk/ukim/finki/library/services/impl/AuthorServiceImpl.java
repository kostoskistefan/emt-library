package mk.ukim.finki.library.services.impl;

import mk.ukim.finki.library.models.Author;
import mk.ukim.finki.library.models.Country;
import mk.ukim.finki.library.models.dto.AuthorDto;
import mk.ukim.finki.library.models.exceptions.AuthorNotFoundException;
import mk.ukim.finki.library.models.exceptions.CountryNotFoundException;
import mk.ukim.finki.library.repositories.AuthorRepository;
import mk.ukim.finki.library.repositories.CountryRepository;
import mk.ukim.finki.library.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService
{
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository)
    {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll()
    {
        return this.authorRepository.findByOrderByIdAsc();
    }

    @Override
    public Optional<Author> findById(Long id)
    {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> createAuthor(AuthorDto authorDto)
    {
        Country country = this.countryRepository
                .findById(authorDto.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId()));

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);

        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public Optional<Author> updateAuthor(Long id, AuthorDto authorDto)
    {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        Country country = this.countryRepository
                .findById(authorDto.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId()));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country);

        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id)
    {
        this.authorRepository.deleteById(id);
    }
}
