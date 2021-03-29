package mk.ukim.finki.library.controllers;

import mk.ukim.finki.library.models.Author;
import mk.ukim.finki.library.models.dto.AuthorDto;
import mk.ukim.finki.library.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/library/authors")
public class AuthorController
{
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {this.authorService = authorService;}

    @GetMapping
    public List<Author> getAllAuthors() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return this.authorService.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody AuthorDto authorDto)
    {
        return this.authorService.createAuthor(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto)
    {
        return this.authorService.updateAuthor(id, authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id)
    {
        this.authorService.deleteAuthor(id);

        if (this.authorService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
