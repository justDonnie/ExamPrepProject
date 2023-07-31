package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "publishers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Publisher {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "publisher_gen"
    )
    @SequenceGenerator(
            name = "publisher_gen",
            sequenceName = "publisher_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "publisher",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private List<Book> book;
    @ManyToMany (mappedBy = "publishers",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private List<Author> author;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher(String name, String address, List<Book> book, List<Author> author) {
        this.name = name;
        this.address = address;
        this.book = book;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
