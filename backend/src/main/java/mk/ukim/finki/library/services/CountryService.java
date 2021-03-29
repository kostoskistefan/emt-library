package mk.ukim.finki.library.services;

import mk.ukim.finki.library.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService
{
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> createCountry(Country country);

    Optional<Country> updateCountry(Long id, Country countryDto);

    void deleteCountry(Long id);
}
