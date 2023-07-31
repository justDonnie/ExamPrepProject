package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Gender;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table (name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_gen"
    )
    @SequenceGenerator(
            name = "author_gen",
            sequenceName = "author_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String country;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @OneToMany (mappedBy = "author",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private List<Book> book;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private List<Publisher> publishers;

    public Author(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                '}';
    }
}
