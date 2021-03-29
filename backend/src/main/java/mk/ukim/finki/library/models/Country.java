package mk.ukim.finki.library.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countries")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    public Country() {}

    public Country(String name, String continent)
    {
        this.name = name;
        this.continent = continent;
    }
}
