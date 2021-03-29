package mk.ukim.finki.library.repositories;

import mk.ukim.finki.library.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByOrderByIdAsc();
}