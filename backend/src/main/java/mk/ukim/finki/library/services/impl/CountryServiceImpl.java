package mk.ukim.finki.library.services.impl;

import mk.ukim.finki.library.models.Country;
import mk.ukim.finki.library.models.exceptions.CountryNotFoundException;
import mk.ukim.finki.library.repositories.CountryRepository;
import mk.ukim.finki.library.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService
{
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {this.countryRepository = countryRepository;}

    @Override
    public List<Country> findAll()
    {
        return this.countryRepository.findByOrderByIdAsc();
    }

    @Override
    public Optional<Country> findById(Long id)
    {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> createCountry(Country country)
    {
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> updateCountry(Long id, Country countryDto)
    {
        Country country = this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));

        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());

        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteCountry(Long id)
    {
        this.countryRepository.deleteById(id);
    }
}
