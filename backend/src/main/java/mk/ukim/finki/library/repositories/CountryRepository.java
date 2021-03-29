package mk.ukim.finki.library.repositories;

import mk.ukim.finki.library.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByOrderByIdAsc();
}