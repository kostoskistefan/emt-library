package mk.ukim.finki.library.controllers;

import mk.ukim.finki.library.models.Book;
import mk.ukim.finki.library.models.dto.BookDto;
import mk.ukim.finki.library.models.enumerations.Category;
import mk.ukim.finki.library.models.exceptions.BookNotFoundException;
import mk.ukim.finki.library.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/library/books")
public class BookController
{
    private final BookService bookService;

    public BookController(BookService bookService) {this.bookService = bookService;}

    @GetMapping
    public List<Book> getAllBooks()
    {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id)
    {
        return this.bookService.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping("/take/{id}")
    public Book takeBook(@PathVariable Long id)
    {
        return this.bookService.takeBook(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return Stream.of(Category.values()).map(Enum::name).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto)
    {
        return this.bookService.createBook(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto)
    {
        return this.bookService.updateBook(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id)
    {
       this.bookService.deleteBook(id);

        if (this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
