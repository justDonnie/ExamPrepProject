package org.example.entities;
import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Genre;

import java.time.LocalDate;
import java.util.Date;





@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_gen"
    )
    @SequenceGenerator(
            name = "book_gen",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String country;
    private LocalDate publishedYear;
    private int price;
    @Enumerated (value = EnumType.STRING)
    private Genre genre;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private Publisher publisher;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private Author author;

    public Book( String name, String country, LocalDate publishedYear, int price, Genre genre) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }
}
