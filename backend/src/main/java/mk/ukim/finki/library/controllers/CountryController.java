package mk.ukim.finki.library.controllers;

import mk.ukim.finki.library.models.Country;
import mk.ukim.finki.library.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/library/countries")
public class CountryController
{
    private final CountryService countryService;

    public CountryController(CountryService countryService) {this.countryService = countryService;}

    @GetMapping
    public List<Country> getAllCountries()
    {
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id)
    {
        return this.countryService.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country)
    {
        return this.countryService.createCountry(country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody Country country)
    {
        return this.countryService.updateCountry(id, country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id)
    {
        this.countryService.deleteCountry(id);

        if (this.countryService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
