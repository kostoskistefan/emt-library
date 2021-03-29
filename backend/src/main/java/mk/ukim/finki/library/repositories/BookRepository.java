package mk.ukim.finki.library.repositories;

import mk.ukim.finki.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByOrderByIdAsc();
}
