package mk.ukim.finki.library.models.dto;

import lombok.Data;
import mk.ukim.finki.library.models.enumerations.Category;

@Data
public class BookDto
{
    private String name;

    private Category category;

    private Long authorId;

    private Integer availableCopies;

    public BookDto(String name, Category category, Long authorId, Integer availableCopies)
    {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public String getName()
    {
        return name;
    }

    public Category getCategory()
    {
        return category;
    }

    public Long getAuthorId()
    {
        return authorId;
    }

    public Integer getAvailableCopies()
    {
        return availableCopies;
    }
}
